package modelo;

import java.lang.reflect.Constructor;

import modelo.*;
import modelo.criaturas.*;

/**
 * Clase que contiene los datos necesarios para generar una partida
 * @author juanmi_rivas_8
 *
 */
public class Partida {
	
	private Ente[] monstruos;
	private Ente protagonista;
	private static final Class[] classList = { Ghoul.class, Geralt.class };

	/******************Getters , Setters y Constructores*****************************/
	public Partida(Integer nMonstruos) {

		monstruos = new Ente[nMonstruos];
		protagonista = new Geralt();
		//this.randomMonsters();
		monstruos[0]=new Geralt();
		monstruos[0].setNombre("Lambert");
	}

	public Partida() {
		this(1);
	}

	public Ente[] getMonstruos() {
		return monstruos;
	}

	public void setMonstruos(Ente[] monstruos) {
		this.monstruos = monstruos;
	}

	public Ente getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(Ente protagonista) {
		this.protagonista = protagonista;
	}

	/**
	 * Metodo que genera un array de monstruos aleatoriamente
	 */
	private void randomMonsters() {
		for (int i = 0; i < monstruos.length; i++) {
			Integer tirada = utils.RandomNumbers.randomNumber(0, 100);
			
			if (tirada <= 80) {
				Constructor<?>[] constructor = classList[0].getConstructors();
				try {
					Ente obj = (Ente)constructor[0].newInstance();
					monstruos[i]=obj;
				} catch (Exception ex) {};
			} else if (tirada > 80) {
				Constructor<?>[] constructor = classList[1].getConstructors();
				try {
					Ente obj = (Ente)constructor[0].newInstance();
					monstruos[i]=obj;
				} catch (Exception ex) {};
			}
		}
	}

	/**
	 * Metodo que indica si la partida ha acabado o no. Si el protagonista ha muerto o si ya no quedan monstruos por derrotar la partida acaba.
	 * @return true si se cumplen las condiciones de fin de partida y false en otro caso.
	 */
	public Boolean endCondition() {
		Boolean end = false;

		if (!protagonista.isAlive() || monstersLeft() == 0) {
			end = true;
		}
		return end;
	}

	/**
	 * Devuelve la cantidad de monstruos restantes. Para ello comprueba si cada posicion del array de monstruos es distinto de null.
	 * @return Integer con la cantidad de monstruos aun por derrotar
	 */
	public Integer monstersLeft() {
		Integer ret = 0;

		for (int i = 0; i < monstruos.length; i++) {
			if (monstruos[i] != null) {
				ret++;
			}
		}
		return ret;
	}
}
