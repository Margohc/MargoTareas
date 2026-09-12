
package org.calculator;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese el numero1: ");
		double number1 = scanner.nextDouble();
		
		System.out.println("Ingrese el numero2: ");
		double number2 = scanner.nextDouble();
		
		scanner.close();
		
		Calculator calculator = new Calculator (number1, number2);
		
		System.out.println("La suma es de: "+ calculator.add());
		System.out.println("La resta es de: "+ calculator.subtract());
		System.out.println("La multiplicacion es de: "+ calculator.multiplication());
		System.out.println("La division es de: "+ calculator.division());
		
	}

}
