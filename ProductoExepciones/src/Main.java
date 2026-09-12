import java.util.ArrayList;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto.agregarProductos(productos);
		try {
			Producto.buscar("Oreo", productos);
		} catch (ProductoNoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("No se arruino");
	}

}
