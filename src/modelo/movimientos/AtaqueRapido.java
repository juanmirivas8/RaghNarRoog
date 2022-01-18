package modelo.movimientos;


import modelo.efectos.Sangrado;

/**
 * Clase que representa el ataque Ataque Rapido, el cual provoca Sangrado
 * @author juanmi_rivas_8
 *
 */
public class AtaqueRapido extends modelo.Movimiento{

	public static final Double PROBABILIDAD=0.9;
	public static final Double MIN_MULTIPLICADOR=0.4;
	public static final Double MAX_MULTIPLICADOR=0.6;
	public static final Double PROBABILIDAD_EFECTO=0.35;
	
	public static final Double PROBABILIDAD_CRITICO=0.4;
	public static final Double MULTIPLICADOR_CRITICO=1.5;
	
	public AtaqueRapido(String nombre, Double probabilidad, Double min_multiplicador, Double max_multiplicador,
			Double probabilidad_critico, Double multiplicador_critico, Double probabilidad_efecto,
			Class<Sangrado> efecto) {
		super(nombre, probabilidad, min_multiplicador, max_multiplicador, probabilidad_critico, multiplicador_critico,
				probabilidad_efecto, efecto);
		
	}
	
	public AtaqueRapido() {
		this("Ataque Rapido",PROBABILIDAD,MIN_MULTIPLICADOR,MAX_MULTIPLICADOR,PROBABILIDAD_CRITICO,
				MULTIPLICADOR_CRITICO,PROBABILIDAD_EFECTO,Sangrado.class);
	}
	

	
}