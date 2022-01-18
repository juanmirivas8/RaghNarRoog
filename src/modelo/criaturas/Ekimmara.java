package modelo.criaturas;
import modelo.Ente;
import modelo.movimientos.*;
import modelo.resistencias.*;

/**
 * Clase que representa a una Ekimmara, vampiro medio.
 * @author juanmi_rivas_8
 *
 */
public class Ekimmara extends Ente{

	public static final Double MAX_VIDA=300.0;
	public static final Double MIN_VIDA=200.0;
	
	public static final Double MAX_ATAQUE=120.0;
	public static final Double MIN_ATAQUE=100.0;
	
	public static final Double MAX_DEFENSA=80.0;
	public static final Double MIN_DEFENSA=60.0;
	
/***********************Getters, setters y constructores*********************/
	public Ekimmara() {
		super("Ekimmara",utils.RandomNumbers.randomDouble(MIN_VIDA, MAX_VIDA),
				utils.RandomNumbers.randomDouble(MIN_ATAQUE, MAX_ATAQUE),
				utils.RandomNumbers.randomDouble(MIN_DEFENSA, MAX_DEFENSA));
		
		//Rellenamos los movimientos base y los copiamos 
		this.setMovimientos_base(new modelo.Movimiento[2]);
		this.getMovimientos_base()[0]= new AtaqueRapido();
		this.getMovimientos_base()[0].setNombre("Zarpazo");
		this.getMovimientos_base()[1]= new Mordisco();
		
		
		this.setMovimientos(new modelo.Movimiento[2]);
		this.getMovimientos()[0]= (modelo.Movimiento)this.getMovimientos_base()[0].clone();
		this.getMovimientos()[1]= (modelo.Movimiento)this.getMovimientos_base()[1].clone();
		
		
		
		//Rellenamos las resistencias
		this.getResistencias_base()[0]=new RCongelacion(0.5);
		this.getResistencias_base()[1]=new RFuego(0.5);
		this.getResistencias_base()[2]=new RSangrado(0.5);
		this.getResistencias_base()[3]=new RContusion(0.5);
		this.getResistencias_base()[4]=new RBloodLust(0.5);
		
		this.getResistencias()[0]= (modelo.Resistencia)this.getResistencias_base()[0].clone();
		this.getResistencias()[1]= (modelo.Resistencia)this.getResistencias_base()[1].clone();
		this.getResistencias()[2]= (modelo.Resistencia)this.getResistencias_base()[2].clone();
		this.getResistencias()[3]= (modelo.Resistencia)this.getResistencias_base()[3].clone();
		this.getResistencias()[4]= (modelo.Resistencia)this.getResistencias_base()[4].clone();
		
	}
	
	/**
	 * Metodo que implementa el lanzamiento automatico por parte del ente en cuestion. Notese que no todos los movimientos tienen por qué tener la misma probabilidad.
	 * @return Array de String para la posterior impresion del movimiento aplicado
	 */
	@Override
	public String[] lanzarMovimiento(Ente rival) {
		Integer tirada=utils.RandomNumbers.randomNumber(0,100);
		
		String[] retValue=null;
		
		if(tirada<=55) {
			retValue=this.getMovimientos()[0].aplicarMovimiento(rival,this);
		}else if (tirada > 55 ) {
			retValue=this.getMovimientos()[1].aplicarMovimiento(rival,this);
		}
			
		return retValue;
	}
}