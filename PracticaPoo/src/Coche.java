
public class Coche {
	private String marca;
	private String modelo;
	private int year;
	private String color;
	
	public Coche(String marca, String modelo, int year, String color) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.year = year;
		this.color = color;
	}
	
	
	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	// metodo to string 
	public String toString() {
		return "El coche tiene las siguientes caracteristicas: "+ "\nMarca:"+this.marca + "\nModelo: " + this.modelo +"\nAño: " + this.year + "\ncolor: " + this.color;
	}

}
