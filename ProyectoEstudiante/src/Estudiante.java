
public class Estudiante {
	private String apellido;
	private String nombre;
	private int notasPrimerParcial;
	private int notasSegundoParcial;
	public Estudiante(String apellido, String nombres, int notasPrimerParcial, int notasSegundoParcial) {
		super();
		this.apellido = apellido;
		this.nombre = nombres;
		this.notasPrimerParcial = notasPrimerParcial;
		this.notasSegundoParcial = notasSegundoParcial;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNotasPrimerParcial() {
		return notasPrimerParcial;
	}
	public void setNotasPrimerParcial(int notasPrimerParcial) {
		this.notasPrimerParcial = notasPrimerParcial;
	}
	public int getNotasSegundoParcial() {
		return notasSegundoParcial;
	}
	public void setNotasSegundoParcial(int notasSegundoParcial) {
		this.notasSegundoParcial = notasSegundoParcial;
	}
	
	public int calcularHabilitacion () {
		int promedio =0;
		return  promedio = (notasPrimerParcial*notasSegundoParcial)/2;
	}
	
}