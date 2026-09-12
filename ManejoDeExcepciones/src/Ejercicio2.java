import java.util.*;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        int mes = 0;

        try {

            System.out.println("Ingrese una fecha en formato DD/MM/AA:");
            String fecha = lector.nextLine();

            String[] partes = fecha.split("/");

            int dia = Integer.parseInt(partes[0]);
            mes = Integer.parseInt(partes[1]);
            int year = Integer.parseInt(partes[2]);

        } catch (NumberFormatException ex) {

            System.out.println("El formato de fecha no es correcto");
        }

        if (mes == 1 || mes == 2 || mes == 3) {
            System.out.println("Es verano en el hemisferio sur");
        } else if (mes == 4 || mes == 5 || mes == 6) {
            System.out.println("Es otoño en el hemisferio sur");
        } else if (mes == 7 || mes == 8 || mes == 9) {
            System.out.println("Es invierno en el hemisferio sur");
        } else if (mes == 10 || mes == 11 || mes == 12) {
            System.out.println("Es primavera en el hemisferio sur");
        } else {
            System.out.println("Mes invalido");
        }
    }
}