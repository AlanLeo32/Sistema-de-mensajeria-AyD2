package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public IVista getVentana2() {
		return ventana2;
	}

	public void setVentana2(IVista ventana2) {
		this.ventana2 = ventana2;
		this.ventana2.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		/*case "REGISTRAR":
			this.ventana.setVisible(false);
			this.setVentana(new VentanaPrincipal(this));
			this.ventana.setVisible(true);
			break;*/
		case "AGREGAR CONTACTO":
			this.setVentana2(new VentanaAgregarContacto(this));
			this.ventana2.setVisible(true);
			break;
		case "NUEVA CONVERSACIÓN":
			this.setVentana2(new VentanaContactos(this));
			this.ventana2.setVisible(true);
			break;
		case "ENVIAR":
			
			break;
		case "INICIAR CONVERSACIÓN":
			this.ventana2.dispose();
			break;
		case "AGREGAR":
			this.ventana2.dispose();
			break;
		default:
			break;
		}

	}
	
	
}
