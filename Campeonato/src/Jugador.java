import java.time.LocalDate;
import java.util.Scanner;
public class Jugador {
	private String nombreYapellido;
	private String dorsal;
	private LocalDate fechaNacimiento;
	private boolean estadoEnCampeonato;
	private int golesAnotados;
	private int tarjetasAmarillas;
	public Jugador(String nombreYapellido, String dorsal, int dia, int mes, int year , boolean estadoEnCampeonato,
			int golesAnotados, int tarjetasAmarillas) {
		super();
		this.nombreYapellido = nombreYapellido;
		this.dorsal = dorsal;
		this.fechaNacimiento = LocalDate.of(dia, mes, year);
		this.estadoEnCampeonato = estadoEnCampeonato;
		this.golesAnotados = golesAnotados;
		this.tarjetasAmarillas = tarjetasAmarillas;
	}
	public Jugador(LocalDate fechaNacimiento, boolean estadoEnCampeonato,
			int golesAnotados, int tarjetasAmarillas) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.estadoEnCampeonato = false;
		this.golesAnotados = 0;
		this.tarjetasAmarillas = 0;
	}
	public String getNombreYapellido() {
		return nombreYapellido;
	}
	public void setNombreYapellido(String nombreYapellido) {
		this.nombreYapellido = nombreYapellido;
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
	public boolean isEstadoEnCampeonato() {
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
	
	public static void golesAnotados() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Registre los goles anotados de este partido: ");
		int goles = scanner.nextInt();
		
	}
	
	
	

}
