
public class Cancha {
	private String nombre;
	private String direccion;
	private String ciudad;
	private Equipo equipoLocal;

	public Cancha(String nombre, String direccion, String ciudad, Equipo equipoLocal) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.equipoLocal = equipoLocal;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	@Override
	public String toString() {
		return "Cancha [nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", equipoLocal="
				+ equipoLocal + "]";
	}

}
