package utils;

import java.util.Random;

/**
 * Clase con multiples métodos de generacion de numeros aleatorios y probabilidades
 * @author juanmi_rivas_8
 *
 */
public class RandomNumbers {

	/**
	 * Funcion que devuelve un Integer pseudoaleatorio entre inferior y superior
	 * ambos incluidos
	 * 
	 * @param inf Rango inferior
	 * @param sup Rango superior
	 * @return Entero pseudoaleatorio entre inferior y superior
	 */
	public static Integer randomNumber(Integer inf, Integer sup) {
		Integer aux = 0;
		if (inf > sup) {
			aux = inf;
			inf = sup;
			sup = aux;
		}
		return  Integer.valueOf((int)(Math.random() * (sup - inf + 1) + inf));
	}

	/**
	 * Funcion que devuelve un Double pseudoaleatorio entre inferior y superior
	 * ambos incluidos(2 decimales)
	 * 
	 * @param inf Rango inferior
	 * @param sup Rango superior
	 * @return Entero pseudoaleatorio entre inferior y superior
	 */
	public static Double randomDouble(Double inf, Double sup) {
		
		Double aux = 0.0;
		if (inf > sup) {
			aux = inf;
			inf = sup;
			sup = aux;
		}
		Double num = inf + new Random().nextDouble() * (sup - inf+0.01);
		num = Math.floor(num*100)/100;
		
		return num;
	}
	
	/**
	 * Metodo que devuelve true o false aleatoriamente dependiendo de una probabilidad pasada por parametro
	 * @param probabilidad Double que representa una probabilidad
	 * @return true si la probabilidad se encuentra entre 0.0 y el numero generado aleatoriamente(1.0)
	 */
	public static boolean randomChance(Double probabilidad) {
		boolean resultado;
		
		Double num = randomDouble(0.0, 1.0);
		
		resultado=(num<=probabilidad && num>=0.0)?true:false;
		
		return resultado;
	}
}
