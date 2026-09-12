
import java.util.ArrayList;

public class Alfil extends Pieza implements Movimientos {

    public Alfil(String alg, boolean color, int direccion) {

        super(alg, color, direccion);
        setName(definirNombre());
    }

    @Override
    public String definirNombre() {

        if (isColor()) {
            return "Alfil Blanco";
        } else {
            return "Alfil Negro";
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