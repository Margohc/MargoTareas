import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo maxima = new Rectangulo(2,17);
		Rectangulo claudio = new Rectangulo(10,5);
		Rectangulo renato = new Rectangulo(20);
		Circulo carlota = new Circulo(8);
		Circulo mauricio = new Circulo(6);
		Triangulo fernanda = new Triangulo(2, 3, 3.5);
		
		double suma = carlota.calcularAreaCirculo()+fernanda.heronTriangulo();
		double porcentaje = 100*renato.calcularPerimetro()/maxima.calcularPerimetro();
		double diferencia = mauricio.calcularAreaCirculo()-claudio.calcularArea();
		System.out.println(suma);
		System.out.println(porcentaje);
		System.out.println(diferencia);
		
		System.out.println("Maxima " + maxima);
		System.out.println("Carlota " + carlota);
		System.out.println("Fernanda " + fernanda);
		
		double area = renato.getBase() * maxima.getAltura();
		System.out.println(area);
		
		carlota.setRadio(10);
		System.out.println(carlota.calcularAreaCirculo());
		
		
		
		
		ArrayList<Circulo> circulos = new ArrayList<Circulo>();
		System.out.println(circulos);
		
		circulos.add(carlota);
		circulos.add(mauricio);
		circulos.add(new Circulo(5));
		System.out.println(circulos);
		
		System.out.println(circulos.get(1).calcularAreaCirculo());
		
		
		
		double sumaAreas = 0;
		for (Circulo circulo : circulos) {
			sumaAreas += circulo.calcularAreaCirculo();
		}
		
		System.out.println(sumaAreas);
		circulos.remove(1);
		System.out.println(circulos);
		circulos.remove(2);
		
	}

}
