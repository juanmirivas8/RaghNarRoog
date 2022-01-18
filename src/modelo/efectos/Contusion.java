package modelo.efectos;
import modelo.Efecto;

/**
 * Clase que representa el efecto Contusion
 * @author juanmi_rivas_8
 *
 */
public class Contusion extends Efecto{
	private static final Integer MAX_DURACION = 4;
	private static final Integer MIN_DURACION = 1;
	
	
	public Contusion(Integer duracion) {
		super("Contusion",duracion);
	}
	
	public Contusion() {
		super("Contusion",utils.RandomNumbers.randomNumber(MIN_DURACION, MAX_DURACION));
		
	}
	

	@Override
	/**
	 * Metodo que divide el ataque por cada turno de duracion
	 */
	public void aplicarEfecto(modelo.Ente rival, modelo.Ente yo) {
		if(this.getDuracion() == 0) {
			//Si el turno es 0 revertimos el efecto
			this.setDuracion(this.getDuracion()-1);
			
			yo.setAtaque(yo.getAtaque_base());
			
		}
		else if(this.getDuracion() > 0) {
			
			yo.setAtaque(yo.getAtaque_base()/(this.getDuracion()+1));
			this.setDuracion(this.getDuracion()-1);

		}
		
	}
}