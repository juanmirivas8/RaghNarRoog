package modelo.efectos;
import modelo.Efecto;
import modelo.Resistencia;
public class Quemadura extends Efecto{
	private static final Integer MAX_DURACION = 5;
	private static final Integer MIN_DURACION = 2;
	
	private Integer contador=1;
	public Quemadura(Integer duracion) {
		super("Quemadura",duracion);
	}
	
	public Quemadura() {
		super("Quemadura",utils.RandomNumbers.randomNumber(MIN_DURACION, MAX_DURACION));
		
	}
	
	
	@Override
	public void aplicarEfecto(modelo.Ente rival, modelo.Ente yo) {
		
		if(this.getDuracion()>0) {
			Double damage = yo.getAtaque()*0.05*contador;
			Resistencia r = null;
			
			if(rival.getResistencias()!=null) {
				for (int i = 0; i < rival.getResistencias().length; i++) {
					if (rival.getResistencias()[i].getEfecto() == this.getClass()) {
						r = rival.getResistencias()[i];
					}
				}
			}
			
			Double defensa;
			defensa = (r != null) ? (r.getPorcentaje()) : (0.0);
			damage-=damage*defensa;
			contador++;
			
			rival.setVida(rival.getVida()-damage);
			this.setDuracion(this.getDuracion()-1);
			
		}
	}
}
