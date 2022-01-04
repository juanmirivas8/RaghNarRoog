package controlador;

import java.util.Scanner;
import utils.Escaner;
import vista.*;
import modelo.*;
public class Controlador {

	public static void inicioPrograma() {

		Partida p=new Partida();
		Scanner sc = new Scanner(System.in);
		Integer opcion = 0;
		
		do {
			GUI.printMainMenu();
			opcion = Escaner.readIntBucle(sc, "Introduzca opcion: ");

			switch (opcion) {
			case 1 ->
			case 2 -> Show.println("Modo administrador desactivado");
			default-> Show.println("Error - Opcion incorrecta");
			}
			
		} while (opcion != 0);

	}
	
	
	
}
