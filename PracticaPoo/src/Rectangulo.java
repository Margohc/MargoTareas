
public class Rectangulo {
 private double base;
 private double altura;
 
 public Rectangulo(double base, double altura) {
	super();
	this.base = base;
	this.altura = altura;
 }
 
public double getBase() {
	return base;
}

 public void setBase(double base) {
	this.base = base;
 }

 public double getAltura() {
	return altura;
 }

 public void setAltura(double altura) {
	this.altura = altura;
 }

	//Metodos de instancia  
	public double calcularArea() {
		return this.base * this.altura;
	}
	}
 
//metodo to string 
