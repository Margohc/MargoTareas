import java.util.*;

public class ElAhorcado {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String jugador = registrarJugador();
        Scanner lector = new Scanner(System.in);

        System.out.println("\nBienvenido al juego del ahorcado " + jugador + "! X|");
        //Seleccion de palabra
        String elegida = elegirPalabra();
        char [] oculta = inicializarPalabraOculta(elegida);
        int errores = 0;
        char letra = 0;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            mostrarOculta(oculta);
            System.out.println("Errores:" + errores);
            letra = ingresarLetra();
            System.out.println(letra);
            if (!verificador (letra, elegida, oculta)) {
                errores ++;
                mostrarMunequito(errores);
            }
            
            if (errores == 6) {
                break;
            }

            if (verificarVictoria(oculta)) {
            	System.out.println(jugador+" Ganaste! :)");
                break;
            }

        }
    
    }
    
    public static String registrarJugador() {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = lector.nextLine();

        return nombre;
    }
        
        
        public static String elegirPalabra() {

            String[] diccionarioPalabras = {
                "alma", "fruto", "rincon", "morocha", "dispara",
                "milagrosa", "luciernagas", "alumbre", "nico", "toy",
                "abuela", "milo", "tiempo", "rostro", "recuerdos",
                "letras", "melancolia"};
            int posicion =(int) (Math.random()*diccionarioPalabras.length);//seleccionamos un random position en el array
            return diccionarioPalabras[posicion].toUpperCase();
            // mostrar la cantidad de caracteres para la palabra
            
        }
        // crear tablero oculto
        public static char[] inicializarPalabraOculta(String elegirPalabra) { //ocultar palabra 
            char [] palabraOculta = new char[elegirPalabra.length()];
            for (int i = 0; i < palabraOculta.length; i++) {
                palabraOculta[i]='_'; // palabra oculta
                
            }
            return palabraOculta;
            
        }
        
        public static char ingresarLetra() {
            Scanner lector = new Scanner(System.in); 
            while (true) {    //Validador que los caracteres ingresadps sean letras
                System.out.println("Introduzca la letra que corresponde a la palabra oculta:");
                char letra = lector.nextLine().charAt(0);// extrae l a letra que se encuentra en la posicion 0 
                int val = letra;
                
                //validacion de letras 
                if(letra>=96 && letra<=  122) { //usando el codigo acii donde los validos seran las mayusculas 
                    return  (char) (letra-32);
                }else if (letra>=65 && letra<=90) {
                    return letra;
                }
                else {
                    System.out.println("Ingreso un caracter incorrecto");
                }
            }
        }
        
        public static boolean verificador(char letra, String elegirPalabra, char [] palabraOculta) {
            
            char [] palabraJugada = new char[elegirPalabra.length()];
            boolean encontrado = false;

            for (int i = 0; i < elegirPalabra.length(); i++) {
                if (elegirPalabra.charAt(i) == letra) {
                    palabraOculta [i] = letra;
                    encontrado =  true;
                }
            }
            return encontrado;
        
        }
        
        public static boolean verificarVictoria(char[] palabraOculta) {
            for (int i = 0; i < palabraOculta.length; i++) {
                if (palabraOculta[i] == '_') {
                    return false;
                }
            }
            return true;
        }
        
        
        public static void mostrarMunequito(int errores) {

                if (errores == 0){
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");
                } else if (errores == 1) {
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");
                } else if (errores== 2){

                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println(" |   |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");

                }else if (errores == 3){

                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("/|   |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");

                } else if (errores == 4){

                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("/|\\  |");
                    System.out.println("     |");
                    System.out.println("     |");
                    System.out.println("=======");

                } else if (errores == 5){
                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("/|\\  |");
                    System.out.println("/    |");
                    System.out.println("     |");
                    System.out.println("=======");

                } else if (errores == 6){

                    System.out.println(" +---+");
                    System.out.println(" |   |");
                    System.out.println(" O   |");
                    System.out.println("/|\\  |");
                    System.out.println("/ \\  |");
                    System.out.println("     |");
                    System.out.println("=======");
                    System.out.println("PERDISTE!");

                }

            }
            
        
        public static void mostrarOculta (char []oculta) {
            for (int i = 0; i < oculta.length; i++) {
                System.out.print(oculta [i]+ " ");
                
            }
            System.out.println();
        }
        
                
}
        
        
        
        
// si se tiene casa el usuario agrega 1 a entonces llena las 2 a



