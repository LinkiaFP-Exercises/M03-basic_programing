package act03.auxiliary;

import static act03.introduceDatos.Pregunta.*;
import static act03.operaciones.aritmeticas.Operaciones.*;
import static act03.operaciones.geometricas.Operaciones.*;
import static act03.operaciones.OperacionesLinkia.convertirLinkiaCoins;
import static act03.operaciones.Valores.*;

/**
 * Clase auxiliar del paquete {@code main}
 * 
 * @author Fauno Guazina
 */
public final class auxiliaryMain {

	/**
	 * La función muestra un menú de opciones para el usuario y procesa su elección
	 * utilizando la sentencia {@code switch}. Además, se muestra una opción
	 * predeterminada en caso de que el usuario ingrese una opción inválida.
	 * 
	 * @see #printMenu()
	 */
	public static void start() {

		printMenu();

		switch (pideEntero("QUE DESEA HACER de 0 a 8 => ")) {
		case 0 -> exitMsgPrint();
		case 1 -> convertirLinkiaCoins();
		case 2 -> muestraPI();
		case 3 -> muestraValorAbsoluto();
		case 4 -> muestraValorAleatorio();
		case 5 -> muestraLogaritmo(pideDouble("Elije un numero para saber su logaritimo => "));
		case 6 -> calculaPotencia(pideDouble("Elije un numero base => ", true),
				pideDouble("Elije un numero potencia => ", true));
		case 7 -> muestraSeno();
		case 8 -> muestraCoseno();

		default -> {
			System.out.println("¡¡¡Opción Invalida, tecle enter!!!".toUpperCase());
			Scanner().nextLine();
			start();
		}
		}
	}

	/**
	 * La función imprime el menú de opciones para el usuario, utilizando una cadena
	 * de texto multilínea en formato de cadena de texto.
	 */
	private static void printMenu() {
		String menu = """

				MENÚ DE OPCIONES:
				1 -> Convertir LinkiaCoins
				2 -> Enseñame PI
				3 -> Valor Absoluto
				4 -> Valor Aleatorio
				5 -> Logaritmo
				6 -> Potencia
				7 -> Seno
				8 -> Coseno
				0 -> Finalizar Programa
				""";

		System.out.println(menu);
	}

	/**
	 * La función imprime un mensaje de salida al usuario cuando finaliza el
	 * programa, utilizando una cadena de texto.
	 */
	private static void exitMsgPrint() {

		String exitMsg = "\n¡¡¡ GRACIAS POR VENIR !!!\n";

		System.out.println(exitMsg);
	}

	/**
	 * La función imprime un mensaje para que el usuario pueda volver al menú
	 * principal del programa, y espera a que el usuario presione la tecla ENTER
	 * antes de llamar a la función {@code start()} para volver al menú principal.
	 * 
	 * @see #start()
	 */
	public static final void turnToMenu() {
		System.out.println("\n¡¡¡Tecle ENTER para volver al MENU!!!");
		Scanner().nextLine();
		start();
	}
}
