package modelo;

import modelo.*;
import modelo.criaturas.*;
public class Partida {
	private Ente[] monstruos;
	private Ente protagonista;
	private Integer nMonstruos;
	
	
	public Partida(Integer nMonstruos) {
		this.nMonstruos=nMonstruos;
		monstruos = new Ente[nMonstruos];
		protagonista=new Geralt();
		this.randomMonsters();
	}
	
	public Partida() {
		this(2);
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
		for(int i = 0; i < monstruos.length; i++) {
			monstruos[i]=new Geralt();
		}
	}
	
	public Boolean endCondition() {
		Boolean end=false;
		
		if(!protagonista.isAlive()||monstersLeft() == 0) {
			end=true;
		}
		return end;
	}
	
	public Integer monstersLeft() {
		Integer ret=0;
		
		for (int i = 0; i < monstruos.length; i++) {
			if(monstruos[i]!=null) {
				ret++;
			}
		}
		return ret;
	}
}
