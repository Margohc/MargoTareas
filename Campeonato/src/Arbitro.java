import java.time.LocalDate;

public class Arbitro {
	private String nombre;
	private LocalDate fechaNacimiento;
	private boolean estadoEnCampeonato;

	public Arbitro(String nombre, int dia, int mes, int year, boolean estadoEnCampeonato) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = LocalDate.of(year, mes, dia);
		this.estadoEnCampeonato = estadoEnCampeonato;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public boolean isEstadoEnCampeonato() {
		return estadoEnCampeonato;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setEstadoEnCampeonato(boolean estadoEnCampeonato) {
		this.estadoEnCampeonato = estadoEnCampeonato;
	}

	@Override
	public String toString() {
		return "Arbitro [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", estadoEnCampeonato="
				+ estadoEnCampeonato + "]";
	}

}
