import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Horario {
	private Aulas aula;
	private Docente docente;
	private String dia;
	private LocalTime inicio;
	private LocalTime fin;
	public Horario(Aulas aula, Docente docente, String dia, LocalTime inicio, LocalTime fin) {
		super();
		this.aula = aula;
		this.docente = docente;
		this.dia = dia;
		this.inicio = inicio;
		this.fin = fin;
	}
	public Aulas getAula() {
		return aula;
	}
	public void setAula(Aulas aula) {
		this.aula = aula;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public LocalTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}
	public LocalTime getFin() {
		return fin;
	}
	public void setFin(LocalTime fin) {
		this.fin = fin;
	}
	
	@Override
	public String toString() {
		return "Horario [aula=" + aula + ", docente=" + docente + ", dia=" + dia + ", inicio=" + inicio + ", fin=" + fin
				+ "]";
	}
	
	public boolean hayCruce(Horario otro) {
		
		if(this.dia.equals(otro.dia) && (this.docente.equals(otro.docente)||this.aula.equals(otro.aula))) {
			if(this.inicio.isAfter(otro.inicio) && this.inicio.isBefore(otro.fin)) return true;
			if(this.fin.isAfter(otro.inicio) && this.fin.isBefore(otro.fin)) return true;
			if(this.inicio.equals(otro.inicio) && this.fin.equals(otro.fin)) return true;
			if(this.inicio.equals(otro.inicio) && this.fin.isAfter(otro.fin))return true;
			if(this.inicio.isBefore(otro.inicio) && this.fin.equals(otro.fin))return true;
			if(this.inicio.isBefore(otro.inicio) && this.fin.isAfter(otro.fin)) return true;
			return false;
		}
		return false;
	}
	
	
	static void agregarHorario(ArrayList<Horario> horariosRegistrados,ArrayList<Aulas> aulasRegistradas, ArrayList<Docente> docentesRegistrados){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el dia");
		String dia = scanner.nextLine();
		scanner.nextLine();
		
		System.out.println("Ingrese la hora de inicio: ");
		int hora = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Ingrese los minutos de inicio: ");
		int min = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Ingrese la hora de fin: ");
		int horaFin = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Ingrese los minutos de fin: ");
		int minFin = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Ingrese el ci del docente");
		String ci = scanner.nextLine();
		System.out.print("Ingrese el id del aula");
		String id = scanner.nextLine();
		
		Docente doc = null;
		for (Docente docente : docentesRegistrados) {
			if(ci.equals(docente.getCi())) {
				doc = docente;
				break;
			}
		}
		
		Aulas aula = null;
		for (Aulas a : aulasRegistradas) {
			if(id.equals(a.getId())) {
				aula = a;
			}
		}
		
		LocalTime tiempoInicio = LocalTime.of(hora, min);
		LocalTime tiempoFin = LocalTime.of(horaFin, minFin);
		
		Horario nuevo = new Horario(aula, doc, dia, tiempoInicio, tiempoFin);
		System.out.println(nuevo);
		boolean seChoca = false;
		for (Horario horario: horariosRegistrados) {
			if(nuevo.hayCruce(horario)) {
				seChoca = true;
				break;
			}
		}
		
		if(!seChoca) {
			horariosRegistrados.add(nuevo);
			System.out.println("ok");
		}else {
			System.out.println("Se choca");
		}
		
	}
	
	

}
