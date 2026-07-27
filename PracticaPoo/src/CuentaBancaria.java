import java.util.Scanner;


public class CuentaBancaria {
	private double saldo;
	private String titular;
	
	
    public CuentaBancaria(double saldo, String titular) {
		super();
		this.saldo = saldo;
		this.titular = titular;
	}
    
    




	public double getSaldo() {
		return saldo;
	}






	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}






	public String getTitular() {
		return titular;
	}






	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void ingresarDinero (double monto) {
		 this.saldo += monto;
	 } 
	public void retirarDinero (double monto) {
		 this.saldo -= monto;
	 }
	
	


}
