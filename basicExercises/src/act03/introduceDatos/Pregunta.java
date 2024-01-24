package act03.introduceDatos;

import java.util.Scanner;

/**
 * @author Fauno Guazina
 */
public final class Pregunta {

	/**
	 * Solicita al usuario que ingrese un valor de tipo entero positivo y lo valida
	 * mediante una expresión regular.
	 * 
	 * @param pregunta pregunta una pregunta que se muestra al usuario para
	 *                 solicitar la entrada.
	 * @return el valor de entrada validado del usuario en formato int.
	 */
	public static int pideEntero(String pregunta) {

		return Integer.valueOf(validation(pregunta, REGEX_ENTERO_SOLO_POSITIVO));
	}

	/**
	 * Solicita al usuario que ingrese un valor de tipo double y lo valida mediante
	 * una expresión regular. Son posibles valores positivos y negativos.
	 * 
	 * @param pregunta una pregunta que se muestra al usuario para solicitar la
	 *                 entrada.
	 * @return el valor de entrada validado del usuario formato double.
	 */
	public static double pideDouble(String pregunta) {

		return Double.valueOf(validation(pregunta, REGEX_DOUBLE));
	}

	/**
	 * Solicita al usuario que ingrese un valor de tipo double y lo valida mediante
	 * una expresión regular. El segundo parámetro "negativeAllowed" indica si los
	 * valores negativos son permitidos o no.
	 * 
	 * @param pregunta        una pregunta que se muestra al usuario para solicitar
	 *                        la entrada.
	 * @param negativeAllowed indica si los valores negativos son permitidos o no.
	 * @return el valor de entrada validado del usuario formato double.
	 */
	public static double pideDouble(String pregunta, boolean negativeAllowed) {

		String regex = negativeAllowed ? REGEX_DOUBLE : REGEX_DOUBLE_SOLO_POSITIVO;

		return Double.valueOf(validation(pregunta, regex));
	}

	/**
	 * Valida la entrada del usuario mediante una expresión regular y solicita al
	 * usuario que ingrese un valor hasta que se proporcione una entrada que cumpla
	 * con el patrón especificado.
	 * 
	 * @param statement una declaración que se muestra al usuario para solicitar la
	 *                  entrada.
	 * @param regex     una expresión regular que se utiliza para validar la entrada
	 *                  del usuario.
	 * @return el valor de entrada validado del usuario en formato String.
	 */
	private static String validation(String statement, String regex) {

		int attemptSelection = 0;
		String userEntryValue;

		do {

			if (attemptSelection > 0)
				System.out.println("¡¡¡VALOR INVALIDO!!!");

			System.out.print(statement);

			userEntryValue = Scanner().nextLine().replace(",", ".");

			attemptSelection++;

		} while (!userEntryValue.matches(regex));

		return userEntryValue;
	}

	/**
	 * Crea una nueva instancia de la clase Scanner para leer la entrada del usuario
	 * desde el teclado.
	 * 
	 * @return una nueva instancia de la clase Scanner que lee la entrada del
	 *         usuario desde el teclado
	 */
	public final static Scanner Scanner() {
		return new Scanner(System.in);
	}

	/**
	 * Regex que define aceptación de valores enteros y solo positivos
	 */
	private static final String REGEX_ENTERO_SOLO_POSITIVO = "^\\d+$";

	/**
	 * Regex que define aceptación de valores doubles y positivos o negativos
	 */
	private static final String REGEX_DOUBLE = "^-?\\d+(\\.\\d+)?$";

	/**
	 * Regex que define aceptación de valores doubles y solo positivos
	 */
	private static final String REGEX_DOUBLE_SOLO_POSITIVO = "^\\d+(\\.\\d+)?$";
}
