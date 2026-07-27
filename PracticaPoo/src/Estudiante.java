
public class Estudiante {
	private String nombre;
	private int edad;
	private double notaFinal;
	public Estudiante(String nombre, int edad, double notaFinal) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.notaFinal = notaFinal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
	//Metodo para saber si aprobo
	public boolean aprobo() {
        return notaFinal >= 6;
    }	
	
}
