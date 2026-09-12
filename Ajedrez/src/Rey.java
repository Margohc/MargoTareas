
import java.util.ArrayList;

public class Rey extends Pieza implements Movimientos {

    public Rey(String alg, boolean color, int direccion) {

        super(alg, color, direccion);

        setName(definirNombre());
    }

    @Override
    public String definirNombre() {

        if (isColor()) {
            return "Rey Blanco";
        } else {
            return "Rey Negro";
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