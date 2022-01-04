package vista;

/**
 * Clase propia para la impresión por pantalla y organización del código según mvc
 * @author juanmi_rivas_8
 *
 */
public class Show {


	
	/**
	 * Función que sustituye a System.out.print
	 * @param cad Objeto o cadena que vamos a imprimir
	 */
	public static void print(Object cad) {
		System.out.print(cad);
	}
	
	/**
	 * Función que sustituye a Sustem.out.println
	 * @param cad Objeto o cadena que vamos a imprimir
	 */
	public static void println(Object cad) {
		System.out.println(cad);
	}
}
