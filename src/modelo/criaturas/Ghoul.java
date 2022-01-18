package modelo.criaturas;

import modelo.Ente;
import modelo.movimientos.Aard;
import modelo.movimientos.AtaquePotente;
import modelo.movimientos.AtaqueRapido;
import modelo.movimientos.Mordisco;
import modelo.resistencias.RBloodLust;
import modelo.resistencias.RCongelacion;
import modelo.resistencias.RContusion;
import modelo.resistencias.RFuego;
import modelo.resistencias.RSangrado;

public class Ghoul extends Ente {
	public static final Double MAX_VIDA = 250.0;
	public static final Double MIN_VIDA = 150.0;

	public static final Double MAX_ATAQUE = 150.0;
	public static final Double MIN_ATAQUE = 100.0;

	public static final Double MAX_DEFENSA = 50.0;
	public static final Double MIN_DEFENSA = 25.0;

	public Ghoul() {
		super("Ghoul", utils.RandomNumbers.randomDouble(MIN_VIDA, MAX_VIDA),
				utils.RandomNumbers.randomDouble(MIN_ATAQUE, MAX_ATAQUE),
				utils.RandomNumbers.randomDouble(MIN_DEFENSA, MAX_DEFENSA));

		// Rellenamos los movimientos base y los copiamos
		this.setMovimientos_base(new modelo.Movimiento[2]);
		this.getMovimientos_base()[0] = new AtaquePotente();
		this.getMovimientos_base()[0].setNombre("Placaje");
		this.getMovimientos_base()[1] = new AtaqueRapido();
		this.getMovimientos_base()[1].setNombre("Puas");

		this.setMovimientos(new modelo.Movimiento[2]);
		this.getMovimientos()[0] = (modelo.Movimiento) this.getMovimientos_base()[0].clone();
		this.getMovimientos()[1] = (modelo.Movimiento) this.getMovimientos_base()[1].clone();

		// Rellenamos las resistencias
		this.getResistencias_base()[0] = new RCongelacion();
		this.getResistencias_base()[1] = new RFuego();
		this.getResistencias_base()[2] = new RSangrado();
		this.getResistencias_base()[3] = new RContusion();
		this.getResistencias_base()[4] = new RBloodLust();

		this.getResistencias()[0] = (modelo.Resistencia) this.getResistencias_base()[0].clone();
		this.getResistencias()[1] = (modelo.Resistencia) this.getResistencias_base()[1].clone();
		this.getResistencias()[2] = (modelo.Resistencia) this.getResistencias_base()[2].clone();
		this.getResistencias()[3] = (modelo.Resistencia) this.getResistencias_base()[3].clone();
		this.getResistencias()[4] = (modelo.Resistencia) this.getResistencias_base()[4].clone();

	}

	/**
	 * Metodo que implementa el lanzamiento automatico por parte del ente en
	 * cuestion. Notese que no todos los movimientos tienen por qué tener la misma
	 * probabilidad.
	 * 
	 * @return Array de String para la posterior impresion del movimiento aplicado
	 */
	@Override
	public String[] lanzarMovimiento(Ente rival) {
		Integer tirada = utils.RandomNumbers.randomNumber(0, 100);

		String[] retValue = null;

		if (tirada <= 50) {
			retValue = this.getMovimientos()[0].aplicarMovimiento(rival, this);
		} else if (tirada > 50) {
			retValue = this.getMovimientos()[1].aplicarMovimiento(rival, this);
		}

		return retValue;

	}

}
