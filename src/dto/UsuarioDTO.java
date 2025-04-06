package dto;

public class UsuarioDTO {
	private String nombre;
    private int puerto;
    private String ip;
	public UsuarioDTO(String nombre, int puerto,String ip) {
		super();
		this.nombre = nombre;
		this.puerto = puerto;
		this.ip=ip;
	}
	public String getNombre() {
		return nombre;
	}
	public String getIp() {
		return ip;
	}
	public int getPuerto() {
		return puerto;
	}
	@Override
	public String toString() {
		return nombre + "(ip=" + ip +",puerto=" + puerto +  ")";
	}
	

}
