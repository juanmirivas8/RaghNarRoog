package modelo;

/**
 * Clase "pseudo-abstracta" que representa un ser, con todos los atributos y métodos necesarios
 * @author juanmi_rivas_8
 *
 */
public class Ente {
	private String nombre;
	private Double vida_base;
	private Double ataque_base;
	private Double defensa_base;
	private Movimiento[] movimientos_base;
	private Resistencia[] resistencias_base;
	
	private Efecto[] efectos;
	private Double vida;
	private Double ataque;
	private Double defensa;
	private Resistencia[] resistencias;
	private Movimiento[] movimientos;
	
	/******************Getters , Setters y Constructores*****************************/
	
	protected Ente(String nombre, Double vida_base, Double ataque_base, Double defensa_base) {
		this.nombre = nombre;
		this.vida_base = vida_base;
		this.ataque_base = ataque_base;
		this.defensa_base = defensa_base;
		this.vida=this.vida_base;
		this.ataque=this.ataque_base;
		this.defensa=this.defensa_base;
		this.efectos=new Efecto[2];
		this.resistencias_base= new Resistencia[2];
		this.resistencias= new Resistencia[2];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getVida_base() {
		return vida_base;
	}

	public void setVida_base(Double vida_base) {
		this.vida_base = vida_base;
	}

	public Double getAtaque_base() {
		return ataque_base;
	}

	public void setAtaque_base(Double ataque_base) {
		this.ataque_base = ataque_base;
	}

	public Double getDefensa_base() {
		return defensa_base;
	}

	public void setDefensa_base(Double defensa_base) {
		this.defensa_base = defensa_base;
	}

	public Movimiento[] getMovimientos_base() {
		return movimientos_base;
	}

	public void setMovimientos_base(Movimiento[] movimientos_base) {
		this.movimientos_base = movimientos_base;
	}

	public Resistencia[] getResistencias_base() {
		return resistencias_base;
	}

	public void setResistencias_base(Resistencia[] resistencias_base) {
		this.resistencias_base = resistencias_base;
	}

	public Efecto[] getEfectos() {
		return efectos;
	}

	public void setEfectos(Efecto[] efectos) {
		this.efectos = efectos;
	}

	public Double getVida() {
		return vida;
	}

	public void setVida(Double vida) {
		this.vida = vida;
	}

	public Double getAtaque() {
		return ataque;
	}

	public void setAtaque(Double ataque) {
		this.ataque = ataque;
	}

	public Double getDefensa() {
		return defensa;
	}

	public void setDefensa(Double defensa) {
		this.defensa = defensa;
	}

	public Resistencia[] getResistencias() {
		return resistencias;
	}

	public void setResistencias(Resistencia[] resistencias) {
		this.resistencias = resistencias;
	}

	public Movimiento[] getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Movimiento[] movimientos) {
		this.movimientos = movimientos;
	}
	
	
	/**
	 * Metodo "pseudo-abstracta" que se encarga de lanzar un movimiento aleatoriamente. Cada ente puede tener distintos ataques y éstos pueden tener distintas probabilidades.
	 * @param rival Ente rival al que se va a aplicar el movimiento.
	 * @return Array de Strings para imprimir posteriormente
	 */
	public String[] lanzarMovimiento(Ente rival) {
		String []retValue=null;
		
		return retValue;
	}
		
	
	/**
	 * Metodo que recorre el array de efectos del Ente y los aplica. Si la duración del efecto ha pasado, borra el efecto.
	 * @param rival Ente rival del que se leerán datos si es necesario
	 */
	public void aplicarEfectos(Ente rival) {
		
		for(int i = 0; i < this.getEfectos().length; i++) {
			if(this.getEfectos()[i]!=null) {
				
				this.getEfectos()[i].aplicarEfecto(rival, this);
				
				if(this.getEfectos()[i].getDuracion()<0) {
					this.getEfectos()[i]=null;
				}
			}
		}
		
		
	}
	
	/**
	 * Metodo que indica si el Ente está vivo o muerto
	 * @return Boolean true si vida > 0.0, false si <= 0.0
	 */
	public Boolean isAlive() {
		Boolean ret=false;
		
		if(this.getVida()>0.0) {
			ret=true;
		}
		
		return ret;
	}

	
}
