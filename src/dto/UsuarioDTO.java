package dto;

public class UsuarioDTO {
	private String nombre;
    private int puerto;
	public UsuarioDTO(String nombre, int puerto) {
		super();
		this.nombre = nombre;
		this.puerto = puerto;
	}
	public String getNombre() {
		return nombre;
	}
	public int getPuerto() {
		return puerto;
	}
	@Override
	public String toString() {
	    return this.nombre + " (Puerto: " + this.puerto + ")";
	}

}
