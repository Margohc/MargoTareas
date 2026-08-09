import java.time.LocalDate;
import java.time.Period;

public class Jugador {
	private String nombre;
	private String dorsal;
	private LocalDate fechaNacimiento;
	private boolean estadoEnCampeonato;
	private int golesAnotados;
	private int tarjetasAmarillas;

	public Jugador(String nombre, String dorsal, int dia, int mes, int year, boolean estadoEnCampeonato,
			int golesAnotados, int tarjetasAmarillas) {
		super();
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.fechaNacimiento = LocalDate.of(year, mes, dia);
		this.estadoEnCampeonato = estadoEnCampeonato;
		this.golesAnotados = golesAnotados;
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	public Jugador(String nombre, String dorsal, int dia, int mes, int year) {
		super();
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.fechaNacimiento = LocalDate.of(year, mes, dia);
		this.estadoEnCampeonato = false;
		this.golesAnotados = 0;
		this.tarjetasAmarillas = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDorsal() {
		return dorsal;
	}

	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean estadoEnCampeonato() {
		return estadoEnCampeonato;
	}

	public void setEstadoEnCampeonato(boolean estadoEnCampeonato) {
		this.estadoEnCampeonato = estadoEnCampeonato;
	}

	public int getGolesAnotados() {
		return golesAnotados;
	}

	public void setGolesAnotados(int golesAnotados) {
		this.golesAnotados = golesAnotados;
	}

	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	public void setTarjetasAmarillas(int tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	public int getEdad() {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

	public void anotoGol() {
		golesAnotados++;
	}

	public boolean tieneTarjetaAmarilla() {
		return tarjetasAmarillas > 0;
	}

	public void expulsado() {
		estadoEnCampeonato = false;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", dorsal=" + dorsal + ", fechaNacimiento=" + fechaNacimiento
				+ ", estadoEnCampeonato=" + estadoEnCampeonato + ", golesAnotados=" + golesAnotados
				+ ", tarjetasAmarillas=" + tarjetasAmarillas + "]";
	}

}
