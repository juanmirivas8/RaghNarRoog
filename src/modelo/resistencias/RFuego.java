package modelo.resistencias;
import modelo.Resistencia;
public class RFuego extends Resistencia{
	public static final Double MAX_RESISTENCIA = 0.5;
	public static final Double MIN_RESISTENCIA = 0.0;
	
	public RFuego() {
		super("Resistencia Fuego",utils.RandomNumbers.randomDouble(MIN_RESISTENCIA, MAX_RESISTENCIA),
				modelo.efectos.Quemadura.class);
	}
	
	public RFuego(Double res) {
		super("Resistencia Fuego",res, modelo.efectos.Quemadura.class);
	}
}
