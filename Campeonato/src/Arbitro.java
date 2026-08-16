
import java.time.LocalDate;

public class Arbitro {
    private String nombre;
    private LocalDate fechaNacimiento;
    private boolean estadoEnCampeonato;

    // Constructor
    public Arbitro(String nombre, LocalDate fechaNacimiento, boolean estadoEnCampeonato) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoEnCampeonato = estadoEnCampeonato;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstadoEnCampeonato() {
        return estadoEnCampeonato;
    }

    public void setEstadoEnCampeonato(boolean estadoEnCampeonato) {
        this.estadoEnCampeonato = estadoEnCampeonato;
    }

    // Método toString
    @Override
    public String toString() {
        return "Arbitro [nombre=" + nombre + "]";
    }
}
