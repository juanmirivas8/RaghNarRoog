package modelo.criaturas;
import modelo.Ente;
import modelo.movimientos.*;
import modelo.resistencias.*;

/**
 * Clase que representa a Geralt, protagonista del proyecto y brujo profesional
 * @author juanmi_rivas_8
 *
 */
public class Geralt extends Ente{

	public static final Double MAX_VIDA=1000.0;
	public static final Double MIN_VIDA=1000.0;
	
	public static final Double MAX_ATAQUE=150.0;
	public static final Double MIN_ATAQUE=150.0;
	
	public static final Double MAX_DEFENSA=100.0;
	public static final Double MIN_DEFENSA=100.0;
	
/***********************Getters, setters y constructores*********************/
	public Geralt() {
		super("Geralt",utils.RandomNumbers.randomDouble(MIN_VIDA, MAX_VIDA),
				utils.RandomNumbers.randomDouble(MIN_ATAQUE, MAX_ATAQUE),
				utils.RandomNumbers.randomDouble(MIN_DEFENSA, MAX_DEFENSA));
		
		//Rellenamos los movimientos base y los copiamos 
		this.setMovimientos_base(new modelo.Movimiento[4]);
		this.getMovimientos_base()[0]= new Aard();
		this.getMovimientos_base()[1]= new Igni();
		this.getMovimientos_base()[2]= new AtaqueRapido();
		this.getMovimientos_base()[3]= new AtaquePotente();
		
		this.setMovimientos(new modelo.Movimiento[4]);
		this.getMovimientos()[0]= (modelo.Movimiento)this.getMovimientos_base()[0].clone();
		this.getMovimientos()[1]= (modelo.Movimiento)this.getMovimientos_base()[1].clone();
		this.getMovimientos()[2]= (modelo.Movimiento)this.getMovimientos_base()[2].clone();
		this.getMovimientos()[3]= (modelo.Movimiento)this.getMovimientos_base()[3].clone();
		
		
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
		
		if(tirada<=15) {
			retValue=this.getMovimientos()[0].aplicarMovimiento(rival,this);
		}else if (tirada > 15 && tirada <= 35) {
			retValue=this.getMovimientos()[1].aplicarMovimiento(rival,this);
		}else if(tirada > 35 && tirada <= 70) {
			retValue=this.getMovimientos()[2].aplicarMovimiento(rival,this);
		}else if(tirada > 70) {
			retValue=this.getMovimientos()[3].aplicarMovimiento(rival,this);
		}
			
		return retValue;
	}
}
