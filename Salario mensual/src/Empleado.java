public class Empleado {
    private String nombre;
    private int horasTrabajadas;
    private double valorHora;

    public Empleado(String nombre, int horasTrabajadas, double valorHora) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    public double calcularSalario() {
        return horasTrabajadas * valorHora;
    }

    public String getNombre() {
        return nombre;
    }
}
