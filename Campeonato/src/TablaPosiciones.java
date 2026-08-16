
import java.util.ArrayList;

public class TablaPosiciones {
    private ArrayList<Partido> partidos;
    private ArrayList<Equipo> equipos;

    // Constructor
    public TablaPosiciones(ArrayList<Partido> partidos, ArrayList<Equipo> equipos) {
        this.partidos = partidos;
        this.equipos = equipos;
    }

    // Getters y Setters
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    // Método para mostrar la tabla de posiciones
    public void mostrarTabla() {
        // Lógica para mostrar la tabla de posiciones
    }

    // Método toString
    @Override
    public String toString() {
        return "TablaPosiciones [partidos=" + partidos + ", equipos=" + equipos + "]";
    }
}