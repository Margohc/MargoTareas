import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Scanner lector = new Scanner(System.in);
		ArrayList <Estudiante> estudiantes = new ArrayList <Estudiante>();
		
		while (true) {
			System.out.println("1. Añadir estudiante: ");
			System.out.println("2. Mostrar lista de estudiantes: ");
			System.out.println("3. Mostrar lista de notas: ");
			System.out.println("4. Mostrar lista de estudiantes habilitados: ");
			System.out.println("5. Salir: ");
			
			int opcion = lector.nextInt();
			if (opcion == 1) {
				System.out.println("Ingrese el nombre del estudiante: ");
				System.out.println("Ingrese el apellido del estudiante: ");
				System.out.println("Ingrese el nombre del estudiante: ");
				System.out.println("Ingrese el nombre del estudiante: ");
				Estudiante estudiante = new Estudiante();
				String nombre = scanner.nextLine();   
				estudiantes.setNombre(nombre);
				estudiantes.add(estudiante);	
			}else if (opcion == 2) {
				
			}else if (opcion == 3) {
				
			}else if (opcion == 4) {
				
			}else if (opcion == 5) {
				
			}else {
				System.out.println("Opcion invalida");
			}
		}
			
			/*Estudiante estudiante = new Estudiante();
			System.out.println("Ingrese el nombre del estudiante: ");
			String nombre = scanner.nextLine();   
			estudiante.setNombre(nombre);
			estudiantes.add(estudiante);

		        scanner.close();*/
			 
		}
	}
