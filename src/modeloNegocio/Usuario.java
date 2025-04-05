package modeloNegocio;

import java.util.Comparator;
import java.util.PriorityQueue;

import util.*;

public class Usuario {
	private String nickName;
	private String ip;
	private int puerto;
	private PriorityQueue<Usuario> agenda = new PriorityQueue<>(Comparator.comparing(Usuario::getNickName));
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
	
	
	public PriorityQueue<Usuario> getAgenda() {
		return new PriorityQueue<>(agenda);
	}
	public void setAgenda(PriorityQueue<Usuario> agenda) {
		this.agenda = agenda;
	}
	public void agregaContacto(Usuario contacto) {
		agenda.add(contacto);
		//this.muestraContactos();
	}
	/* para ver si agrego bien 
	public void muestraContactos() {
		PriorityQueue<Usuario> agenda2 = new PriorityQueue<>(Comparator.comparing(Usuario::getNickName));
        Usuario contacto;    
		while (!agenda.isEmpty()) {
			contacto=agenda.poll();
			agenda2.add(contacto);
            System.out.println(contacto.getNickName());
        }
		agenda=agenda2;
	}
	*/
}
