package modelo.efectos;
import modelo.Efecto;

/**
 * Clase que representa el efecto BloodLust
 * @author juanmi_rivas_8
 *
 */
public class BloodLust extends Efecto{
	private static final Integer MAX_DURACION = 5;
	private static final Integer MIN_DURACION = 2;
	
	
	public BloodLust(Integer duracion) {
		super("BloodLust",duracion);
	}
	
	public BloodLust() {
		super("BloodLust",utils.RandomNumbers.randomNumber(MIN_DURACION, MAX_DURACION));
		
	}
	

	@Override
	/**
	 * Metodo que reduce todas las resistencias un 5% por cada turno activo
	 */
	public void aplicarEfecto(modelo.Ente rival, modelo.Ente yo) {
		if(this.getDuracion() == 0) {
			//Si el turno es 0 revertimos el efecto
			this.setDuracion(this.getDuracion()-1);

		}
		else if(this.getDuracion() > 0) {
			
			for(int i=0;i < yo.getEfectos().length;i++) {
				if(yo.getEfectos()[i].getClass() == Sangrado.class) {
					rival.setVida(rival.getVida()+rival.getAtaque());
				}
			}
			
			this.setDuracion(this.getDuracion()-1);
			
		}
		
	}
}