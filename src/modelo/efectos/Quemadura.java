package modelo.efectos;
import modelo.Efecto;

public class Quemadura extends Efecto{
	private static final Integer MAX_DURACION = 5;
	private static final Integer MIN_DURACION = 2;
	
	
	public Quemadura(Integer duracion) {
		super("Quemadura",duracion);
	}
	
	public Quemadura() {
		super("Quemadura",utils.RandomNumbers.randomNumber(MIN_DURACION, MAX_DURACION));
		
	}
	

	@Override
	public String aplicarEfecto(modelo.Ente rival, modelo.Ente yo) {
		
		String retValue = null;
		
		if(this.getDuracion() == 0) {
			//Si el turno es 0 revertimos el efecto
			for(int i=0;i < rival.getResistencias().length;i++) {
				rival.getResistencias()[i].setPorcentaje(rival.getResistencias_base()[i].getPorcentaje());
			}
			
			retValue=this.toString();
			
		}
		else if(this.getDuracion() > 0) {
			
			retValue=this.toString();
			
			for(int i=0;i < rival.getResistencias().length;i++) {
				rival.getResistencias()[i].setPorcentaje(rival.getResistencias()[i].getPorcentaje()-0.05);
				
				if(rival.getResistencias()[i].getPorcentaje() < 0.0) {
					rival.getResistencias()[i].setPorcentaje(0.0);
				}
			}
			
			this.setDuracion(this.getDuracion()-1);

		}
		
		return retValue;
	}
}
