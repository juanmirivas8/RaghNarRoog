package modelo.criaturas;
import modelo.Ente;
import modelo.movimientos.*;
import modelo.resistencias.*;

public class Geralt extends Ente{

	public static final Double MAX_VIDA=1000.0;
	public static final Double MIN_VIDA=1000.0;
	
	public static final Double MAX_ATAQUE=200.0;
	public static final Double MIN_ATAQUE=200.0;
	
	public static final Double MAX_DEFENSA=100.0;
	public static final Double MIN_DEFENSA=100.0;
	
	public Geralt() {
		super("Geralt",utils.RandomNumbers.randomDouble(MIN_VIDA, MAX_VIDA),
				utils.RandomNumbers.randomDouble(MIN_ATAQUE, MAX_ATAQUE),
				utils.RandomNumbers.randomDouble(MIN_DEFENSA, MAX_DEFENSA));
		
		//Rellenamos los movimientos base y los copiamos 
		this.setMovimientos_base(new modelo.Movimiento[7]);
		this.getMovimientos_base()[0]= new Aard();
		this.getMovimientos_base()[1]= new Igni();
		
		this.setMovimientos(new modelo.Movimiento[7]);
		this.getMovimientos()[0]= (modelo.Movimiento)this.getMovimientos_base()[0].clone();
		this.getMovimientos()[1]= (modelo.Movimiento)this.getMovimientos_base()[1].clone();
		
		//Rellenamos las resistencias
		this.getResistencias_base()[0]=new RCongelacion(0.5);
		this.getResistencias_base()[1]=new RFuego(0.5);
		
		
	}
	
	@Override
	public void lanzarMovimiento(Ente e) {
		Integer tirada=utils.RandomNumbers.randomNumber(0,100);
		
		if(tirada<=50) {
			this.getMovimientos()[0].aplicarMovimiento(e);
		}else if (tirada>50) {
			this.getMovimientos()[1].aplicarMovimiento(e);
		}
			
		
	}
}
