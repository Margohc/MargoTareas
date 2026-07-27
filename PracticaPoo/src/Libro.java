
public class Libro {
	private String titulo;
	private String autor;
	private int anioPublication;
	private double precio;
	public Libro(String titulo, String autor, int anioPublication, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublication = anioPublication;
		this.precio = precio;
	} 
	
	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public int getAnioPublication() {
		return anioPublication;
	}


	public void setAnioPublication(int anioPublication) {
		this.anioPublication = anioPublication;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String toString() {
		return "Titulo: "+this.titulo + "\nAutor: "+ this.autor +"\nAño de publicacion: " + this.anioPublication + "\nPrecio: " + this.precio;
	}
}
