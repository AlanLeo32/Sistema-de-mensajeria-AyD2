package dto;

import java.util.Objects;

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
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    UsuarioDTO other = (UsuarioDTO) obj;
	    return puerto == other.puerto && ip.equals(other.ip);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(ip, puerto);
	}


}
