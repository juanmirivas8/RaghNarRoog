package modelo.movimientos;


import modelo.efectos.BloodLust;

/**
 * Clase que representa el ataque Mordisco, el cual provoca Bloodlust
 * @author juanmi_rivas_8
 *
 */
public class Mordisco extends modelo.Movimiento{

	public static final Double PROBABILIDAD=0.6;
	public static final Double MIN_MULTIPLICADOR=0.5;
	public static final Double MAX_MULTIPLICADOR=0.75;
	public static final Double PROBABILIDAD_EFECTO=0.3;
	
	public static final Double PROBABILIDAD_CRITICO=0.3;
	public static final Double MULTIPLICADOR_CRITICO=2.0;
	
	public Mordisco(String nombre, Double probabilidad, Double min_multiplicador, Double max_multiplicador,
			Double probabilidad_critico, Double multiplicador_critico, Double probabilidad_efecto,
			Class<BloodLust> efecto) {
		super(nombre, probabilidad, min_multiplicador, max_multiplicador, probabilidad_critico, multiplicador_critico,
				probabilidad_efecto, efecto);
		
	}
	
	public Mordisco() {
		this("Mordisco",PROBABILIDAD,MIN_MULTIPLICADOR,MAX_MULTIPLICADOR,PROBABILIDAD_CRITICO,
				MULTIPLICADOR_CRITICO,PROBABILIDAD_EFECTO,BloodLust.class);
	}
	

	
}
