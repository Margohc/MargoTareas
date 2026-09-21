import java.io.*;
import java.util.*;

public class Cuenta {
    private int numeroCuenta;
    private String titular;
    private double saldo;

    public Cuenta(int numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + "]";
    }

    public boolean registrarCuenta(String archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            // Guardamos los datos en una sola linea, separados por #.
            pw.println(numeroCuenta + "#" + titular + "#" + saldo);
            System.out.println("Cuenta registrada con exito");
            return true;
        } catch (IOException exp) {
            System.out.println("Error al registrar la cuenta");
            return false;
        }
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0");
            return false;
        }
        saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0");
            return false;
        }
        if (monto > saldo) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        saldo -= monto;
        return true;
    }

    public static ArrayList<Cuenta> leerCuentas(String archivo) {
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        File file = new File(archivo);
        if (!file.exists()) {
            return cuentas;
        }

        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("#");
                int numeroCuenta = Integer.parseInt(tokens[0]);
                String titular = tokens[1];
                double saldo = Double.parseDouble(tokens[2]);
                cuentas.add(new Cuenta(numeroCuenta, titular, saldo));
            }
        } catch (Exception exp) {
            System.out.println("Error al leer las cuentas");
        }
        return cuentas;
    }

    public static Cuenta buscarCuenta(ArrayList<Cuenta> cuentas, int numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    public static boolean guardarCuentas(String archivo, ArrayList<Cuenta> cuentas) {
        try (FileWriter fw = new FileWriter(archivo);
             PrintWriter pw = new PrintWriter(fw)) {
            // Reescribimos el archivo completo despues de depositar o retirar.
            for (Cuenta cuenta : cuentas) {
                pw.println(cuenta.numeroCuenta + "#" + cuenta.titular + "#" + cuenta.saldo);
            }
            return true;
        } catch (IOException exp) {
            System.out.println("Error al guardar las cuentas");
            return false;
        }
    }
}
