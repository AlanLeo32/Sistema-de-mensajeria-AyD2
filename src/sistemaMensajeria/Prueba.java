package sistemaMensajeria;

import java.time.LocalDateTime;
import modeloNegocio.*;

public class Prueba {

	public static void main(String[] args) {
		
		Usuario u1 = new Usuario("Lucas", 1025);
		Usuario u2 = new Usuario("Alan", 1026);
		LocalDateTime fecha = LocalDateTime.now();		
		Mensaje m = new Mensaje("hola como estas", fecha , u1, u2);
		System.out.println(m);

	}

}
