public class Gol extends EventoPartido {
    private boolean estado;

    public Gol(Jugador jugador, int minuto, boolean estado) {
        super(jugador, minuto);
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void anularGol() {
        estado = false;
    }

    @Override
    public String toString() {
        return "Gol [jugador=" + getJugador().getNombre() + ", minuto=" + getMinuto() + ", estado=" + estado + "]";
    }
}
