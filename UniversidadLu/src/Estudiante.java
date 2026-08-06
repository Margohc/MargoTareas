import java.util.*;

public class Estudiante {
	
	private String nombre, apellido;
	private double nota1, nota2;
	
	public Estudiante(String nombre, String apellido, double nota1, double nota2) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	//Metodos de instancia

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	@Override
	public String toString() {
		return this.apellido + " " + this.nombre;
	}
	
	public double notaHabilitacion() {
		return (this.nota1+this.nota2)/2;
	}
	
	//Metodos de clase
	
	public static Estudiante leerEstudiante() {
		Scanner lector1 = new Scanner(System.in);
		System.out.println("*****Registro de Estudiante*******");
		System.out.println("Ingrese el nombre:");
		String nom = lector1.nextLine();
		System.out.println("Ingrese el apellido:");
		String ape = lector1.nextLine();
		System.out.println("Ingrese la nota 1:");
		double n1 = lector1.nextDouble();
		System.out.println("Ingrese la nota 2:");
		double n2 = lector1.nextDouble();
		
		return new Estudiante(nom, ape, n1, n2);
	}
	
	public static void mostrarEstudiantes(ArrayList<Estudiante> estudiantes) {
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante);
		}
		
	}
	

	
	public static boolean mostrarEstudiantesNotasHabilitados(ArrayList<Estudiante> estudiantes) {
		boolean eximidos = false;
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante+" "+estudiante.getNota1()+" "+estudiante.getNota2()+" "+estudiante.notaHabilitacion());
			if (estudiante.notaHabilitacion()>=95) {
				eximidos = true;
			}
		}
		return true;
	}
	
}
