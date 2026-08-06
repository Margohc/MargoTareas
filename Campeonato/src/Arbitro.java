import java.time.LocalDate;

public class Arbitro {
	private String nombre;
	private LocalDate fechaNacimiento;
	private boolean status;
	public Arbitro(String nombre, LocalDate fechaNacimiento, boolean status) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.status = status;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
