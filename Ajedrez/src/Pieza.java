public abstract class Pieza {

    private String name;
    private boolean color;
    private int fila;
    private int columna;
    private int direccion;
    private boolean estado;

    public Pieza(String alg, boolean color, int direccion) {

        super();

        this.color = color;
        this.direccion = direccion;
        this.estado = true;

        cambiarPosicion(alg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pieza [name=" + name + ", color=" + color
                + ", fila=" + fila + ", columna=" + columna
                + ", direccion=" + direccion + ", estado=" + estado + "]";
    }

    public void cambiarPosicion(String alg) {

        char nameTablero = alg.charAt(0);
        char columnaTablero = alg.charAt(1);
        char filaTablero = alg.charAt(2);

        if (columnaTablero == 'a') {
            this.columna = 0;
        } else if (columnaTablero == 'b') {
            this.columna = 1;
        } else if (columnaTablero == 'c') {
            this.columna = 2;
        } else if (columnaTablero == 'd') {
            this.columna = 3;
        } else if (columnaTablero == 'e') {
            this.columna = 4;
        } else if (columnaTablero == 'f') {
            this.columna = 5;
        } else if (columnaTablero == 'g') {
            this.columna = 6;
        } else if (columnaTablero == 'h') {
            this.columna = 7;
        }

        if (filaTablero == '1') {
            this.fila = 7;
        } else if (filaTablero == '2') {
            this.fila = 6;
        } else if (filaTablero == '3') {
            this.fila = 5;
        } else if (filaTablero == '4') {
            this.fila = 4;
        } else if (filaTablero == '5') {
            this.fila = 3;
        } else if (filaTablero == '6') {
            this.fila = 2;
        } else if (filaTablero == '7') {
            this.fila = 1;
        } else if (filaTablero == '8') {
            this.fila = 0;
        }
    }

    public abstract String definirNombre();

    public abstract String obtenerPosicion();

}
