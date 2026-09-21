import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU PRODUCTOS ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Incrementar stock");
            System.out.println("4. Reducir stock");
            System.out.println("5. Mostrar productos con stock bajo");
            System.out.println("6. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrar(sc);
                    break;
                case 2:
                    mostrarTodos();
                    break;
                case 3:
                    cambiarStock(sc, true);
                    break;
                case 4:
                    cambiarStock(sc, false);
                    break;
                case 5:
                    mostrarStockBajo();
                    break;
                case 6:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 6);

        sc.close();
    }

    private static void registrar(Scanner sc) {
        System.out.print("Codigo: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Stock: ");
        int stock = sc.nextInt();
        new Producto(codigo, nombre, precio, stock).registrarProducto(Archivos.archivoProductos);
    }

    private static void mostrarTodos() {
        for (Producto producto : Producto.leerProductos(Archivos.archivoProductos)) {
            System.out.println(producto);
        }
    }

    private static void cambiarStock(Scanner sc, boolean incrementar) {
        ArrayList<Producto> productos = Producto.leerProductos(Archivos.archivoProductos);
        System.out.print("Codigo del producto: ");
        int codigo = sc.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        Producto producto = Producto.buscarProducto(productos, codigo);
        if (producto == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        if (incrementar) {
            producto.incrementarStock(cantidad);
            Producto.guardarProductos(Archivos.archivoProductos, productos);
            System.out.println("Stock incrementado");
        } else if (producto.reducirStock(cantidad)) {
            Producto.guardarProductos(Archivos.archivoProductos, productos);
            System.out.println("Stock reducido");
        }
    }

    private static void mostrarStockBajo() {
        for (Producto producto : Producto.leerProductos(Archivos.archivoProductos)) {
            if (producto.getStock() < 5) {
                System.out.println(producto);
            }
        }
    }
}
