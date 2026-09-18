import java.io.*;
import java.util.ArrayList;
public class Tarea {
	private int id;
	private String desc;
	private int estado;
	public Tarea(int id, String desc, int estado) {
		super();
		this.id = id;
		this.desc = desc;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", desc=" + desc + ", estado=" + estado + "]";
	}
	
	public boolean registrarTarea(String archivo) {
		try(FileWriter fw = new FileWriter(archivo,true);
			PrintWriter pw = new PrintWriter(fw);){
			 pw.println(this.id+"#"+this.desc+"#"+this.estado);
			 System.out.println("Tarea registrada con exito");
			 
			 		 
		}catch(IOException exp) {
			System.out.println("Error al registrar la tarea");
			return false;
		}
		
		return true;
	}
	
	static ArrayList<Tarea> leerTareas(String archivo){
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		try(FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);){
			String linea;
			while((linea = br.readLine())!=null) {
				String [] tokens = linea.split("#");
				int id = Integer.parseInt(tokens[0]);
				String desc = tokens[1];
				int estado = Integer.parseInt(tokens[2]);
				tareas.add(new Tarea(id, desc, estado));
				
			
			}
			
			}catch(Exception exp) {
				System.out.println("Error al leer el archivo");
			}
		return tareas;
	}
	
}
