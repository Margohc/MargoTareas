import java.util.ArrayList;

public class Main {
	public static void main(String [] args) {
		ArrayList<Tarea> tareasRegistradas = Tarea.leerTareas(Archivos.archivoTareas);
		for (Tarea tarea : tareasRegistradas) {
			System.out.println(tarea);
		}
	
	}
}
