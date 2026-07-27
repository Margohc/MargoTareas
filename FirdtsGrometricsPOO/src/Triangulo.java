
public class Triangulo {
	private double ladoA;
	private double ladoB;
	private double ladoC;
	

	
	public Triangulo(double ladoA, double ladoB, double ladoC) {
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}
	
	
// getters


	public double getLadoA() {
		return ladoA;
	}





	public void setLadoA(double ladoA) {
		this.ladoA = ladoA;
	}





	public double getLadoB() {
		return ladoB;
	}





	public void setLadoB(double ladoB) {
		this.ladoB = ladoB;
	}





	public double getLadoC() {
		return ladoC;
	}





	public void setLadoC(double ladoC) {
		this.ladoC = ladoC;
	}


	


	@Override
	public String toString() {
		return "Triangulo [ladoA=" + ladoA + ", ladoB=" + ladoB + ", ladoC=" + ladoC + "]";
	}





	public double semiPerimetro() {
        return (this.ladoA + this.ladoB + this.ladoC) / 2;
    }
	


    public double heronTriangulo() {
        double s = semiPerimetro();
        return Math.sqrt(s * (s - this.ladoA) * (s - this.ladoB) * (s - this.ladoC));
    }
}