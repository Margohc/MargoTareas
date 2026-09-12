import java.util.ArrayList;

public class Dama extends Pieza implements Movimientos {

    public Dama(String alg, boolean color, int direccion) {

        super(alg, color, direccion);
        setName(definirNombre());
    }

    @Override
    public String definirNombre() {

        if (isColor()) {
            return "Dama Blanco";
        } else {
            return "Dama Negro";
        }
    }

    @Override
    public String obtenerPosicion() {

        return "";
    }

    @Override
    public void mostrarPosiblesMovimientos(ArrayList<Pieza> piezas) {

    }

    @Override
    public boolean jaque(ArrayList<Pieza> piezas) {

        return false;
    }
}