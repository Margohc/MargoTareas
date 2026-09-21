import java.io.*;
import java.util.*;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
    }

    public boolean registrarProducto(String archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(codigo + "#" + nombre + "#" + precio + "#" + stock);
            System.out.println("Producto registrado con exito");
            return true;
        } catch (IOException exp) {
            System.out.println("Error al registrar el producto");
            return false;
        }
    }

    public void incrementarStock(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
        }
    }

    public boolean reducirStock(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0");
            return false;
        }
        if (cantidad > stock) {
            System.out.println("No hay stock suficiente");
            return false;
        }
        stock -= cantidad;
        return true;
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
                int codigo = Integer.parseInt(tokens[0]);
                String nombre = tokens[1];
                double precio = Double.parseDouble(tokens[2]);
                int stock = Integer.parseInt(tokens[3]);
                productos.add(new Producto(codigo, nombre, precio, stock));
            }
        } catch (Exception exp) {
            System.out.println("Error al leer los productos");
        }
        return productos;
    }

    public static Producto buscarProducto(ArrayList<Producto> productos, int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

    public static boolean guardarProductos(String archivo, ArrayList<Producto> productos) {
        try (FileWriter fw = new FileWriter(archivo);
             PrintWriter pw = new PrintWriter(fw)) {
            for (Producto producto : productos) {
                pw.println(producto.codigo + "#" + producto.nombre + "#" + producto.precio + "#" + producto.stock);
            }
            return true;
        } catch (IOException exp) {
            System.out.println("Error al guardar los productos");
            return false;
        }
    }
}
