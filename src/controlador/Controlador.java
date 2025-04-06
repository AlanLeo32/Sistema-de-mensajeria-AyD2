package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import dto.MensajeDTO;
import dto.UsuarioDTO;
import modeloNegocio.*;
import vistas.*;

public class Controlador implements ActionListener{
	protected IVista ventana;
	protected IVista ventana2;
	protected SistemaMensajeria sistemaMensajeria;
	
	public Controlador(SistemaMensajeria sistemaMensajeria) {
		this.ventana = new Ventanalogin(this);
		ventana.setVisible(true);
		this.sistemaMensajeria=sistemaMensajeria;
		this.ventana.setActionListener(this);
	}

	public IVista getVentana() {
		return ventana;
	}

	public SistemaMensajeria getSistemaMensajeria() {
		return sistemaMensajeria;
	}

	public void setVentana(IVista ventana) {
		this.ventana = ventana;
		this.ventana.setActionListener(this);
		this.ventana.setVisible(true);
	}
	public void setUser(String nickName,int puerto) {
		sistemaMensajeria.setUsuario(nickName,puerto);
		this.ventana.setVisible(false);
		this.setVentana(new VentanaPrincipal(this));
		this.ventana.setVisible(true);
		this.ventana.setActionListener(this);
	}
	public String getNickNamePuerto() {
		return "Nickname:"+sistemaMensajeria.getnickName()+"\nPuerto:"+sistemaMensajeria.getPuerto();
	}
	public List<UsuarioDTO> getAgenda() {
	    List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
	    PriorityQueue<Usuario> copia = new PriorityQueue<>(sistemaMensajeria.getAgenda());
	    Usuario user;
	    while (!copia.isEmpty()) {
	    	 user = copia.poll();
	         lista.add(new UsuarioDTO(user.getNickName(), user.getPuerto()));
	    }

	    return lista;
	}
	public IVista getVentana2() {
		return ventana2;
	}

	public void setVentana2(IVista ventana2) {
		this.ventana2 = ventana2;
		this.ventana2.setActionListener(this);
		this.ventana2.setVisible(true);
	}
	public void agregaContacto(String nickName,String ip,int puerto) {
		this.sistemaMensajeria.agregaContacto(nickName,ip,puerto);
	}

	public void cargaChat(int puerto) {
	
	  for (MensajeDTO msg : this.sistemaMensajeria.getChat(puerto)) {
		        if (ventana instanceof VentanaPrincipal) {
		            ((VentanaPrincipal) ventana).agregarChat(msg.getContenido(), msg.getFechayhora(), msg.getEmisor().getNickName());
		        }
		    }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		int puerto;
		switch (e.getActionCommand()) {
		case "REGISTRAR":
			
			if (this.ventana instanceof Ventanalogin) {
				Ventanalogin ventanalogin = (Ventanalogin) this.ventana;
				puerto=Integer.parseInt(ventanalogin.getPuerto());
				setUser(ventanalogin.getName(),puerto);
			}
			this.ventana.setVisible(false);
			this.setVentana(new VentanaPrincipal(this));
			break;
		case "AGREGAR CONTACTO":
			this.setVentana2(new VentanaAgregarContacto(this));
			break;
		case "NUEVA CONVERSACIÓN":
			this.setVentana2(new VentanaContactos(this));
			break;
		case "ENVIAR":
			
			break;
		case "INICIAR CONVERSACIÓN":
			
			if (this.ventana2 instanceof VentanaContactos) {
			    VentanaContactos ventanaContactos = (VentanaContactos) this.ventana2;
			    puerto=ventanaContactos.getPuerto(); 
			    this.cargaChat(puerto);
			    this.ventana2.dispose();
			}
			break;
		case "AGREGAR":
			if (this.ventana2 instanceof VentanaAgregarContacto) {
			    VentanaAgregarContacto ventanaAgregar = (VentanaAgregarContacto) this.ventana2;
			    String nick = ventanaAgregar.getNickname();
			    String ip = ventanaAgregar.getIp();
			    puerto = Integer.parseInt(ventanaAgregar.getPuerto());
			    this.agregaContacto(nick, ip, puerto);
			    ventana2.dispose(); // cerrar la ventana luego de agregar
			}
			break;
		default:
			break;
		}

	}
	
	
}
