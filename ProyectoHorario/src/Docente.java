
public class Docente {
	private String ci;
	private String nombre;
	public Docente(String ci, String nombre) {
		super();
		this.ci = ci;
		this.nombre = nombre;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Docente [ci=" + ci + ", nombre=" + nombre + "]";
	}
	
	

}
