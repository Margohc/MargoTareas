import java.io.*;
import java.util.*;

public class Vehiculo {
    private String placa;
    private String marca;
    private double consumoCombustible;
    private String estado;

    public Vehiculo(String placa, String marca, double consumoCombustible, String estado) {
        this.placa = placa;
        this.marca = marca;
        this.consumoCombustible = consumoCombustible;
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public double getConsumoCombustible() {
        return consumoCombustible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", marca=" + marca + ", consumoCombustible="
                + consumoCombustible + ", estado=" + estado + "]";
    }

    public boolean registrarVehiculo(String archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(placa + "#" + marca + "#" + consumoCombustible + "#" + estado);
            System.out.println("Vehiculo registrado con exito");
            return true;
        } catch (IOException exp) {
            System.out.println("Error al registrar el vehiculo");
            return false;
        }
    }

    public static ArrayList<Vehiculo> leerVehiculos(String archivo) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        File file = new File(archivo);
        if (!file.exists()) {
            return vehiculos;
        }

        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("#");
                String placa = tokens[0];
                String marca = tokens[1];
                double consumo = Double.parseDouble(tokens[2]);
                String estado = tokens[3];
                vehiculos.add(new Vehiculo(placa, marca, consumo, estado));
            }
        } catch (Exception exp) {
            System.out.println("Error al leer los vehiculos");
        }
        return vehiculos;
    }

    public static Vehiculo buscarVehiculo(ArrayList<Vehiculo> vehiculos, String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    public static boolean guardarVehiculos(String archivo, ArrayList<Vehiculo> vehiculos) {
        try (FileWriter fw = new FileWriter(archivo);
             PrintWriter pw = new PrintWriter(fw)) {
            for (Vehiculo vehiculo : vehiculos) {
                pw.println(vehiculo.placa + "#" + vehiculo.marca + "#" + vehiculo.consumoCombustible + "#" + vehiculo.estado);
            }
            return true;
        } catch (IOException exp) {
            System.out.println("Error al guardar los vehiculos");
            return false;
        }
    }
}
