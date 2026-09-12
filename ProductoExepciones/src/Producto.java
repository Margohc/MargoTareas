import java.util.ArrayList;

public class Producto {
	private String nombre;
	private double precio;
	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
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
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	static void agregarProductos(ArrayList<Producto> prods) {
		prods.add(new Producto("Coca*cola", 15));
		prods.add(new Producto("Fanta", 15));
		prods.add(new Producto("Sprite", 15));
		prods.add(new Producto("Aquarius", 15));
	}
	
	static Producto buscar(String nombre, ArrayList<Producto> prods) throws ProductoNoEncontradoException {
		Producto encontrado = null;
		for(Producto p : prods) {
			if(p.getNombre().equals(nombre)) {
				encontrado = p;
			}
		}
		if(encontrado == null) {
			throw new ProductoNoEncontradoException();
		}
		return encontrado;
	}
}
