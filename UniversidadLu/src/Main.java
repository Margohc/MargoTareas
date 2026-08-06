import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		Scanner lector1 = new Scanner(System.in);
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		ArrayList<Estudiante> habilitados = new ArrayList<Estudiante>();
		int opcion;
		while (true) {
			System.out.println("----------- UNIVERSIDAD -------------");
			System.out.println("1. Registrar estudiante");
			System.out.println("2. Lista de estudiantes");
			System.out.println("3. Lista de Notas");
			System.out.println("4. Lista de estudiantes habilitados");
			System.out.println("5. Salir");
			System.out.print("Ingrese la opcion: ");
			opcion = lector.nextInt();
			
			switch(opcion) {
			case 1:
				
				System.out.println("*****Registro de Estudiante*******");
				System.out.println("Ingrese el nombre:");
				String nom = lector1.nextLine();
				System.out.println("Ingrese el apellido:");
				String ape = lector1.nextLine();
				System.out.println("Ingrese la nota 1:");
				double n1 = lector1.nextDouble();
				System.out.println("Ingrese la nota 2:");
				double n2 = lector1.nextDouble();
				
				estudiantes.add(new Estudiante(nom, ape, n1, n2));
				
				break;
			case 2:
				
				for (Estudiante estudiante : estudiantes) {
					System.out.println(estudiante);
				}
				
				break;
			case 3:
				
				for (Estudiante estudiante : estudiantes) {
					System.out.println(estudiante+" "+estudiante.getNota1()+" "+estudiante.getNota2()+" "+estudiante.notaHabilitacion());
				}
				break;
			case 4:
				
				boolean eximidos = false;
				habilitados = (ArrayList<Estudiante>) estudiantes.clone();
				for (int i = 0; i < habilitados.size(); i++) {
					if(habilitados.get(i).notaHabilitacion()<51) {
						habilitados.remove(i);
						i--;
					}
				}
				
				
				for (Estudiante estudiante : habilitados) {
					System.out.println(estudiante+" "+estudiante.getNota1()+" "+estudiante.getNota2()+" "+estudiante.notaHabilitacion());
					if (estudiante.notaHabilitacion()>=95) {
						eximidos = true;
					}
				}
				
				if(eximidos)System.out.println("Hay estudiantes con posibilidad de eximision");
				
				break;
			case 5:
				System.out.println("ADIOOOOOOS");
				break;
			default:
				break;
			}
			
			if(opcion==5)break;
		}
	}

}
