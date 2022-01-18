package modelo.efectos;
import modelo.Efecto;
import modelo.Ente;

/**
 * Clase que hereda de Efecto y representa el efecto Congelación.
 * @author juanmi_rivas_8
 *
 */
public class Congelacion extends Efecto{
	
	private static final Integer MAX_DURACION = 3;
	private static final Integer MIN_DURACION = 1;
	
	
	/******************Getters , Setters y Constructores*****************************/
	
	public Congelacion(Integer duracion) {
		super("Congelacion",duracion);
		
	}
	
	public Congelacion() {
		super("Congelacion",utils.RandomNumbers.randomNumber(MIN_DURACION, MAX_DURACION));
		
	}
	
	@Override
	/**
	 * Método que reduce la defensa del Ente yo a 0.0
	 * @param rival Ente rival por si fuera necesario leer información de éste
	 * @param yo Ente sobre el cual se va a aplicar el efecto
	 */
	public void aplicarEfecto(Ente rival, Ente yo) {
		
		if(this.getDuracion()==0) {
			//Si el turno es 0 revertimos el efecto
			yo.setDefensa(yo.getDefensa_base());
			this.setDuracion(this.getDuracion()-1);
		}else if(this.getDuracion()>0) {
			//Si no esta aplicado se aplica y se cambia la variable aplicado
			
				yo.setDefensa(yo.getDefensa_base()/(this.getDuracion()+1));
				
			
			
			this.setDuracion(this.getDuracion()-1);
		}
		
	}
}
