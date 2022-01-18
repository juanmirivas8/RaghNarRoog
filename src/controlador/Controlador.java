package controlador;

import java.util.Scanner;
import utils.Escaner;
import vista.*;
import modelo.*;

/**
 * Controlador del proyecto
 * @author juanmi_rivas_8
 *
 */
public class Controlador {

	/**
	 * Metodo que implementa el menu principal y el inicio del programa.
	 */
	public static void inicioPrograma() {

		Scanner sc = new Scanner(System.in);
		Integer opcion = 0;

		do {
			GUI.printMainMenu();
			opcion = Escaner.readIntBucle(sc, "Introduzca opcion: ");

			switch (opcion) {
			case 0 -> {
				Show.println("Salida correcta del programa");
				opcion = 0;
			}
			case 1 -> iniciarPartida(new Partida());
			default -> Show.println("Error - Opcion incorrecta");
			}

		} while (opcion != 0);

	}

	/**
	 * Metodo que implementa una partida. Consiste en el protagonista combatiendo con cada monstruo mientras el primero siga vivo y queden monstruos sin derrotar.
	 * @param p
	 */
	private static void iniciarPartida(Partida p) {

		Boolean combate=null;
		for (int i = 0; i < p.getMonstruos().length; i++) {
			combate=Combate(p.getProtagonista(), p.getMonstruos()[i]);
			
			if(combate) {
				Show.println(p.getProtagonista().getNombre()+" gano el combate");
				p.getMonstruos()[i]=null;
			}else {
				Show.println(p.getMonstruos()[i].getNombre()+" gano el combate");
			}
			
			if (p.endCondition()) {
				i = p.getMonstruos().length;
				GUI.ganadorPartida(combate);
			}
		}
	}

	/**
	 * Metodo que enfrenta al protagonista contra un monstruo en un combate a muerte.
	 * @param protagonista Ente protagonista
	 * @param monstruo Ente adversario del protagonista
	 * @return
	 */
	public static Boolean Combate(Ente protagonista, Ente monstruo) {
		String []buffer=null;
		
		Show.println("\n--Empieza el combate entre "+protagonista.getNombre()+" y "+monstruo.getNombre()+" --\n");
		
		do {
			
			monstruo.aplicarEfectos(protagonista);
			
			if (!monstruo.isAlive()) {
				return true;
				
			}else if(!protagonista.isAlive()) {
				return false;
			}
			
			protagonista.aplicarEfectos(monstruo);
			if (!monstruo.isAlive()) {
				return true;
				
			}else if(!protagonista.isAlive()) {
				return false;
			}
			
			Escaner.waitForKey();
			GUI.infoEnte(protagonista);
			Escaner.waitForKey();
			GUI.infoEnte(monstruo);
			
			Escaner.waitForKey();
			
			buffer=protagonista.lanzarMovimiento(monstruo);
			GUI.muestraMovimiento(buffer);
			
			if (!monstruo.isAlive()) {
				return true;
				
			}else if(!protagonista.isAlive()) {
				return false;
			}
			
			Escaner.waitForKey();
			buffer=monstruo.lanzarMovimiento(protagonista);
			GUI.muestraMovimiento(buffer);
			
			if (!monstruo.isAlive()) {
				return true;
				
			}else if(!protagonista.isAlive()) {
				return false;
			}
		} while (protagonista.isAlive() && monstruo.isAlive());
		
		return true;
	}

}
