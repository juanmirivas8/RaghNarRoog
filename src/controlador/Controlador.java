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

		for (int i = 0; i < p.getMonstruos().length; i++) {
			Combate(p.getProtagonista(), p.getMonstruos()[i]);

			if (p.endCondition()) {
				i = p.getMonstruos().length;
			}
		}
	}

	private static String Combate(Ente protagonista, Ente monstruo) {

		do {
			protagonista.aplicarEfectos(monstruo);

			if (!monstruo.isAlive() || !protagonista.isAlive()) {

				break;
			}

			monstruo.aplicarEfectos(protagonista);

			if (!monstruo.isAlive() || !protagonista.isAlive()) {

				break;
			}
			
			protagonista.lanzarMovimiento(monstruo);
			
			if (!monstruo.isAlive() || !protagonista.isAlive()) {

				break;
			}
			
			monstruo.lanzarMovimiento(protagonista);

			if (!monstruo.isAlive() || !protagonista.isAlive()) {

				break;
			}
		} while (protagonista.isAlive() && monstruo.isAlive());
	}

}
