
public class Aulas {
	private String id;
	private int capacidad;
	private String bloque;
	public Aulas(String id, int capacidad, String bloque) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.bloque = bloque;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getBloque() {
		return bloque;
	}
	public void setBloque(String bloque) {
		this.bloque = bloque;
	}
	@Override
	public String toString() {
		return "Aulas [id=" + id + ", capacidad=" + capacidad + ", bloque=" + bloque + "]";
	}
	


}
