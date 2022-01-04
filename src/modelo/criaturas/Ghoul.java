package modelo.criaturas;
import modelo.Ente;
import modelo.movimientos.Aard;

public class Ghoul extends Ente{
	public static final Double MAX_VIDA=250.0;
	public static final Double MIN_VIDA=150.0;
	
	public static final Double MAX_ATAQUE=50.0;
	public static final Double MIN_ATAQUE=30.0;
	
	public static final Double MAX_DEFENSA=30.0;
	public static final Double MIN_DEFENSA=15.0;
	
	public Ghoul(){
		super("Ghoul",utils.RandomNumbers.randomDouble(MIN_VIDA, MAX_VIDA),
				utils.RandomNumbers.randomDouble(MIN_ATAQUE, MAX_ATAQUE),
				utils.RandomNumbers.randomDouble(MIN_DEFENSA, MAX_DEFENSA));
		
		this.setMovimientos_base(new modelo.Movimiento[1]);
		this.getMovimientos_base()[0]= new Aard();
		
		this.setMovimientos(new modelo.Movimiento[1]);
		this.getMovimientos()[0]= (modelo.Movimiento)this.getMovimientos_base()[0].clone();
		
		
	}
	
}
