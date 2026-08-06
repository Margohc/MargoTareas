import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Scanner lector = new Scanner(System.in);
		//ArrayList Aulas
		ArrayList <Aulas> aulas = new ArrayList <Aulas>();
		aulas.add(new Aulas("151", 30, "K")); //Cuando se quiere agregar de manera predeterminada los valores del objeto
		aulas.add(new Aulas("150", 40, "C"));
		//ArrayList Docente
		ArrayList <Docente> docentes = new ArrayList <Docente>();
		docentes.add(new Docente("444", "Ricardo Landivar" )); //Cuando se quiere agregar de manera predeterminada los valores del objeto
		docentes.add(new Docente("555", "Mauricio Crespo" ));
		
		ArrayList <Horario> horarios = new ArrayList <Horario>();
		Horario.agregarHorario(horarios, aulas, docentes);
		Horario.agregarHorario(horarios, aulas, docentes);
		Horario.agregarHorario(horarios, aulas, docentes);
		Horario.agregarHorario(horarios, aulas, docentes);
		
		
		
		

	}

}
