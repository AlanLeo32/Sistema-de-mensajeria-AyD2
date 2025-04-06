package sistemaMensajeria;

import java.time.LocalDateTime;

import controlador.Controlador;
import modeloNegocio.*;
import vistas.VentanaPrincipal;

public class Prueba {

	public static void main(String[] args) {
		Usuario u = new Usuario("Lucas", 1500);
		Usuario u1 = new Usuario("Alan", 3000);
		Usuario u2 = new Usuario("Pepe", 2000);
		
		SistemaMensajeria sMensajeria=new SistemaMensajeria();
		Controlador controlador=new Controlador(sMensajeria);
		SistemaMensajeria sMensajeria1=new SistemaMensajeria();
		Controlador controlador1=new Controlador(sMensajeria1);
		SistemaMensajeria sMensajeria2=new SistemaMensajeria();
		Controlador controlador2=new Controlador(sMensajeria2);
		//creo usuarios
		controlador.setUser(u.getNickName(),u.getPuerto());
		controlador1.setUser(u1.getNickName(),u1.getPuerto());
		controlador2.setUser(u2.getNickName(),u2.getPuerto());
		//agrego contactos
		controlador2.agregaContacto(u1.getNickName(), u1.getIp(), u1.getPuerto());
		controlador2.agregaContacto(u.getNickName(), u.getIp(), u.getPuerto());
		VentanaPrincipal ventana=new VentanaPrincipal(controlador);
		VentanaPrincipal ventana1=new VentanaPrincipal(controlador1);
		VentanaPrincipal ventana2=new VentanaPrincipal(controlador2);
		ventana.setTitle(u.getNickName());
		ventana1.setTitle(u1.getNickName());
		ventana2.setTitle(u2.getNickName());
		sMensajeria.iniciarServidor(u.getPuerto());
		sMensajeria1.iniciarServidor(u1.getPuerto());
		sMensajeria2.iniciarServidor(u2.getPuerto());
		controlador.setVentana(ventana);
		controlador1.setVentana(ventana1);
		controlador2.setVentana(ventana2);
		
		
	}

}
