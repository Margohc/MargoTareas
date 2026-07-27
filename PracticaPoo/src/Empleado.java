
public class Empleado {
	private String nombre;
	private int edad;
	private double salarioBase;
	public Empleado(String nombre, int edad, double salarioBase) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.salarioBase = salarioBase;
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
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public void aumentoSalario(double porcentaje) {
        salarioBase += salarioBase * porcentaje / 100;
	}

}
