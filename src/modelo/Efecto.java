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


	public String aplicarEfecto(Ente rival, Ente yo) {
		String retValue=null;
		
		return retValue;
	}



	@Override
	public String toString() {
		return nombre + "-- turnos restantes=" + duracion;
	}
	
	
	
}
