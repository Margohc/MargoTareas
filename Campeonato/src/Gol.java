
public class Gol {
	private Jugador jugador;
	private int minuto;
	private boolean estado;

	public Gol(Jugador jugador, int minuto, boolean estado) {
		super();
		this.jugador = jugador;
		this.minuto = minuto;
		this.estado = estado;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public int getMinuto() {
		return minuto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public void estadoGol(boolean estado) {
		this.estado = estado;
	}

	public void anularGol() {
		estado = false;
	}

	@Override
	public String toString() {
		return "Gol [jugador=" + jugador + ", minuto=" + minuto + ", estado=" + estado + "]";
	}

}
