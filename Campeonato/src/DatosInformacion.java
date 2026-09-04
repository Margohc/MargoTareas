import java.time.LocalDate;

public class DatosInformacion {
private String nombre;
private LocalDate fechaNacimiento;
private boolean estadoCampeonato;

public DatosInformacion(String nombre, int a, int m, int d, boolean estadoCampeonato) {
	super();
	this.nombre = nombre;
	this.fechaNacimiento = LocalDate.of(a, m, d);
	this.estadoCampeonato = estadoCampeonato;
}

public DatosInformacion(String nombre, boolean estadoCampeonato) {
	super();
	this.nombre = nombre;
	this.estadoCampeonato = estadoCampeonato;
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

public boolean isEstadoCampeonato() {
	return estadoCampeonato;
}

public void setEstadoCampeonato(boolean estadoCampeonato) {
	this.estadoCampeonato = estadoCampeonato;
}

@Override
public String toString() {
	return "DatosInformacion [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", estadoCampeonato="
			+ estadoCampeonato + "]";
}



}




