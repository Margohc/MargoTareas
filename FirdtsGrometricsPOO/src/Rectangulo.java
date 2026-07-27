
public class Rectangulo {
	private double base;
	private double altura;
	
	
	//Constructores
	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	
	public Rectangulo(double lado) {
		this.base = lado;
		this.altura = lado;
	}
	
	//Setters y Getters
	public void setBase(double base) {
		this.base = base;
	}
	
	public double getBase() {
		return this.base;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	
	//toString
	public String toString() {
		return "Es un rectangulo de base "+ this.base + " y altura " + this.altura;
	}
	
	// Metodos de instancia  
	public double calcularArea() {
		return this.base * this.altura;
	}
	
	public double calcularPerimetro() {
		return 2*this.base + 2*this.altura;
	}
}
