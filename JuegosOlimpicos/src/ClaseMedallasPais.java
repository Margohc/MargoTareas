import java.util.ArrayList;
import java.util.Iterator;

public class ClaseMedallasPais {
	private String pais;
	private int medallasOro;
	private int medallasPlata;
	private int medallasBronce;
	public ClaseMedallasPais(String pais, int medallasOro, int medallasPlata, int medallasBronce) {
		super();
		this.pais = pais;
		this.medallasOro = medallasOro;
		this.medallasPlata = medallasPlata;
		this.medallasBronce = medallasBronce;
	}
	public ClaseMedallasPais(String pais) {
		super();
		this.pais = pais;
		this.medallasOro = 0;
		this.medallasPlata = 0;
		this.medallasBronce = 0;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getMedallasOro() {
		return medallasOro;
	}
	public void setMedallasOro(int medallasOro) {
		this.medallasOro = medallasOro;
	}
	public int getMedallasPlata() {
		return medallasPlata;
	}
	public void setMedallasPlata(int medallasPlata) {
		this.medallasPlata = medallasPlata;
	}
	public int getMedallasBronce() {
		return medallasBronce;
	}
	public void setMedallasBronce(int medallasBronce) {
		this.medallasBronce = medallasBronce;
	}
	
	
	public void ganoMedallaOro() {
		this.medallasOro++;
	}
	
	public void ganoMedallaPlata() {
		this.medallasPlata++;
	}
	
	public void ganoMedallaBronce() {
		this.medallasBronce++;
	}
	
	public int totalMedallasPais() {
		int totalPais;
		totalPais = medallasOro + medallasPlata + medallasBronce;
		return totalPais;
		
	}
	
	public static int medallasEntregadas(ArrayList<ClaseMedallasPais> medallas) {
		
		int totalMedallasEntregadas = 0;
		for (ClaseMedallasPais mp : medallas) {
			totalMedallasEntregadas += mp.totalMedallasPais();	
		}
		return totalMedallasEntregadas;
		
	}
	
	public static String paisMasMedallas(ArrayList<ClaseMedallasPais> medallas) {
		String paisMsMedallas = "";
		int numero = 0;
		int mayor = 0;
		for (ClaseMedallasPais mp : medallas) {
			
			
			if(mp.totalMedallasPais()>mayor) {
				 mayor = mp.totalMedallasPais();
				 paisMsMedallas = mp.getPais();
			}
			
			
		}
		return paisMsMedallas;
		
	}
	
	public static String paisMenosMedallas(ArrayList<ClaseMedallasPais> medallas) {

	    String paisMenosMedallas = medallas.get(0).getPais();
	    int menor = medallas.get(0).totalMedallasPais();

	    for (ClaseMedallasPais mp : medallas) {

	        if (mp.totalMedallasPais() < menor) {
	            menor = mp.totalMedallasPais();
	            paisMenosMedallas = mp.getPais();
	        }

	    }

	    return paisMenosMedallas;
	}
	
	
	public static String paisMasMedallasOro(ArrayList<ClaseMedallasPais> medallas) {

	    ClaseMedallasPais mayor = medallas.get(0);

	    for (ClaseMedallasPais mp : medallas) {

	        if (mp.getMedallasOro() > mayor.getMedallasOro()) {
	            mayor = mp;
	        }
	    }

	    return mayor.getPais();
	}
	
	
	
}
	
