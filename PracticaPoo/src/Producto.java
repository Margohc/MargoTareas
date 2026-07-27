
public class Producto {
	private String nombre;
	private double precio;
	private double cantidadEnStock;
	public Producto(String nombre, double precio, double cantidadEnStock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getCantidadEnStock() {
		return cantidadEnStock;
	}
	public void setCantidadEnStock(double cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
	public double calcularValorTotal () {
		 return precio * cantidadEnStock;
	 } 

}
