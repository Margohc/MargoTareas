
import java.util.ArrayList;

public class Torre extends Pieza implements Movimientos {

    public Torre(String alg, boolean color, int direccion) {

        super(alg, color, direccion);

        setName(definirNombre());
    }

    @Override
    public String definirNombre() {

        if (isColor()) {
            return "Torre Blanco";
        } else {
            return "Torre Negro";
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