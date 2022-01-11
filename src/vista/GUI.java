package vista;

import modelo.Ente;
public class GUI {

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
	
	public static void infoEnte(Ente e) {
		Show.println("Nombre: "+e.getNombre());
		Show.println("Ataque base: "+e.getAtaque_base()+" Ataque actual: "+e.getAtaque());
		Show.println("Defensa base: "+e.getDefensa_base()+ " Defensa actual: "+e.getDefensa());
		Show.println("Vida base: "+e.getVida_base()+" Vida actual: "+e.getVida());
		Show.println("------------Lista de Resistencias Base---------");
		for(int i = 0; i < e.getResistencias_base().length; i++ ) {
			Show.println(e.getResistencias_base()[i]);
		}
		Show.println("--------Lista de Resistencias Actuales---------");
		for(int i = 0; i < e.getResistencias().length; i++ ) {
			Show.println(e.getResistencias()[i]);
		}
		Show.println("------------Lista de Movimientos Base---------");
		for(int i = 0; i < e.getMovimientos_base().length; i++ ) {
			Show.println(e.getMovimientos_base()[i]);
		}
		Show.println("---------Lista de Movimientos Actuales--------");
		for(int i = 0; i < e.getMovimientos().length; i++ ) {
			Show.println(e.getMovimientos()[i]);
		}
		Show.println("------------Lista de Efectos Activos----------");
		for(int i = 0; i < e.getEfectos().length; i++ ) {
			if(e.getEfectos()[i]!=null) {
				Show.println(e.getEfectos()[i]);
			}
		}
	}

}
