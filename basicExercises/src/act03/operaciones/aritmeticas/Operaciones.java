package act03.operaciones.aritmeticas;

import static act03.auxiliary.auxiliaryMain.turnToMenu;

public class Operaciones {

	/**
	 * Esta función recibe un número y calcula su logaritmo natural utilizando la
	 * función Math.log. Luego, muestra el resultado en la consola y llama a la
	 * función turnToMenu para volver al menú principal.
	 * 
	 * @param num El número del cual se desea calcular el logaritmo natural.
	 */
	public static void muestraLogaritmo(double num) {
		String msg = "El logaritmo de " + num + " en 'base e' es " + Math.log(num);
		System.out.println(msg);
		turnToMenu();
	}

	/**
	 * Calcula la potencia de un número elevado a otra potencia y muestra el
	 * resultado por consola.
	 * 
	 * @param num el número a elevar.
	 * @param pow la potencia a la que se elevará el número.
	 */
	public static void calculaPotencia(double num, double pow) {
		String msg = "El " + num + " elevado a " + pow + " es " + Math.pow(num, pow);
		System.out.println(msg);
		turnToMenu();
	}
}
