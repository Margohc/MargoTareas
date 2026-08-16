public class Amonestacion extends EventoPartido {
	private String tipo;

	public Amonestacion(Jugador jugador, int minuto, String tipo) {
		super(jugador, minuto);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Amonestacion [jugador=" + getJugador() + ", minuto=" + getMinuto() + ", tipo=" + tipo + "]";
	}

}
