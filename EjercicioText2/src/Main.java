import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU CUENTAS ---");
            System.out.println("1. Registrar cuenta");
            System.out.println("2. Mostrar cuentas");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Numero de cuenta: ");
                    int numero = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Titular: ");
                    String titular = sc.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();
                    new Cuenta(numero, titular, saldo).registrarCuenta(Archivos.archivoCuentas);
                    break;
                case 2:
                    ArrayList<Cuenta> cuentas = Cuenta.leerCuentas(Archivos.archivoCuentas);
                    for (Cuenta cuenta : cuentas) {
                        System.out.println(cuenta);
                    }
                    break;
                case 3:
                    moverDinero(sc, true);
                    break;
                case 4:
                    moverDinero(sc, false);
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

    private static void moverDinero(Scanner sc, boolean esDeposito) {
        ArrayList<Cuenta> cuentas = Cuenta.leerCuentas(Archivos.archivoCuentas);
        System.out.print("Numero de cuenta: ");
        int numero = sc.nextInt();
        System.out.print("Monto: ");
        double monto = sc.nextDouble();

        Cuenta cuenta = Cuenta.buscarCuenta(cuentas, numero);
        if (cuenta == null) {
            System.out.println("Cuenta no encontrada");
            return;
        }

        boolean realizado = esDeposito ? cuenta.depositar(monto) : cuenta.retirar(monto);
        if (realizado) {
            Cuenta.guardarCuentas(Archivos.archivoCuentas, cuentas);
            System.out.println("Operacion realizada");
        }
    }
}
