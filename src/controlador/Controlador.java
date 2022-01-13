package controlador;

import java.util.Scanner;
import utils.Escaner;
import vista.*;
import modelo.*;

public class Controlador {

	public static void inicioPrograma() {

		Partida p = new Partida();
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
			case 1 -> iniciarPartida(p);
			default -> Show.println("Error - Opcion incorrecta");
			}

		} while (opcion != 0);

	}

	private static void iniciarPartida(Partida p) {

		Boolean combate=null;
		for (int i = 0; i < p.getMonstruos().length; i++) {
			combate=Combate(p.getProtagonista(), p.getMonstruos()[i]);
			
			if(combate) {
				Show.println(p.getProtagonista().getNombre()+" gano el combate");
			}else {
				Show.println(p.getMonstruos()[i].getNombre()+" gano el combate");
			}
			
			if (p.endCondition()) {
				i = p.getMonstruos().length;
			}
		}
	}

	private static Boolean Combate(Ente protagonista, Ente monstruo) {
		String []buffer=null;
		
		Show.println("--Empezar Combate--");
		
		do {
			protagonista.aplicarEfectos(monstruo);
			if (!monstruo.isAlive()) {
				return true;
				
			}else if(!protagonista.isAlive()) {
				return false;
			}
			
			monstruo.aplicarEfectos(protagonista);
			
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
