package modelo;

import java.lang.reflect.Constructor;

import modelo.*;
import modelo.criaturas.*;

public class Partida {
	private Ente[] monstruos;
	private Ente protagonista;

	private static final Class[] classList = { Ghoul.class, Geralt.class };

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

	public Boolean endCondition() {
		Boolean end = false;

		if (!protagonista.isAlive() || monstersLeft() == 0) {
			end = true;
		}
		return end;
	}

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
