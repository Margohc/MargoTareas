import java.time.LocalDateTime;
import java.util.ArrayList;

public class Partido {
	private int nroFecha;
	private LocalDateTime fechaHora;
	private Cancha cancha;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private ArrayList<Arbitro> arbitros;
	private int golesLocal;
	private int golesVisitante;
	private ArrayList<Amonestacion> tarjetas;
	private ArrayList<Gol> goles;
	private boolean partidoTerminado;

	public Partido(int nroFecha, int dia, int mes, int year, int hora, int min, Cancha cancha, Equipo equipoLocal,
			Equipo equipoVisitante) {
		super();
		this.nroFecha = nroFecha;
		this.fechaHora = LocalDateTime.of(year, mes, dia, hora, min);
		this.cancha = cancha;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.arbitros = new ArrayList<Arbitro>();
		this.golesLocal = 0;
		this.golesVisitante = 0;
		this.tarjetas = new ArrayList<Amonestacion>();
		this.goles = new ArrayList<Gol>();
		this.partidoTerminado = false;
	}

	public int getNroFecha() {
		return nroFecha;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public ArrayList<Arbitro> getArbitros() {
		return arbitros;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public ArrayList<Amonestacion> getTarjetas() {
		return tarjetas;
	}

	public ArrayList<Gol> getGoles() {
		return goles;
	}

	public boolean isPartidoTerminado() {
		return partidoTerminado;
	}

	public void setNroFecha(int nroFecha) {
		this.nroFecha = nroFecha;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public void setArbitros(ArrayList<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public void setTarjetas(ArrayList<Amonestacion> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public void setGoles(ArrayList<Gol> goles) {
		this.goles = goles;
	}

	public void setPartidoTerminado(boolean partidoTerminado) {
		this.partidoTerminado = partidoTerminado;
	}

	public void addArbitro(Arbitro arbitro) {
		arbitros.add(arbitro);
	}

	public void anotoGolLocal(Jugador jugador, int minuto) {
		Gol gol = new Gol(jugador, minuto, true);
		goles.add(gol);
		golesLocal++;
		jugador.anotoGol();
	}

	public void anotoGolVisitante(Jugador jugador, int minuto) {
		Gol gol = new Gol(jugador, minuto, true);
		goles.add(gol);
		golesVisitante++;
		jugador.anotoGol();
	}

	public void amonestacionLocal(Jugador jugador, int minuto, String tipo) {
		Amonestacion amonestacion = new Amonestacion(jugador, minuto, tipo);
		tarjetas.add(amonestacion);
		jugador.setTarjetasAmarillas(jugador.getTarjetasAmarillas() + 1);
	}

	public void amonestacionVisitante(Jugador jugador, int minuto, String tipo) {
		Amonestacion amonestacion = new Amonestacion(jugador, minuto, tipo);
		tarjetas.add(amonestacion);
		jugador.setTarjetasAmarillas(jugador.getTarjetasAmarillas() + 1);
	}

	public void terminarPartido() {
		partidoTerminado = true;
	}

	@Override
	public String toString() {
		return "Partido [nroFecha=" + nroFecha + ", fechaHora=" + fechaHora + ", cancha=" + cancha + ", equipoLocal="
				+ equipoLocal + ", equipoVisitante=" + equipoVisitante + ", arbitros=" + arbitros + ", golesLocal="
				+ golesLocal + ", golesVisitante=" + golesVisitante + ", tarjetas=" + tarjetas + ", goles=" + goles
				+ ", partidoTerminado=" + partidoTerminado + "]";
	}

}
