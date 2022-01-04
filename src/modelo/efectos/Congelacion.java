package modelo.efectos;
import modelo.Efecto;

public class Congelacion extends Efecto{
	
	private static final Integer MAX_DURACION = 4;
	private static final Integer MIN_DURACION = 1;
	
	private Boolean aplicado;
	
	public Congelacion(Integer duracion) {
		super("Congelacion",duracion);
		this.aplicado=false;
	}
	
	public Congelacion() {
		super("Congelacion",utils.RandomNumbers.randomNumber(MIN_DURACION, MAX_DURACION));
		this.aplicado=false;
	}
	
	
	
	public Boolean getAplicado() {
		return aplicado;
	}

	public void setAplicado(Boolean aplicado) {
		this.aplicado = aplicado;
	}

	@Override
	public void aplicarEfecto(modelo.Ente rival, modelo.Ente yo) {
		
		if(this.getDuracion()>0) {
			//Si no esta aplicado se aplica y se cambia la variable aplicado
			if(!this.getAplicado()) {
				rival.setDefensa(0.0);
				this.setAplicado(true);
			}
			
			this.setDuracion(this.getDuracion()-1);
			
			if(this.getDuracion()==0) {
				//Si el turno es 0 revertimos el efecto
				rival.setDefensa(rival.getDefensa_base());
			}
		}
		
	}
}
