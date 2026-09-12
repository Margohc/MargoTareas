public class Main {

    public static void main(String[] args) {
        try {
            Persona persona = new Persona("Pepe", 25);
            System.out.println(persona);
        } catch (EdadInvalidaException exception) {
            System.out.println(exception.getMessage());

        }
    }
}
