package utils;


import java.util.Scanner;

import vista.Show;

/**
 * Clase que aglutina funciones para recoger información por teclado del usuario
 * @author juanmi_rivas_8
 *
 */
public class Escaner {
	/**
	 * Lee un entero por teclado entre un rango inferior y superior.
	 * 
	 * @param sc       Objeto Scanner para leer por teclado
	 * @param inferior Rango inferior
	 * @param superior Rango superior
	 * @return Numero entero leido por teclado
	 * @throws Exception Si se leyó un numero fuera de rango, o no se introdujo un
	 *                   entero.
	 */
	public static int readInt(Scanner sc, Integer inferior, Integer superior) throws Exception {
		Integer numero = 0, aux = superior;

		// ORDENAMOS LIMITES
		if (inferior > superior) {
			superior = inferior;
			inferior = aux;
		}

		try {
			numero = readInt(sc);
		} catch (NumberFormatException e) {
			throw e;
		}	

		if (numero < inferior) {
			throw new Exception("Numero menor que limite inferior");
		} else if (numero > superior) {
			throw new Exception("Numero mayor que limite superior");
		}

		return numero;
	}

	/**
	 * Lee un entero por teclado
	 * 
	 * @param sc Objeto tipo Scanner para leer por teclado
	 * @return Devuelve el entero leido por teclado
	 * @throws NumberFormatException Se lanza esta excepcion si no se introduce
	 *                                un entero.
	 */
	public static Integer readInt(Scanner sc) throws NumberFormatException {
		Integer numero = 0;
		String cad;
		try {
			cad=sc.nextLine();
			numero = Integer.valueOf(cad);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Error - No se introdujo un entero");
		}
		return numero;
	}
	
	
	/**
	 *  Lee un entero por teclado hasta que el usuario introduce uno correctamente
	 * @param sc Objeto tipo Scanner para leer por teclado
	 * @param message Cadena para orientar al usuario
	 * @return Devuelve el entero leido por teclado
	 */
	public static Integer readIntBucle(Scanner sc,String message) {
		Boolean invalido=true;
		int num=0;
		do {
			invalido=true;
			try {
				vista.Show.println(message);
				num=readInt(sc);
				invalido=false;
			} catch (Exception e) {
				vista.Show.println(e.getMessage());
			}

		}while(invalido);
		
		return num;
	}
	
	/**
	 * Lee un entero entre un rango por teclado hasta que el usuario introduce uno correctamente
	 * @param sc Objeto tipo Scanner para leer por teclado
	 * @param message Cadena para orientar al usuario
	 * @param inf Rango inferior 
	 * @param sup Rango superior
	 * @return Entero leido por teclado
	 */
	public static Integer readIntBucle(Scanner sc,String message,Integer inf,Integer sup) {
		Boolean invalido=true;
		int num=0;
		do {
			invalido=true;
			try {
				vista.Show.println(message);
				num=readInt(sc,inf,sup);
				invalido=false;
			} catch (Exception e) {
				vista.Show.println(e.getMessage());
			}

		}while(invalido);
		
		return num;
	}
	
	/**
	 * Lee un double por teclado
	 * @param sc Objeto tipo Scanner para leer por teclado
	 * @return double leido por teclado
	 */
	public static Double readDouble(Scanner sc) {
		Double numero = 0.0;
		String cad;
		try {
			cad=sc.nextLine();
			numero=Double.valueOf(cad);
		} catch (NumberFormatException e) {
			sc.next();
			throw new NumberFormatException("Error - No se introdujo un numero");
		}
		return numero;
	}
	
	
	/**
	 * Lee un double por teclado entre un rango inferior y superior.
	 * @param sc Objeto tipo Scanner para leer por teclado
	 * @param inferior Rango inferior
	 * @param superior Rango superior
	 * @return double leido por teclado
	 * @throws Exception
	 */
	public static Double readDouble(Scanner sc, Double inferior, Double superior) throws Exception {
		Double numero = 0.0, aux = superior;

		// ORDENAMOS LIMITES
		if (inferior > superior) {
			superior = inferior;
			inferior = aux;
		}

		try {
			numero = readDouble(sc);
		} catch (NumberFormatException e) {
			throw e;
		}

		if (numero < inferior) {
			throw new Exception("Numero menor que limite inferior");
		} else if (numero > superior) {
			throw new Exception("Numero mayor que limite superior");
		}

		return numero;
	}
	
	/**
	 *  Lee un entero por double hasta que el usuario introduce uno correctamente
	 * @param sc Objeto tipo Scanner para leer por teclado
	 * @param message Cadena para orientar al usuario
	 * @return double leido por teclado
	 */
	public static Double readDoubleBucle(Scanner sc,String message) {
		Boolean invalido=true;
		Double num=0.0;
		do {
			invalido=true;
			try {
				vista.Show.println(message);
				num=readDouble(sc);
				invalido=false;
			} catch (Exception e) {
				vista.Show.println(e.getMessage());
			}

		}while(invalido);
		
		return num;
	}
	
	/**
	 * Lee un entero entre un rango por teclado hasta que el usuario introduce uno correctamente
	 * @param sc Objeto tipo Scanner para leer por teclado
	 * @param message Cadena para orientar al usuario
	 * @param inf Rango inferior
	 * @param sup Rango superior
	 * @return double leido por teclado
	 */
	public static Double readDoubleBucle(Scanner sc,String message,Double inf,Double sup) {
		Boolean invalido=true;
		Double num=0.0;
		do {
			invalido=true;
			try {
				vista.Show.println(message);
				num=readDouble(sc,inf,sup);
				invalido=false;
			} catch (Exception e) {
				vista.Show.println(e.getMessage());
			}

		}while(invalido);
		
		return num;
	}
	
	public static void waitForKey() {
		Scanner sc = new Scanner(System.in);
		String wait=null;
		Show.println("--Pulse Enter para continuar--");
		wait=sc.nextLine();
		
	}
	
}
