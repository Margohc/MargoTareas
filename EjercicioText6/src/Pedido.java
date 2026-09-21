import java.io.*;
import java.util.*;

public class Pedido {
    private int idPedido;
    private String cliente;
    private ArrayList<Integer> idsProductos;

    public Pedido(int idPedido, String cliente, ArrayList<Integer> idsProductos) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.idsProductos = idsProductos;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente + ", idsProductos=" + idsProductos + "]";
    }

    public boolean registrarPedido(String archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            // El tercer dato guarda los IDs separados por coma: 1,2,3.
            pw.println(idPedido + "#" + cliente + "#" + convertirIdsATexto());
            System.out.println("Pedido registrado con exito");
            return true;
        } catch (IOException exp) {
            System.out.println("Error al registrar el pedido");
            return false;
        }
    }

    public double calcularTotal(ArrayList<Producto> productos) {
        double total = 0;
        for (int idProducto : idsProductos) {
            Producto producto = Producto.buscarProducto(productos, idProducto);
            if (producto != null) {
                total += producto.getPrecio();
            }
        }
        return total;
    }

    public void mostrarDetalle(ArrayList<Producto> productos) {
        System.out.println("\nPedido: " + idPedido);
        System.out.println("Cliente: " + cliente);
        System.out.println("Productos:");
        for (int idProducto : idsProductos) {
            Producto producto = Producto.buscarProducto(productos, idProducto);
            if (producto != null) {
                System.out.println("- " + producto.getNombre() + " Bs. " + producto.getPrecio());
            } else {
                System.out.println("- Producto con ID " + idProducto + " no encontrado");
            }
        }
        System.out.println("Total: Bs. " + calcularTotal(productos));
    }

    private String convertirIdsATexto() {
        String texto = "";
        for (int i = 0; i < idsProductos.size(); i++) {
            texto += idsProductos.get(i);
            if (i < idsProductos.size() - 1) {
                texto += ",";
            }
        }
        return texto;
    }

    public static ArrayList<Pedido> leerPedidos(String archivo) {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        File file = new File(archivo);
        if (!file.exists()) {
            return pedidos;
        }

        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("#");
                int idPedido = Integer.parseInt(tokens[0]);
                String cliente = tokens[1];
                ArrayList<Integer> ids = convertirTextoAIds(tokens[2]);
                pedidos.add(new Pedido(idPedido, cliente, ids));
            }
        } catch (Exception exp) {
            System.out.println("Error al leer los pedidos");
        }
        return pedidos;
    }

    private static ArrayList<Integer> convertirTextoAIds(String texto) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        String[] tokens = texto.split(",");
        for (String token : tokens) {
            ids.add(Integer.parseInt(token));
        }
        return ids;
    }
}
