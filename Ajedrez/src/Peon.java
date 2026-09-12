
import java.util.ArrayList;

public class Peon extends Pieza implements Movimientos {

    public Peon(String alg, boolean color, int direccion) {

        super(alg, color, direccion);
        setName(definirNombre());
    }

    @Override
    public String definirNombre() {

        if (isColor()) {
            return "Peon Blanco";
        } else {
            return "Peon Negro";
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