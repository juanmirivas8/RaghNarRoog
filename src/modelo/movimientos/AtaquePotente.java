package modelo.movimientos;


import modelo.efectos.Contusion;

/**
 * Clase que representa el ataque Aard, el cual provoca Congelacion
 * @author juanmi_rivas_8
 *
 */
public class AtaquePotente extends modelo.Movimiento{

	public static final Double PROBABILIDAD=0.5;
	public static final Double MIN_MULTIPLICADOR=0.8;
	public static final Double MAX_MULTIPLICADOR=1.0;
	public static final Double PROBABILIDAD_EFECTO=0.7;
	
	public static final Double PROBABILIDAD_CRITICO=0.2;
	public static final Double MULTIPLICADOR_CRITICO=2.0;
	
	public AtaquePotente(String nombre, Double probabilidad, Double min_multiplicador, Double max_multiplicador,
			Double probabilidad_critico, Double multiplicador_critico, Double probabilidad_efecto,
			Class<Contusion> efecto) {
		super(nombre, probabilidad, min_multiplicador, max_multiplicador, probabilidad_critico, multiplicador_critico,
				probabilidad_efecto, efecto);
		
	}
	
	public AtaquePotente() {
		this("Ataque Potente",PROBABILIDAD,MIN_MULTIPLICADOR,MAX_MULTIPLICADOR,PROBABILIDAD_CRITICO,
				MULTIPLICADOR_CRITICO,PROBABILIDAD_EFECTO,Contusion.class);
	}
	

	
}
