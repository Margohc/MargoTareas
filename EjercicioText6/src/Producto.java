import java.io.*;
import java.util.*;

public class Producto {
    private int id;
    private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
    }

    public boolean registrarProducto(String archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(id + "#" + nombre + "#" + precio);
            System.out.println("Producto registrado con exito");
            return true;
        } catch (IOException exp) {
            System.out.println("Error al registrar el producto");
            return false;
        }
    }

    public static ArrayList<Producto> leerProductos(String archivo) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        File file = new File(archivo);
        if (!file.exists()) {
            return productos;
        }

        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("#");
                int id = Integer.parseInt(tokens[0]);
                String nombre = tokens[1];
                double precio = Double.parseDouble(tokens[2]);
                productos.add(new Producto(id, nombre, precio));
            }
        } catch (Exception exp) {
            System.out.println("Error al leer los productos");
        }
        return productos;
    }

    public static Producto buscarProducto(ArrayList<Producto> productos, int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
}
