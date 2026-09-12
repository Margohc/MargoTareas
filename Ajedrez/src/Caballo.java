import java.util.ArrayList;

public class Caballo extends Pieza implements Movimientos {

    public Caballo(String alg, boolean color, int direccion) {

        super(alg, color, direccion);
        setName(definirNombre());
    }

    @Override
    public String definirNombre() {

        if (isColor()) {
            return "Caballo Blanco";
        } else {
            return "Caballo Negro";
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