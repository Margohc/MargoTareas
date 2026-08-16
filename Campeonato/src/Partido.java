import java.time.LocalDateTime;
import java.util.ArrayList;

public class Partido {
    private int nroFecha;
    private LocalDateTime fechaHora;
    private Cancha cancha;
    private Equipo local;
    private Equipo visitante;
    private ArrayList<Arbitro> arbitros;
    private int golesLocal;
    private int golesVisitante;
    private ArrayList<Amonestacion> tarjetas;
    private ArrayList<Gol> goles;

    // Constructor
    public Partido(int nroFecha, LocalDateTime fechaHora, Cancha cancha, Equipo local, Equipo visitante) {
        this.nroFecha = nroFecha;
        this.fechaHora = fechaHora;
        this.cancha = cancha;
        this.local = local;
        this.visitante = visitante;
        this.arbitros = new ArrayList<>();
        this.golesLocal = 0;
        this.golesVisitante = 0;
        this.tarjetas = new ArrayList<>();
        this.goles = new ArrayList<>();
    }

    // Getters y Setters
    public int getNroFecha() {
        return nroFecha;
    }

    public void setNroFecha(int nroFecha) {
        this.nroFecha = nroFecha;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public ArrayList<Amonestacion> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<Amonestacion> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public ArrayList<Gol> getGoles() {
        return goles;
    }

    public void setGoles(ArrayList<Gol> goles) {
        this.goles = goles;
    }

    // Métodos adicionales
    public void addArbitro(Arbitro arbitro) {
        arbitros.add(arbitro);
    }

    public void anotoGolLocal(Jugador jugador, int min) {
        goles.add(new Gol(jugador, min, true));
        local.anotoGolFavor();
        visitante.anotaronGolContra();
        jugador.anotoGol();
        golesLocal++;
    }

    public void anotoGolVisitante(Jugador jugador, int min) {
        goles.add(new Gol(jugador, min, true));
        local.anotaronGolContra();
        visitante.anotoGolFavor();
        jugador.anotoGol();
        golesVisitante++;
    }
    
    public void amonestacionLocal(String tipo, Jugador j, int min) {
    	tarjetas.add(new Amonestacion(j, min, tipo));
    	if(tipo.equals("Amarilla")) {
    		j.tieneTarjetaAmarilla();
    	}else if(tipo.equals("Roja")) {
    		j.expulsado();
    	}
    }
    
    public void amonestacionVisitante(String tipo, Jugador j, int min) {
    	tarjetas.add(new Amonestacion(j, min, tipo));
    	if(tipo.equals("Amarilla")) {
    		j.tieneTarjetaAmarilla();
    	}else if(tipo.equals("Roja")) {
    		j.expulsado();
    	}
    }

    public void terminarPartido() {
        if(golesLocal > golesVisitante) {
        	local.ganoPartido();
        	visitante.perdioPartido();
        }else if(golesVisitante>golesLocal) {
        	local.perdioPartido();
        	visitante.ganoPartido();
        }else {
        	local.empatoPartido();
        	visitante.empatoPartido();
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Partido [nroFecha=" + nroFecha + ", fechaHora=" + fechaHora + ", golesLocal=" + golesLocal + ", golesVisitante=" + golesVisitante + "]";
    }
}