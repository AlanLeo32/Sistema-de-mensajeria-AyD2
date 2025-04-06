package modeloNegocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import dto.MensajeDTO;
import dto.UsuarioDTO;
import util.*;

public class Usuario {
	private String nickName;
	private String ip;
	private int puerto;
	private PriorityQueue<Usuario> agenda = new PriorityQueue<>(Comparator.comparing(Usuario::getNickName));
	
	private List<Usuario> listaConversaciones = new LinkedList<>();

	private ArrayList<Mensaje> mensajes = new ArrayList<>();
	
	public Usuario(String nickName, int puerto) {
		super();
		this.nickName = nickName;
		this.ip = Util.IPLOCAL;
		this.puerto = puerto;
	}
	public Usuario(String nickName, int puerto,String ip) {
		super();
		this.nickName = nickName;
		this.ip =ip;
		this.puerto = puerto;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	@Override
	public String toString() {
		return String.format("%s", nickName);
	}
	
	public void enviarMensaje(String contenido, Usuario receptor) {
        Mensaje m = new Mensaje(contenido, LocalDateTime.now(), this, receptor);
        this.mensajes.add(m);
    }

    public void recibirMensaje(String contenido, Usuario emisor) {
    	this.agregarConversacion(emisor);
    	Mensaje m = new Mensaje(contenido, LocalDateTime.now(), emisor, this);
        this.mensajes.add(m);
        
    }
    //equals y hashCode ayudan a que el metodo contains en recibir y enviar msg
    //en la lista de conver compare solo por puerto y no el puntero del objeto
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return this.puerto == other.puerto;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(puerto);
    }


    public ArrayList<Mensaje> getMensajes(){
      return this.mensajes;
    }
    public ArrayList<MensajeDTO> getChat(int puerto,String ip){
    	ArrayList<MensajeDTO> chat=new ArrayList<MensajeDTO>();
    	for (Mensaje m : mensajes) {
    	    if (m.getReceptor().getPuerto()==puerto && m.getReceptor().getIp()==ip) {
    	    	chat.add(new MensajeDTO(m.getContenido(), m.getFechayhora(),m.getEmisor(),m.getReceptor()));
    	    }
    	}
    	return chat;
    }
   
	public PriorityQueue<Usuario> getAgenda() {
		return new PriorityQueue<>(agenda);
	}

	public List<Usuario> getListaConversaciones() {
	    return new ArrayList<>(listaConversaciones); 
	}


	public void agregarConversacion(Usuario contacto) {
		if(!this.agenda.contains(contacto)) {
			this.agenda.add(contacto);
		}
		if(this.listaConversaciones.isEmpty() || !this.listaConversaciones.contains(contacto)) {
        	
			this.listaConversaciones.add(0,contacto);
        }
	}
	public void setAgenda(PriorityQueue<Usuario> agenda) {
		this.agenda = agenda;
	}
	public void agregaContacto(Usuario contacto) {
		agenda.add(contacto);
		this.muestraContactos();
	}
	
	public void muestraContactos() {
		PriorityQueue<Usuario> agendaCopia = new PriorityQueue<>(agenda);
	    
	    while (!agendaCopia.isEmpty()) {
	        Usuario contacto = agendaCopia.poll();
	        System.out.println(contacto.getNickName());
	    }
	}

	public Usuario getBuscaContacto(int puerto) {
	    PriorityQueue<Usuario> agendaCopia = new PriorityQueue<>(agenda);
	    while (!agendaCopia.isEmpty()) {
	        Usuario contacto = agendaCopia.poll();
	        if (contacto.getPuerto() == puerto) {
	            return contacto;
	        }
	    }
	    return null; // No se encontró
	}

}
