package modelo.resistencias;
import modelo.Resistencia;

/**
 * Clase que guarda el valor de resistencia a los movimientos que aplican Sangrado
 * @author juanmi_rivas_8
 *
 */
public class RSangrado extends Resistencia{
	public static final Double MAX_RESISTENCIA = 0.5;
	public static final Double MIN_RESISTENCIA = 0.0;
	
	public RSangrado() {
		super("Resistencia Sangrado",utils.RandomNumbers.randomDouble(MIN_RESISTENCIA, MAX_RESISTENCIA),
				modelo.efectos.Sangrado.class);
	}
	
	public RSangrado(Double res) {
		super("Resistencia Sangrado",res, modelo.efectos.Sangrado.class);
	}
}
