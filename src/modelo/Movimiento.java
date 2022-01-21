package modelo;

import java.lang.reflect.Constructor;


import utils.RandomNumbers;
import vista.Show;

/**
 * Clase "pseudo-abstracta" que contiene toda la información y metodos necesarios para aplicar un movimiento
 * @author juanmi_rivas_8
 *
 */
public class Movimiento {
	private String nombre;

	private Double probabilidad;
	private Double min_multiplicador;
	private Double max_multiplicador;
	private Double probabilidad_critico;
	private Double multiplicador_critico;
	private Double probabilidad_efecto;
	private Class<? extends Efecto> efecto;

	/******************Getters , Setters y Constructores*****************************/
	protected Movimiento(String nombre, Double probabilidad, Double min_multiplicador, Double max_multiplicador,
			Double probabilidad_critico, Double multiplicador_critico, Double probabilidad_efecto,
			Class<? extends Efecto> efecto) {
		this.nombre = nombre;
		this.probabilidad = probabilidad;
		this.min_multiplicador = min_multiplicador;
		this.max_multiplicador = max_multiplicador;
		this.probabilidad_critico = probabilidad_critico;
		this.multiplicador_critico = multiplicador_critico;
		this.probabilidad_efecto = probabilidad_efecto;
		this.efecto = efecto;
		
	}

	public Double getMultiplicador() {
		return RandomNumbers.randomDouble(min_multiplicador, max_multiplicador);
	}

	public Double getMin_multiplicador() {
		return min_multiplicador;
	}

	public void setMin_multiplicador(Double min_multiplicador) {
		this.min_multiplicador = min_multiplicador;
	}

	public Double getMax_multiplicador() {
		return max_multiplicador;
	}

	public void setMax_multiplicador(Double max_multiplicador) {
		this.max_multiplicador = max_multiplicador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(Double probabilidad) {
		this.probabilidad = probabilidad;
	}

	public Double getProbabilidad_critico() {
		return probabilidad_critico;
	}

	public void setProbabilidad_critico(Double probabilidad_critico) {
		this.probabilidad_critico = probabilidad_critico;
	}

	public Double getMultiplicador_critico() {
		return multiplicador_critico;
	}

	public void setMultiplicador_critico(Double multiplicador_critico) {
		this.multiplicador_critico = multiplicador_critico;
	}

	public Double getProbabilidad_efecto() {
		return probabilidad_efecto;
	}

	public void setProbabilidad_efecto(Double probabilidad_efecto) {
		this.probabilidad_efecto = probabilidad_efecto;
	}

	public Class<? extends Efecto> getEfecto() {
		return efecto;
	}

	public void setEfecto(Class<? extends Efecto> efecto) {
		this.efecto = efecto;
	}

	
	/**
	 * Metodo que aplica un movimiento de un Ente a otro
	 * @param rival Ente que recibe el movimiento
	 * @param yo Ente que lanza el movimiento
	 * @return Array de Strings con toda la información necesaria para su posterior impresion por pantalla
	 */
	public String[] aplicarMovimiento(Ente rival, Ente yo) {

		Resistencia r = null;
		String[] retValue = new String[8];
		
		//Buscamos la resistencia que corresponde al tipo de efecto que aplica
		if(rival.getResistencias()!=null) {
			for (int i = 0; i < rival.getResistencias().length; i++) {
				if (rival.getResistencias()[i].getEfecto() == this.getEfecto()) {
					r = rival.getResistencias()[i];
				}
			}
		}
		
	
		//Ataque es el ataque del atacante por el multiplicador del movimiento
		Double ataque=this.getMultiplicador() * yo.getAtaque();
		//Calculamos la defensa mediante la defensa del defensor por su resistencia al tipo de ataque
		Double defensa=(r != null) ? (r.getPorcentaje() * rival.getDefensa()) : (rival.getDefensa());
		//Se calcula si se acierta el ataque o no con la probabilidad de exito del ataque
		Boolean acierto=RandomNumbers.randomChance(this.probabilidad);
		//Se calcula si se aplica el ataque o no con la probabilidad de lograr critico
		Boolean critico=RandomNumbers.randomChance(this.probabilidad_critico);
		//Se calcula si se aplica el ataque o no con la probabilidad de aplicar efecto
		Boolean efecto=RandomNumbers.randomChance(this.probabilidad_efecto);
		//Daño del movimiento
		Double damage=(ataque-defensa > 0.0) ? (ataque-defensa) : (0.0);
		
		
		retValue[0]=yo.getNombre();
		retValue[1]=rival.getNombre();
		retValue[2]=this.nombre;
		retValue[3]=acierto.toString();
		retValue[4]=critico.toString();
		retValue[5]=efecto.toString();
		retValue[6]=damage.toString();
		retValue[7]=this.efecto.getSimpleName();
		
		//Si se acierta se sigue con el ataque
		if(acierto) {
			//Si el ataque es critico
			if(critico) {
				damage*=this.multiplicador_critico;
				rival.setVida(rival.getVida() - damage);
				retValue[6]=damage.toString();
				
			}//Si es normal
			else {
				rival.setVida(rival.getVida() - damage);
				
			}
			//Si se aplica efecto
			if(efecto) {
				
				
				int j = -1;
				
				//Buscamos la posicion donde insertar el efecto - Encima del mismo efecto si ya lo tiene o en el primer hueco
				for (int i = 0; i < rival.getEfectos().length; i++) {
					if (rival.getEfectos()[i] == null && j==-1) {
						j=i;
					} else if (rival.getEfectos()[i] != null && this.efecto == rival.getEfectos()[i].getClass()) {
						j = i;
						i = rival.getEfectos().length;
					}
				}
				
				Constructor<?>[] constructor = this.efecto.getConstructors();
				try {
					Efecto obj = (Efecto)constructor[0].newInstance();
					rival.getEfectos()[j]=(Efecto)obj;
				} catch (Exception ex) {
					
				}
				
			}
		}
		return retValue;
	}

	
	
	@Override
	public String toString() {
		return nombre + " , prob exito= " + probabilidad + " , rango mult= " + min_multiplicador +" - "+ max_multiplicador + 
				" , prob critico= "+ probabilidad_critico + " ,mult critico= " + multiplicador_critico + " , prob efecto= "
				+ probabilidad_efecto+ " ,Efecto apl= "+efecto.getSimpleName();
	}

	@Override
	public Object clone() {
		Movimiento a = new Movimiento(this.nombre, this.probabilidad, this.min_multiplicador, this.max_multiplicador,
				this.probabilidad_critico, this.multiplicador_critico, this.probabilidad_efecto, this.efecto);

		return a;
	}

}
