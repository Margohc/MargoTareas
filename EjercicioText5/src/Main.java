import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU VEHICULOS ---");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Mostrar vehiculos activos");
            System.out.println("3. Mostrar vehiculos con consumo mayor a X");
            System.out.println("4. Modificar estado por placa");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrar(sc);
                    break;
                case 2:
                    mostrarActivos();
                    break;
                case 3:
                    mostrarConsumoMayor(sc);
                    break;
                case 4:
                    modificarEstado(sc);
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

    private static void registrar(Scanner sc) {
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Consumo de combustible en litros: ");
        double consumo = sc.nextDouble();
        sc.nextLine();
        System.out.print("Estado (activo/inactivo): ");
        String estado = sc.nextLine();
        new Vehiculo(placa, marca, consumo, estado).registrarVehiculo(Archivos.archivoVehiculos);
    }

    private static void mostrarActivos() {
        for (Vehiculo vehiculo : Vehiculo.leerVehiculos(Archivos.archivoVehiculos)) {
            if (vehiculo.getEstado().equalsIgnoreCase("activo")) {
                System.out.println(vehiculo);
            }
        }
    }

    private static void mostrarConsumoMayor(Scanner sc) {
        System.out.print("Ingrese el consumo minimo: ");
        double limite = sc.nextDouble();
        for (Vehiculo vehiculo : Vehiculo.leerVehiculos(Archivos.archivoVehiculos)) {
            if (vehiculo.getConsumoCombustible() > limite) {
                System.out.println(vehiculo);
            }
        }
    }

    private static void modificarEstado(Scanner sc) {
        ArrayList<Vehiculo> vehiculos = Vehiculo.leerVehiculos(Archivos.archivoVehiculos);
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        Vehiculo vehiculo = Vehiculo.buscarVehiculo(vehiculos, placa);
        if (vehiculo == null) {
            System.out.println("Vehiculo no encontrado");
            return;
        }

        System.out.print("Nuevo estado (activo/inactivo): ");
        String estado = sc.nextLine();
        vehiculo.setEstado(estado);
        Vehiculo.guardarVehiculos(Archivos.archivoVehiculos, vehiculos);
        System.out.println("Estado modificado");
    }
}
