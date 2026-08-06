import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingresa la cantidad de paises participantes: ");
		int n = lector.nextInt();
		lector.nextLine(); 
		ArrayList<ClaseMedallasPais> medallas = new ArrayList<ClaseMedallasPais>();
		//parte 1
		for(int i = 0; i< n ; i++) {
			
			System.out.println("Ingrese nombre del pais");
			String pais = lector.nextLine();
			
			System.out.println("Medallas de oro: ");
			int oro = lector.nextInt();
			System.out.println("Medallas de plata");
			int plata = lector.nextInt();
			System.out.println("Medallas de bronce");
			int bronce = lector.nextInt();
			
			lector.nextLine();// limpiar salto de linea 
			ClaseMedallasPais nPais =new ClaseMedallasPais(pais, oro, plata, bronce);
			medallas.add(nPais);
			
			
		}
		
		System.out.println("\nLista de países:");

        for (ClaseMedallasPais mp : medallas) {
            System.out.println(mp.getPais());
        }
        // parte 2
        
        ClaseMedallasPais primero = medallas.get(0);
        ClaseMedallasPais medio = medallas.get(n/2);
        ClaseMedallasPais ultimo= medallas.get(n-1);
        //El primero
        System.out.println("*** El primer puesto ***");
        System.out.println("Primer pais: " + primero.getPais());
        System.out.println("Oro: " + primero.getMedallasOro());
        System.out.println("Plata: "+ primero.getMedallasPlata());
        System.out.println("Bronce: "+ primero.getMedallasBronce());
        //El medio
        System.out.println("*** El puesto del medio ***");
        System.out.println("Pais del medio: "+ medio.getPais());
        System.out.println("Oro: "+ medio.getMedallasOro());
        System.out.println("Plata: "+ medio.getMedallasPlata());
        System.out.println("Bronce: "+ medio.getMedallasBronce());
        //El ultimo
        System.out.println("*** El ultimo puesto ***");
        System.out.println("Ultimo pais: " + ultimo.getPais());
        System.out.println("Oro: "+ ultimo.getMedallasOro());
        System.out.println("Plata: " + ultimo.getMedallasPlata());
        System.out.println("Bronce: "+ ultimo.getMedallasBronce());
        
        //parte 3
        
        ClaseMedallasPais primerPais = medallas.get(0);
        primerPais.setMedallasBronce(primerPais.getMedallasBronce() + 1);
        
        //parte 4
        medallas.get(n / 2).setMedallasOro(
        	    medallas.get(n / 2).getMedallasOro() + 1
        	);
        // Parte 5
        medallas.get(n -1).setMedallasOro(
        	    medallas.get(n -1).getMedallasOro() + 1
        	);
        
        //parte 6
        
        
        //Parte 7
        
}


