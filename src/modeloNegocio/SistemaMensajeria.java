package modeloNegocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import dto.MensajeDTO;
import dto.UsuarioDTO;

public class SistemaMensajeria {
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
	            System.out.println("Servidor escuchando en puerto " + puerto);
	            while (true) {
	                Socket socket = serverSocket.accept();
	                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                String mensaje = entrada.readLine();
	                System.out.println("Mensaje recibido: " + mensaje);
	                entrada.close();
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

	public void enviarMensaje(UsuarioDTO contacto, String mensaje) {
	    try (Socket socket = new Socket(contacto.getIp(), contacto.getPuerto())) {
	        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
	        salida.println(mensaje);
	        salida.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Usuario ureceptor=this.buscarUsuarioPorDTO(contacto);
	    if(ureceptor!=null)
	    	this.usuario.enviarMensaje(mensaje, ureceptor);
	}
	
	
	public List<Usuario> getListaConversaciones() {
		return this.usuario.getListaConversaciones();
	}

}
