package modelo.movimientos;

import modelo.efectos.Quemadura;

/**
 * Clase que representa el ataque Igni, el cual provoca Quemadura
 * @author juanmi_rivas_8
 *
 */
public class Igni extends modelo.Movimiento{

	public static final Double PROBABILIDAD=0.6;
	public static final Double MIN_MULTIPLICADOR=0.5;
	public static final Double MAX_MULTIPLICADOR=0.8;
	public static final Double PROBABILIDAD_EFECTO=0.15;
	
	public static final Double PROBABILIDAD_CRITICO=0.25;
	public static final Double MULTIPLICADOR_CRITICO=2.0;
	
	public Igni(String nombre, Double probabilidad, Double min_multiplicador, Double max_multiplicador,
			Double probabilidad_critico, Double multiplicador_critico, Double probabilidad_efecto,
			Class<Quemadura> efecto) {
		super(nombre, probabilidad, min_multiplicador, max_multiplicador, probabilidad_critico, multiplicador_critico,
				probabilidad_efecto, efecto);
		
	}
	
	public Igni() {
		this("Igni",PROBABILIDAD,MIN_MULTIPLICADOR,MAX_MULTIPLICADOR,PROBABILIDAD_CRITICO,
				MULTIPLICADOR_CRITICO,PROBABILIDAD_EFECTO,Quemadura.class);
	}
	

	
}