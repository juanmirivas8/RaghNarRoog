package modelo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import utils.RandomNumbers;

public class Movimiento {
	private String nombre;

	private Double probabilidad;
	private Double min_multiplicador;
	private Double max_multiplicador;
	private Double probabilidad_critico;
	private Double multiplicador_critico;
	private Double probabilidad_efecto;

	private Class<? extends Efecto> efecto;

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

	public void aplicarMovimiento(Ente e) {

		// 1º - Encontramos la resistencia que coincide con el efecto del ataque
		Resistencia r = null;
		Double damage;
		
		if(e.getResistencias()!=null) {
			for (int i = 0; i < e.getResistencias().length; i++) {
				if (e.getResistencias()[i].getEfecto() == this.getEfecto()) {
					r = e.getResistencias()[i];
				}
			}
		}
		
		// 2º- Calculamos la defensa multiplicando el porcentaje de resistencia por la
		// defensa del ente
		Double defensa;

		defensa = (r != null) ? (r.getPorcentaje() * e.getDefensa()) : (e.getDefensa());

		/*
		 * 3º - Calculamos el daño dependiendo de si primero se acierta el ataque, y
		 * luego de si es critico o no
		 */
		if (RandomNumbers.randomChance(this.probabilidad)) {

			damage = this.getMultiplicador() * e.getAtaque();

			if (RandomNumbers.randomChance(this.probabilidad_critico)) {
				damage *= this.multiplicador_critico;
			}
			/** 4º - Aplicamos el daño al ente */
			Double res = damage - defensa;
			if (res > 0.0) {
				e.setVida(e.getVida() - res);
			} else {
				res = 0.0;
			}

			/** 5º - Aplicamos el efecto */
			
			if (RandomNumbers.randomChance(this.probabilidad_efecto)) {
				int j = -1;
			/** 6-º - Para poder aplicar el efecto debemos encontrar si ya hay uno aplicado al ente o 
			 * si no lo hay encontrar un hueco libre en el array de efectos del ente
			 * */
				for (int i = 0; i <= e.getEfectos().length; i++) {
					if (e.getEfectos()[i] == null && j==-1) {
						j=i;
					} else if (e.getEfectos()[i] != null && this.efecto == e.getEfectos()[i].getClass()) {
						j = i;
						i = e.getEfectos().length;
					}
				}
				
				/** 7º - Generamos una nueva instancia de efecto y la asignamos a la posicion encontrada */
				
				Constructor[] constructor = this.efecto.getConstructors();
				try {
					Efecto obj = (Efecto)constructor[0].newInstance();
					e.getEfectos()[j]=(Efecto)obj;
				} catch (Exception ex) {
					
				}
					
			}
		}

	}

	@Override
	public Object clone() {
		Movimiento a = new Movimiento(this.nombre, this.probabilidad, this.min_multiplicador, this.max_multiplicador,
				this.probabilidad_critico, this.multiplicador_critico, this.probabilidad_efecto, this.efecto);

		return a;
	}

}
