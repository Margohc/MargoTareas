import java.time.LocalDate;

public class Jugador {
    private String nombre;
    private int dorsal;
    private LocalDate fechaNacimiento;
    private boolean estadoEnCampeonato;
    private int golesAnotados;
    private int tarjetasAmarillas;

    // Constructor
    public Jugador(String nombre, int dorsal, int d, int m, int a, boolean estado) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.fechaNacimiento = LocalDate.of(a, m, d);
        this.estadoEnCampeonato = estado;
        this.golesAnotados = 0;
        this.tarjetasAmarillas = 0;
    }
    
    public Jugador(String nombre, int dorsal, int d, int m, int a, boolean estado, int goles, int tarjetas) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.fechaNacimiento = LocalDate.of(a, m, d);
        this.estadoEnCampeonato = estado;
        this.golesAnotados = goles;
        this.tarjetasAmarillas = tarjetas;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstadoEnCampeonato() {
        return estadoEnCampeonato;
    }

    public void setEstadoEnCampeonato(boolean estadoEnCampeonato) {
        this.estadoEnCampeonato = estadoEnCampeonato;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    // Métodos de instancia
    public int getEdad() {
        return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
    }

    public void anotoGol() {
        this.golesAnotados++;
    }

    public void tieneTarjetaAmarilla() {
    	if(this.tarjetasAmarillas<2) {
    		tarjetasAmarillas++;
    	}else {
    		this.expulsado();
    	}
    }

    public void expulsado() {
        this.estadoEnCampeonato = false;
        this.tarjetasAmarillas = 0;
    }

    // Método toString
    @Override
    public String toString() {
        return nombre + "\t" + dorsal+ "\t" +estadoEnCampeonato+ "\t" +golesAnotados;
    }
}
