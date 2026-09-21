import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU PEDIDOS ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Registrar pedido");
            System.out.println("4. Mostrar pedidos con detalle");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarProducto(sc);
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    registrarPedido(sc);
                    break;
                case 4:
                    mostrarPedidos();
                    break;
                case 5:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 5);

        sc.close();
    }

    private static void registrarProducto(Scanner sc) {
        System.out.print("ID producto: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        new Producto(id, nombre, precio).registrarProducto(Archivos.archivoProductos);
    }

    private static void mostrarProductos() {
        for (Producto producto : Producto.leerProductos(Archivos.archivoProductos)) {
            System.out.println(producto);
        }
    }

    private static void registrarPedido(Scanner sc) {
        System.out.print("ID pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine();
        System.out.print("Cliente: ");
        String cliente = sc.nextLine();
        System.out.print("Cantidad de productos en el pedido: ");
        int cantidad = sc.nextInt();

        ArrayList<Integer> idsProductos = new ArrayList<Integer>();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("ID producto " + (i + 1) + ": ");
            idsProductos.add(sc.nextInt());
        }

        new Pedido(idPedido, cliente, idsProductos).registrarPedido(Archivos.archivoPedidos);
    }

    private static void mostrarPedidos() {
        ArrayList<Producto> productos = Producto.leerProductos(Archivos.archivoProductos);
        ArrayList<Pedido> pedidos = Pedido.leerPedidos(Archivos.archivoPedidos);
        for (Pedido pedido : pedidos) {
            pedido.mostrarDetalle(productos);
        }
    }
}
