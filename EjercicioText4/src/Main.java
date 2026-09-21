import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ESTUDIANTES ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar todos");
            System.out.println("3. Mostrar aprobados");
            System.out.println("4. Mostrar reprobados");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrar(sc);
                    break;
                case 2:
                    mostrarPorEstado(0);
                    break;
                case 3:
                    mostrarPorEstado(1);
                    break;
                case 4:
                    mostrarPorEstado(2);
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
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nota 1: ");
        double nota1 = sc.nextDouble();
        System.out.print("Nota 2: ");
        double nota2 = sc.nextDouble();
        System.out.print("Nota 3: ");
        double nota3 = sc.nextDouble();
        new Estudiante(nombre, nota1, nota2, nota3).registrarEstudiante(Archivos.archivoEstudiantes);
    }

    private static void mostrarPorEstado(int estado) {
        ArrayList<Estudiante> estudiantes = Estudiante.leerEstudiantes(Archivos.archivoEstudiantes);
        for (Estudiante estudiante : estudiantes) {
            if (estado == 0 || (estado == 1 && estudiante.estaAprobado()) || (estado == 2 && !estudiante.estaAprobado())) {
                System.out.println(estudiante);
            }
        }
    }
}
