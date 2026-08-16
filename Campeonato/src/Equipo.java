
import java.util.*;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private boolean estadoEnCampeonato;
    private int golesFavor;
    private int golesContra;
    private int partidosGanados;
    private int partidosPerdidos;
    private int partidosEmpatados;

    // Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<Jugador>();
        this.estadoEnCampeonato = true;
        this.golesFavor = 0;
        this.golesContra = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
        this.partidosEmpatados = 0;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public boolean isEstadoEnCampeonato() {
        return estadoEnCampeonato;
    }

    public void setEstadoEnCampeonato(boolean estadoEnCampeonato) {
        this.estadoEnCampeonato = estadoEnCampeonato;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    // Métodos adicionales
    public void addJugador(String nombre, int dorsal, int d, int m, int a, boolean estado) {
        this.jugadores.add(new Jugador(nombre, dorsal, d, m, a, estado));
    }
    
    public void addJugador() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador:");
        String nom = lector.nextLine();
        System.out.println("Ingrese el dorsal del jugador:");
        int dor =  lector.nextInt();
        System.out.println("Ingrese el dia de nacimiento:");
        int dia =  lector.nextInt();
        System.out.println("Ingrese el mes de nacimiento:");
        int mes =  lector.nextInt();
        System.out.println("Ingrese el anio de nacimiento:");
        int a =  lector.nextInt();
        jugadores.add(new Jugador(nom, dor, dia, mes, a, true));
    }
    
    public void anotoGolFavor() {
        golesFavor++;
    }

    public void anotaronGolContra() {
        golesContra++;
    }

    public void ganoPartido() {
        partidosGanados++;
    }

    public void perdioPartido() {
        partidosPerdidos++;
    }

    public void empatoPartido() {
        partidosEmpatados++;
    }

    public int totalPartidosJugados() {
        return partidosGanados + partidosPerdidos + partidosEmpatados;
    }

    public int totalPuntosCampeonato() {
        return partidosGanados * 3 + partidosEmpatados; // Asumiendo que una victoria da 3 puntos
    }

    public void getNomina() {
    	//imprime el nombre y dorsal de los jugadores Ej(Diego Laguna 6)
    	System.out.println("Nómina del equipo "+this.nombre);
    	System.out.println("---------------------");
    	System.out.println("Jugador    Dorsal");
    	System.out.println("---------------------");
    	for(Jugador j:this.jugadores) {
    		System.out.println(j.toString());
    	}
    }
    // Método toString
    @Override
    public String toString() {
        return "Equipo [nombre=" + nombre + ", golesFavor=" + golesFavor + ", golesContra=" + golesContra + "]";
    }
}