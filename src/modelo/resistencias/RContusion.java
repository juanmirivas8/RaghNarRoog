package modelo.resistencias;
import modelo.Resistencia;

/**
 * Clase que guarda el valor de resistencia a los movimientos que aplican Quemadura
 * @author juanmi_rivas_8
 *
 */
public class RContusion extends Resistencia{
	public static final Double MAX_RESISTENCIA = 0.5;
	public static final Double MIN_RESISTENCIA = 0.0;
	
	public RContusion() {
		super("Resistencia Contusion",utils.RandomNumbers.randomDouble(MIN_RESISTENCIA, MAX_RESISTENCIA),
				modelo.efectos.Contusion.class);
	}
	
	public RContusion(Double res) {
		super("Resistencia Contusion",res, modelo.efectos.Contusion.class);
	}
}
