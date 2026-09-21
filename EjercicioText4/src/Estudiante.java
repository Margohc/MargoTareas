import java.io.*;
import java.util.*;

public class Estudiante {
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudiante(String nombre, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double calcularPromedio() {
        // El promedio no se guarda en el archivo, se calcula cuando se necesita.
        return (nota1 + nota2 + nota3) / 3;
    }

    public boolean estaAprobado() {
        return calcularPromedio() >= 51;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2
                + ", nota3=" + nota3 + ", promedio=" + calcularPromedio() + "]";
    }

    public boolean registrarEstudiante(String archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(nombre + "#" + nota1 + "#" + nota2 + "#" + nota3);
            System.out.println("Estudiante registrado con exito");
            return true;
        } catch (IOException exp) {
            System.out.println("Error al registrar el estudiante");
            return false;
        }
    }

    public static ArrayList<Estudiante> leerEstudiantes(String archivo) {
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        File file = new File(archivo);
        if (!file.exists()) {
            return estudiantes;
        }

        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("#");
                String nombre = tokens[0];
                double nota1 = Double.parseDouble(tokens[1]);
                double nota2 = Double.parseDouble(tokens[2]);
                double nota3 = Double.parseDouble(tokens[3]);
                estudiantes.add(new Estudiante(nombre, nota1, nota2, nota3));
            }
        } catch (Exception exp) {
            System.out.println("Error al leer los estudiantes");
        }
        return estudiantes;
    }
}
