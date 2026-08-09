
public class Amonestacion {
	private Jugador jugador;
	private int minuto;
	private String tipo;

	public Amonestacion(Jugador jugador, int minuto, String tipo) {
		super();
		this.jugador = jugador;
		this.minuto = minuto;
		this.tipo = tipo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public int getMinuto() {
		return minuto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Amonestacion [jugador=" + jugador + ", minuto=" + minuto + ", tipo=" + tipo + "]";
	}

}
