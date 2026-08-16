import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equipo bolivar =  new Equipo("Bolivar");
		bolivar.addJugador("Pedro", 10, 26, 06, 1986, true);
		bolivar.addJugador("pepe", 10, 26, 06, 1994, true);
		bolivar.addJugador("Saul", 10, 26, 06, 1989, true);
		bolivar.addJugador("carlos", 10, 26, 06, 1992, true);
		bolivar.addJugador("Diego", 10, 26, 06, 1986, true);
		bolivar.getNomina();
		Equipo tigre =  new Equipo("Juan");
		tigre.addJugador("Manolo", 7, 15, 2, 1985, true);
		tigre.addJugador("Gonzales", 7, 15, 2, 1995, true);
		tigre.addJugador("Jesus", 7, 15, 2, 1989, true);
		tigre.addJugador("Embape", 7, 15, 2, 1997, true);
		tigre.addJugador("Lamin", 7, 15, 2, 2000, true);
		tigre.addJugador("Cucurella", 7, 15, 2, 2003, true);
		tigre.getNomina();
		
		Partido clasico = new Partido(1, LocalDateTime.now(), new Cancha("Siles", "Miraflores", "La Paz"), bolivar, tigre);
		clasico.anotoGolLocal(bolivar.getJugadores().get(0), 2);
		clasico.anotoGolVisitante(tigre.getJugadores().get(2), 40);
		clasico.amonestacionLocal("Roja",bolivar.getJugadores().get(1),87);
		System.out.print(clasico);
		
		clasico.getLocal().getNomina();
		clasico.getVisitante().getNomina();
		
	}

}
