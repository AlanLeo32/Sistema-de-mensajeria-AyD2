package modeloNegocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import dto.MensajeDTO;
import util.*;

public class Usuario {
	private String nickName;
	private String ip;
	private int puerto;
	private PriorityQueue<Usuario> agenda = new PriorityQueue<>(Comparator.comparing(Usuario::getNickName));
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
        Mensaje m = new Mensaje(contenido, LocalDateTime.now(), emisor, this);
        this.mensajes.add(m);
    }

    public ArrayList<Mensaje> getMensajes(){
      return this.mensajes;
    }
    public ArrayList<MensajeDTO> getChat(int puerto){
    	ArrayList<MensajeDTO> chat=new ArrayList<MensajeDTO>();
    	for (Mensaje m : mensajes) {
    	    if (m.getPuertoReceptor()==puerto) {
    	    	chat.add(new MensajeDTO(m.getContenido(), m.getFechayhora(),m.getEmisor(),m.getReceptor()));
    	    }
    	}
    	return chat;
    }
    // ******VA EN LA VISTA DE LA CONVERSACION******
   /* public void ListarMensajes(Usuario contacto) 
    {
    	    this.mensajes.sort(Comparator.comparing(Mensaje::getFechayhora));
        for (Mensaje m : mensajes)
        {
            if (m.getEmisor().equals(contacto) || m.getReceptor().equals(contacto))
        }
    }
	*/
	public PriorityQueue<Usuario> getAgenda() {
		return new PriorityQueue<>(agenda);
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
	
}
