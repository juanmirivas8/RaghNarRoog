import modelo.resistencias.RCongelacion;

public class Ejecutable {

	public static void main(String[] args) {
		
		controlador.Controlador.inicioPrograma();
		
		
	}

	public static void pruebaBusquedaResistencia() {
		modelo.Resistencia[] rs= {new modelo.resistencias.RFuego(), new modelo.resistencias.RCongelacion(),new modelo.resistencias.RFuego()};
		modelo.Resistencia re= new modelo.resistencias.RFuego();
		if(rs!=null) {
			for (int i = 0; i < rs.length; i++) {
				if (rs[i].getEfecto() ==  re.getEfecto()){
					System.out.println(i);
				}
			}
		}
	}
}
