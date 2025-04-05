package modeloNegocio;

import java.util.PriorityQueue;

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
}
