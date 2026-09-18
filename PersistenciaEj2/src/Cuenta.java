import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cuenta {
	private int numeroCuenta;
	private String titular;
	private double saldo;
	public Cuenta(int numeroCuenta, String titular, double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.saldo = saldo;
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + "]";
	}
	
	public boolean registrarCuenta(String Archivo) {
		try {FileWriter fw = new FileWriter(archivo,true);
		PrintWriter pw = new PrintWriter(fw);){
			 pw.println(this.numeroCuenta+"#"+this.titular+"#"+this.saldo);
			 System.out.println("Cuenta registrada con exito");	 
			 		 
		}catch(IOException exp) {
			System.out.println("Error al registrar la cuenta");
		} return false;
		
		} return true;
		}
	}

}
