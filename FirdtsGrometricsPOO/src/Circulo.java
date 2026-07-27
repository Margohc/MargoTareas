
public class Circulo {
	private double radio;
	
	
	public Circulo(double radio) {
		this.radio = radio;

	}
	
	//Setters y Getters
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
		
		
	public String toString() {
			return "Es un circulo de radio "+ this.radio;
		}
		

	

	public double calcularAreaCirculo() {
		return Math.PI* this.radio* this.radio;
	}

}
