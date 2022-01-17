package modelo.efectos;
import modelo.Efecto;
import modelo.Ente;
public class Congelacion extends Efecto{
	
	private static final Integer MAX_DURACION = 3;
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
	public void aplicarEfecto(Ente rival, Ente yo) {
		
		if(this.getDuracion()==0) {
			//Si el turno es 0 revertimos el efecto
			yo.setDefensa(yo.getDefensa_base());
			this.setDuracion(this.getDuracion()-1);
		}else if(this.getDuracion()>0) {
			//Si no esta aplicado se aplica y se cambia la variable aplicado
			if(!this.getAplicado()) {
				yo.setDefensa(0.0);
				this.setAplicado(true);
			}
			
			this.setDuracion(this.getDuracion()-1);
		}
		
	}
}
