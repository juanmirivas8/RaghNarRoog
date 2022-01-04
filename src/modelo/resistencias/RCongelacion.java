package modelo.resistencias;
import modelo.Resistencia;
public class RCongelacion extends Resistencia{
	public static final Double MAX_RESISTENCIA = 0.5;
	public static final Double MIN_RESISTENCIA = 0.0;
	
	public RCongelacion() {
		super("Resistencia Congelacion",utils.RandomNumbers.randomDouble(MIN_RESISTENCIA, MAX_RESISTENCIA),
				modelo.efectos.Congelacion.class);
	}
	
	public RCongelacion(Double res) {
		super("Resistencia Congelacion",res, modelo.efectos.Congelacion.class);
	}
}
