import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = lector.nextLine();

        System.out.println("Ingrese la cantidad de horas trabajadas: ");
        int horas = lector.nextInt();

        System.out.println("Ingrese el valor de la hora: ");
        double valorHora = lector.nextDouble();

        Empleado empleado = new Empleado(nombre, horas, valorHora);

        System.out.println("El salario mensual del empleado "+ empleado.getNombre() + " es de $" + empleado.calcularSalario());
    }
}