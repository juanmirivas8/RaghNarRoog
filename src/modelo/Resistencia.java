package modelo;

public class Resistencia {
	private String nombre;
	private Double porcentaje;
	private Class <? extends Efecto> efecto;

	protected Resistencia(String nombre, Double porcentaje, Class<? extends Efecto> efecto) {
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.efecto = efecto;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Class<? extends Efecto> getEfecto() {
		return efecto;
	}


	public void setEfecto(Class<? extends Efecto> efecto) {
		this.efecto = efecto;
	}





	@Override
	public Object clone() {
		Resistencia r = new Resistencia(this.nombre,this.porcentaje,this.efecto);
		return r;
	}
	
}
