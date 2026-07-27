import java.util.*;

public class TresEnRaya {

    public static void main(String[] args) {

        String[] nombres = jugadores();//agregar nombres 
        int jugadorInicial = jugadorIniciador();//Iniciamos con jugadores
        System.out.println("\nComienza la partida: " + nombres[jugadorInicial]);
        System.out.println("Juega segundo: " + nombres[1 - jugadorInicial]);//quien inicia
        mostrarGuia();//imprimirguia

        char[][] tablero = new char[3][3];//  Declaracion de tablero en char

        inicializarTablero(tablero); //iniciar el tablare
        mostrarTablero(tablero);

        boolean juegoTerminado = false;  //while del juego
        int turno = jugadorInicial;
        while (!juegoTerminado) {
            char ficha;
            if (turno == 0) {
                ficha = 'X';
            } else {
                ficha = 'O';
            }

            realizarMovimiento(tablero, nombres[turno], ficha);
            mostrarTablero(tablero);
// demostrar ganador
            if (verificarGanador(tablero, ficha)) {
                System.out.println("\nFelicidades " + nombres[turno] + "!!!");
                System.out.println("Has ganado la partida :)");

                juegoTerminado = true;

            } else if (verificadorTableroLLeno(tablero)) {
                System.out.println("Empate! ;(");
                juegoTerminado = true;
            }else {

                turno = 1 - turno;

            }

        }
        
        
        
        
        

    }

    public static String[] jugadores() {
        String[] jugadores = {"Jugador 1", "Jugador 2"};
        String[] nombres = new String[2]; // String para guardar los nombres
        Scanner lector = new Scanner(System.in);
        for (int i = 0; i < nombres.length; i++) { // solicitar nombres de los jugadores
            System.out.print("Ingrese el nombre del "+ jugadores[i] +": ");
            nombres[i] = lector.nextLine();// agregar los nombres a nombres 

        }

        System.out.println("\n**Los jugadores son:**"); // imprimir los nombres de los jugadores

        for (int i = 0; i < nombres.length; i++) {

            System.out.println(jugadores[i] +": " +nombres[i]);
        }
        return nombres;
    }


    public static int jugadorIniciador() {
        int val = (int) (Math.random() * 10) + 1;
        if (val % 2 == 0) {// si el jugador obtiene un par y otro impar, par inicia
            return 0;
        } else  {
            return 1;
        }
    }
        
    public static void inicializarTablero(char[][] tablero) {//declaracion del tablero para el juego
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }

        }

    }
    public static void mostrarTablero(char[][] tablero) { //Diseño del tablero separacion y espacios
        System.out.println("\n   0   1   2");

        for (int i = 0; i < tablero.length; i++) {

            System.out.print(i + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(" " + tablero[i][j] + " ");
                if (j < tablero[i].length - 1) { //imprimir |
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < tablero.length - 1) {
                System.out.println("  ---+---+---");//horizonatl de la tabla
            }

        }

    }
    // verificar si el tablero esta lleno
    public static boolean verificadorTableroLLeno(char[][] tablero) {
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == ' ') {
                    return false;

                }
            }
        }
            return true;

        }
   

      

        
        
    
    public static void realizarMovimiento(char[][] tablero, String jugador, char ficha) {

        Scanner lector = new Scanner(System.in);

        int casilla;
        int fila;
        int columna;
        boolean movimientoValido = false; //movimiento invalido, por que todavia no jugo a

        System.out.println("\nTurno de " + jugador);

        while (!movimientoValido) { //Se ingresara al boocle hasta que sea true lo que seria como un movimiento valido

            System.out.print("Seleccione una casilla (1-9): ");
            casilla = lector.nextInt();
            if (casilla < 1 || casilla > 9) { // si la casilla es mayor a 1 o menor que 9
                System.out.println("Casilla inválida.");

            } else {
                fila = (casilla - 1) / 3;
                columna = (casilla - 1) % 3;
                if (tablero[fila][columna] == ' ') {
                    tablero[fila][columna] = ficha;

                    movimientoValido = true;

                } else {

                    System.out.println("La casilla ya está ocupada.");

                }

          }
        }

    }
    
    //----------El ganador
    public static boolean verificarGanador(char[][] tablero, char ficha) {
        // Verificar filas
        for (int i = 0; i < tablero.length; i++) {//los campos en el tablero van del 0 al 2

            if (tablero[i][0] == ficha && //verificar si una fila completa contine la misma ficha
                tablero[i][1] == ficha &&
                tablero[i][2] == ficha) {

                return true;
            }
        }
        for (int j = 0; j < tablero[0].length; j++) { // verificacion de columnas, recorrer las 3 columnas del tablero 

            if (tablero[0][j] == ficha &&//columna 0
                tablero[1][j] == ficha &&//columna 1
                tablero[2][j] == ficha) {//columna 2
                return true;
            }
        }
        if (tablero[0][0] == ficha && // Verificar diagonal principal de arriba abaoji
            tablero[1][1] == ficha &&
            tablero[2][2] == ficha) {

            return true;
        }
        if (tablero[0][2] == ficha &&  //verificar diagonal secundaria de abajo arriba
            tablero[1][1] == ficha &&
            tablero[2][0] == ficha) {

            return true;
        }//no hay ganador
        
        return false;

       
    }
    
    
    
    public static void mostrarGuia() {

        System.out.println("\n*** TABLERO GUIA***");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---+---+---");
        System.out.println(" 7 | 8 | 9 ");
    }
        
    }