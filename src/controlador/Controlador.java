package controlador;

import modeloNegocio.*;
import vistas.*;

public class Controlador {
	protected IVista ventana;
	protected SistemaMensajeria sistemaMensajeria;
	
	public Controlador(SistemaMensajeria sistemaMensajeria) {
		this.ventana = new Ventanalogin(this);
		ventana.setVisible(true);
		this.sistemaMensajeria=sistemaMensajeria;
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
	}
	public String getNickNamePuerto() {
		return "Nickname:"+sistemaMensajeria.getnickName()+"\nPuerto:"+sistemaMensajeria.getPuerto();
	}
}
