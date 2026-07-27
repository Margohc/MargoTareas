
public class Punto {
	private double x;
	private double y;
	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double distancia(Punto otro) {

        double diferenciaX = this.x - otro.x;
        double diferenciaY = this.y - otro.y;

        return Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY));
	}

}
