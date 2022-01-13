package modelo;



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
	
	public String[] lanzarMovimiento(Ente rival) {
		String []retValue=null;
		
		return retValue;
	}
		
	
	
	public void aplicarEfectos(Ente rival) {
		
		for(int i = 0; i < rival.getEfectos().length; i++) {
			if(rival.getEfectos()[i]!=null) {
				
				rival.getEfectos()[i].aplicarEfecto(rival, this);
				
				if(rival.getEfectos()[i].getDuracion()<0) {
					rival.getEfectos()[i]=null;
				}
			}
		}
		
		
	}
	
	public Boolean isAlive() {
		Boolean ret=false;
		
		if(this.getVida()>0.0) {
			ret=true;
		}
		
		return ret;
	}

	
}
