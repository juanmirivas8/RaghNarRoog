package vista;

import modelo.Ente;

/**
 * Clase que contiene los principales métodos para impresión por pantalla.
 * @author juanmi_rivas_8
 *
 */
public class GUI {

	/**
	 * Metodo que imprime el menu principal
	 */
	public static void printMainMenu() {
		Show.println("\n");
		Show.println("----------Bienvenido a Ragh Nar Roog----------");
		Show.println("\n");
		Show.println("----------------------------------------------");
		Show.println("[1] - Comenzar Partida ");
		Show.println("[0] - Salir del programa ");
		Show.println("\n");
		Show.println("----------------------------------------------");
	}
	
	/**
	 * Metodo que imprime de forma muy completa al Ente pasado por parámetro
	 * @param e Ente a imprimir
	 */
	public static void infoEnte(Ente e) {
		Show.println("Nombre: "+e.getNombre());
		Show.println("Vida base: "+e.getVida_base()+" Ataque base: "+e.getAtaque_base()+" Defensa base: "+e.getDefensa_base());
		Show.println("Vida actl: "+e.getVida()+" Ataque actl: "+e.getAtaque()+ " Defensa actl: "+e.getDefensa());
		
		Show.println("\n------Lista de Resistencias Base/Actuales------\n");
		for(int i = 0; i < e.getResistencias_base().length; i++ ) {
			Show.println(e.getResistencias_base()[i]);
			Show.println(e.getResistencias()[i]);
			Show.println("");
		}
		
		Show.println("\n------Lista de Movimientos Base/Actuales-------\n");
		for(int i = 0; i < e.getMovimientos_base().length; i++ ) {
			Show.println(e.getMovimientos_base()[i]);
			Show.println(e.getMovimientos()[i]);
			Show.println("");
		}
		Show.println("\n------------Lista de Efectos Activos----------\n");
		
		int j=0;
		for(int i = 0; i < e.getEfectos().length; i++ ) {
			if(e.getEfectos()[i]!=null) {
				Show.println(e.getEfectos()[i]);
				j++;
			}
		}
		
		if(j==0) {
			Show.println("No hay efectos activos");
		}
		
		Show.println("----------------------------------------------");
	}
	

	/**
	 * Metodo que imprime de forma completa un movimiento.
	 * @param datos array de Strings devuelto por la funcion aplicarMovimiento() de la clase Movimiento
	 */
	public static void muestraMovimiento(String[]datos) {
		Show.println("\n");
		Show.print(datos[0]+" uso "+datos[2]+" contra "+datos[1]);
		if(Boolean.valueOf(datos[3])) {
			if(Boolean.valueOf(datos[4])) {
				Show.print(" -- Ataque critico -- Daño: "+datos[6]+" -- ");
			}else {
				Show.print(" -- Ataque normal -- Daño: "+datos[6]+" -- ");
			}
			
			if(Boolean.valueOf(datos[5])) {
				Show.print(" -- Se aplico "+datos[7]+" -- ");
			}else {
				Show.print(" -- No se aplico efecto -- ");
			}
		}else {
			Show.println(" -- Movimiento fallido -- ");
		}
		Show.println("\n");
	}
	
	/**
	 * Método que imprime un mensaje dependiendo de si el protagonista ganó o no la partida
	 * @param winner Boolean que indica si el protagonista ganó o no la partida
	 */
	public static void ganadorPartida(Boolean winner) {
		if(winner) {
			Show.println("\nVictoria! - Derrotaste a todos los monstruos\n");
		}else {
			Show.println("\nDerrota! - Ragh Nar Rogh es ahora imparable\n");
		}
	}

}
