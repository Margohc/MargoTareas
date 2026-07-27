import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ejercicio 1
		Coche coche = new Coche("Toyota", "rav4",2026, "Blue");
		System.out.println(coche);
		System.out.println("=================");
		//Ejercicio 2
		Rectangulo rectangulo = new Rectangulo(10,12);
		double area = rectangulo.calcularArea();
		System.out.println("El area del rectangulo es :"+area);
		System.out.println("=================");
		
		//Ejericicio 3
		CuentaBancaria cuenta = new CuentaBancaria(0, "Margo");
		 Scanner monto = new Scanner(System.in);
		 System.out.println("Ingrese el monto que desea agregar: ");
		 double dinero = monto.nextDouble();
		 cuenta.ingresarDinero(dinero);
		 
		 System.out.println("Ingrese el monto que desea retirar: ");
		 double dineroRetirado = monto.nextDouble();
		 cuenta.retirarDinero(dineroRetirado);
		 
		 System.out.println(cuenta.getSaldo());
		 System.out.println("Saldo inicial: " + cuenta.getSaldo());

		 cuenta.ingresarDinero(dinero);
		 System.out.println("Saldo después de ingresar: " + cuenta.getSaldo());

		 cuenta.retirarDinero(dineroRetirado);
		 System.out.println("Saldo después de retirar: " + cuenta.getSaldo());
		 
		 
	//	 System.out.println("El saldo mas el ingreso es: "+ ingresa);
	//	 System.out.println("El saldo menos el retiro es: "+ retira);
		 System.out.println("=================");
		 // Ejercicio 4
		 Libro libro = new Libro("Harry Potter y el Prisionero de Azkaban", "J.K Rowling",1999, 373.56);
		 System.out.println(libro);
		 System.out.println("=================");
			//Ejercicio 5 
		 Estudiante estudiante = new Estudiante("Pepe", 20, 8.5);
		 System.out.println("Nombre: " + estudiante.getNombre());
		 System.out.println("Edad: " + estudiante.getEdad());
		 System.out.println("Nota Final: " + estudiante.getNotaFinal());
		 if (estudiante.aprobo()) {
			            System.out.println("El estudiante aprobó.");
			}
		 
		 //Ejercicio 6 
		 Producto producto = new Producto("machine", 850.50, 10);
	        System.out.println("Producto: " + producto.getNombre());
	        System.out.println("Precio: $" + producto.getPrecio());
	        System.out.println("Cantidad en stock: " + producto.getCantidadEnStock());

	        System.out.println("Valor total en stock: $" + producto.calcularValorTotal());
	        
	        // Ejercicio 7 
	        Empleado empleado = new Empleado("Boris", 25, 5000);

	        System.out.println("Empleado: " +empleado.getNombre());
	        System.out.println("Salario inicial: "+ empleado.getSalarioBase());
	        empleado.aumentoSalario(10);
	        System.out.println("Salario después del aumento: " +empleado.getSalarioBase());
	        
	        // ejericio 8 
	        
	        
	        Punto punto1 = new Punto(2, 3);
	        Punto punto2 = new Punto(5, 7);
	        System.out.println("Punto 1: (" + punto1.getX() + ", " + punto1.getY() + ")");       
	        System.out.println("Punto 2: (" +punto2.getX() + ", " + punto2.getY() + ")");      
	        System.out.println("Distancia: " +punto1.distancia(punto2));
	                
	        
		 
		 }
	}