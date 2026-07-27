import java.util.*;
public class Ejercicioexam1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Declaracion de varialbles
        String [] paises = {"Bolivia","Peru", "Ecuador", "Paraguay"};
        String [] beneficiarios = {"Menores de edad", "Adultors", "Tercera Edad"};
       // int qtyPaises = 4;
       int qtyGetario = 3;
        Scanner lector = new Scanner(System.in);
        int posMayorMenores = 0;
        int sumaTotal = 0;
        int posMayorBeneficiados = 0;
        int sumaBol = 0;
        int sumaPeru = 0;
        int sumaEcuador = 0;
        int sumaParaguay =0;
      
        // matriz
        int[][] beneficiados = new int[4][3];
        int[] totalPais = new int[4];

        // Lectura de la matriz
        //Solicitar datos de beneficiarios
        for (int i = 0; i < paises.length; i++) {
        	System.out.println("\nPais: " + paises[i]);
        	for (int j = 0; j < beneficiarios.length; j++) {
        		System.out.print("Cantidad de "+ beneficiarios[j] + ": ");// solicitud de cantidad de beneficiarios
                        beneficiados[i][j] = lector.nextInt();
                        totalPais[i] += beneficiados[i][j];//Adicionar el dato del total pais segun la cantidad de beneficiarios
            }
        }

        // Encontrar pais con mayor cantidad de menores beneficiados
        for (int i = 1; i < paises.length; i++) {

            if (beneficiados[i][0] >
                beneficiados[posMayorMenores][0]) {
                posMayorMenores = i;
            }
        }

        // promedio de beneficiados por pais
        for (int i = 0; i < totalPais.length; i++) {

            sumaTotal += totalPais[i];
        }
        double promedio = (double) sumaTotal / qtyGetario;//Calculo del promedio de personas beneficiadas 
    

        // pais con mayor cantidad de beneficiados
        for (int i = 1; i < totalPais.length; i++) {
            if (totalPais[i] > totalPais[posMayorBeneficiados]) {
                posMayorBeneficiados = i;
            }
            
        }

        // Mostrar matriz

        System.out.println("\tMenores\tAdultos\tTerceraEdad\tTotal\tPromedio");

        for (int i = 0; i < paises.length; i++) {
        	System.out.print(paises[i] + "\t");//imprimir el pais
        	System.out.print();

            for (int j = 0; j < beneficiarios.length; j++) {
                System.out.print(beneficiados[i][j] + "\t");//Imprimir los beneficiarios
                
            }

            System.out.println("\t"+totalPais[i]);
        }
        lector.close();
        // Resultados de los calculos 
        System.out.println("\n**** RESULTADOS ****");
        //Determinar en que pais se ayuda a mas poblacion menor de edad
        System.out.println("Pais con mayor cantidad de menores beneficiados: "+ paises[posMayorMenores]);
        //promedio de personas 
        System.out.println("Promedio de personas ayudadas por pais: "+ promedio);
        //En que pais se ayuda a mas personas
        System.out.println("Pais con mayor cantidad de beneficiarios: "+ paises[posMayorBeneficiados]);

        
    }
}