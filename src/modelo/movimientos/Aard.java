package modelo.movimientos;


import modelo.efectos.Congelacion;

/**
 * Clase que representa el ataque Aard, el cual provoca Congelacion
 * @author juanmi_rivas_8
 *
 */
public class Aard extends modelo.Movimiento{

	public static final Double PROBABILIDAD=0.7;
	public static final Double MIN_MULTIPLICADOR=0.6;
	public static final Double MAX_MULTIPLICADOR=0.7;
	public static final Double PROBABILIDAD_EFECTO=0.2;
	
	public static final Double PROBABILIDAD_CRITICO=0.2;
	public static final Double MULTIPLICADOR_CRITICO=2.0;
	
	public Aard(String nombre, Double probabilidad, Double min_multiplicador, Double max_multiplicador,
			Double probabilidad_critico, Double multiplicador_critico, Double probabilidad_efecto,
			Class<Congelacion> efecto) {
		super(nombre, probabilidad, min_multiplicador, max_multiplicador, probabilidad_critico, multiplicador_critico,
				probabilidad_efecto, efecto);
		
	}
	
	public Aard() {
		this("Aard",PROBABILIDAD,MIN_MULTIPLICADOR,MAX_MULTIPLICADOR,PROBABILIDAD_CRITICO,
				MULTIPLICADOR_CRITICO,PROBABILIDAD_EFECTO,Congelacion.class);
	}
	

	
}
