package modelo.efectos;
import modelo.Efecto;

/**
 * Clase que representa el efecto Quemadura
 * @author juanmi_rivas_8
 *
 */
public class Quemadura extends Efecto{
	private static final Integer MAX_DURACION = 5;
	private static final Integer MIN_DURACION = 2;
	
	
	public Quemadura(Integer duracion) {
		super("Quemadura",duracion);
	}
	
	public Quemadura() {
		super("Quemadura",utils.RandomNumbers.randomNumber(MIN_DURACION, MAX_DURACION));
		
	}
	

	@Override
	/**
	 * Metodo que reduce todas las resistencias un 5% por cada turno activo
	 */
	public void aplicarEfecto(modelo.Ente rival, modelo.Ente yo) {
		if(this.getDuracion() == 0) {
			//Si el turno es 0 revertimos el efecto
			this.setDuracion(this.getDuracion()-1);
			for(int i=0;i < yo.getResistencias().length;i++) {
				yo.getResistencias()[i].setPorcentaje(yo.getResistencias_base()[i].getPorcentaje());
			}
		}
		else if(this.getDuracion() > 0) {
			for(int i=0;i < yo.getResistencias().length;i++) {
				yo.getResistencias()[i].setPorcentaje(yo.getResistencias()[i].getPorcentaje()-0.05);
				
				if(yo.getResistencias()[i].getPorcentaje() < 0.0) {
					yo.getResistencias()[i].setPorcentaje(0.0);
				}
			}
			
			this.setDuracion(this.getDuracion()-1);

		}
		
	}
}
