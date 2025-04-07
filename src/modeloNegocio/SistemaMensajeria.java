package modeloNegocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.PriorityQueue;

import dto.MensajeDTO;
import dto.UsuarioDTO;

public class SistemaMensajeria extends Observable{
	private Usuario usuario;
	private static SistemaMensajeria sistema_instancia=null;
	
	 
	
	
	  private SistemaMensajeria() {
		
	}
	public static SistemaMensajeria get_Instancia() {
		if(sistema_instancia==null)
			sistema_instancia=new SistemaMensajeria();
		return sistema_instancia;
	} 
	
	public void setUsuario(String nickName,int puerto) {
		this.usuario = new Usuario(nickName,puerto);
	}
	public String getnickName() {
		return usuario.getNickName();
	}
	public int getPuerto() {
		return usuario.getPuerto();
	}
	public void agregaContacto(String nickName,String ip,int puerto) {
		Usuario contacto=new Usuario(nickName,puerto,ip);
		this.usuario.agregaContacto(contacto);
	}

	public PriorityQueue<Usuario> getAgenda() {
		return this.usuario.getAgenda();
	}

	public ArrayList<MensajeDTO> getChat(int puerto,String ip){
		return usuario.getChat(puerto,ip);
	}
	public ArrayList<Mensaje> getMensajes(){
      return usuario.getMensajes();
    }
	
	public void setContactoActual(int puerto,String ip) {
		Usuario contacto=usuario.getBuscaContacto(puerto);
		if(contacto!=null) {
			this.usuario.agregarConversacion(contacto);
		}
	}
	
	public void iniciarServidor(int puerto) {
	    Thread serverThread = new Thread(() -> {
	        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
	            while (true) {
	                Socket socket = serverSocket.accept();
	                try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
	                    Object recibido = ois.readObject();
	                    if (recibido instanceof Mensaje) {
	                        Mensaje mensaje = (Mensaje) recibido;
	                        this.usuario.recibirMensaje(mensaje);
	                        setChanged(); // importante
	     		           	notifyObservers(mensaje);
	     		         
	                        

	                       

	                        
	                    }
	                } catch (ClassNotFoundException e) {
	                    e.printStackTrace();
	                }
	                socket.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    });
	    serverThread.start();
	}

	public Usuario buscarUsuarioPorDTO(UsuarioDTO dto) {
	    for (Usuario u : usuario.getAgenda()) {
	        if (u.getPuerto() == dto.getPuerto() && u.getIp()== dto.getIp()) {
	            return u;
	        }
	    }
	    return null; // o lanzar excepción si querés asegurarte que esté
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
	public void enviarMensaje(UsuarioDTO contacto, String mensaje) {
	    try (Socket socket = new Socket(contacto.getIp(), contacto.getPuerto())) {
	    	   ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	    	   Usuario ureceptor=this.buscarUsuarioPorDTO(contacto);
	    	   Mensaje msg;
	    	   if(ureceptor!=null) {
	    		   msg=new Mensaje(mensaje,LocalDateTime.now(),this.usuario,ureceptor);
	    		   
	    		   oos.writeObject(msg);
	    		   oos.flush();
		    	   oos.close();
		    	   this.usuario.guardarMensaje(msg);
		    	   setChanged(); // importante
			       notifyObservers(msg);
	    	   }

	    } catch (IOException e) {
	    	setChanged(); // importante
	        notifyObservers(e);
	    }
	}
	
	
	public List<Usuario> getListaConversaciones() {
		return this.usuario.getListaConversaciones();
	}

}
