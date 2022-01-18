package modelo.efectos;
import modelo.Efecto;


/**
 * Clase que representa el efecto Sangrado
 * @author juanmi_rivas_8
 *
 */
public class Sangrado extends Efecto{
	private static final Integer MAX_DURACION = 3;
	private static final Integer MIN_DURACION = 2;
	
	
	public Sangrado(Integer duracion) {
		super("Sangrado",duracion);
	}
	
	public Sangrado() {
		super("Sangrado",utils.RandomNumbers.randomNumber(MIN_DURACION, MAX_DURACION));
		
	}
	

	@Override
	/**
	 * Efecto que aplica daño cada turno
	 */
	public void aplicarEfecto(modelo.Ente rival, modelo.Ente yo) {
			if(this.getDuracion() > 0) {
				Double r=0.0;
				Double damage=0.0;
				
				for(int i = 0; i < yo.getResistencias().length; i++) {
					if(yo.getResistencias()[i].getEfecto()==this.getClass()) {
						r=yo.getResistencias()[i].getPorcentaje();
					}
					
				}
				
				damage=rival.getAtaque();
				damage=damage/2.0 - yo.getDefensa()*r;
				yo.setVida(yo.getVida() - damage);
			}
			
			this.setDuracion(this.getDuracion()-1);

		}
		
}