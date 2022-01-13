package modelo;

public class Efecto {
	private String nombre;
	private Integer duracion;
	
	
	protected Efecto(String nombre, Integer duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getDuracion() {
		return duracion;
	}



	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}


	public void aplicarEfecto(Ente rival, Ente yo) {
		
	}



	@Override
	public String toString() {
		return nombre + "-- turnos restantes (incluyendo el actual) = " + (duracion+1);
	}
	
	
	
}
