package modelo.resistencias;
import modelo.Resistencia;

/**
 * Clase que guarda el valor de resistencia a los movimientos que aplican BloodLust
 * @author juanmi_rivas_8
 *
 */
public class RBloodLust extends Resistencia{
	public static final Double MAX_RESISTENCIA = 0.5;
	public static final Double MIN_RESISTENCIA = 0.0;
	
	public RBloodLust() {
		super("Resistencia Bloodlust",utils.RandomNumbers.randomDouble(MIN_RESISTENCIA, MAX_RESISTENCIA),
				modelo.efectos.BloodLust.class);
	}
	
	public RBloodLust(Double res) {
		super("Resistencia BloodLust",res, modelo.efectos.BloodLust.class);
	}
}
