import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int[] numeros = {10, 20, 30, 40, 50};
        System.out.println("Ingrese una posicion:");
        int posicion = lector.nextInt();

        try {
            System.out.println("El valor es: " + numeros[posicion]);
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("La posicion ingresada no existe.");
        }
    }
}