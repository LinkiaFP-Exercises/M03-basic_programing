package act05;

import java.util.Scanner;

public final class Utilidades {

	/**
	 * Solicita al usuario que ingrese un valor de tipo entero positivo y lo valida
	 * mediante una expresión regular.
	 * 
	 * @param pregunta pregunta una pregunta que se muestra al usuario para
	 *                 solicitar la entrada.
	 * @return el valor de entrada validado del usuario en formato int.
	 */
	public static int pedirEntero(String pregunta) {

		return Integer.valueOf(validation(pregunta, REGEX_ENTERO_SOLO_POSITIVO));
	}

	/**
	 * Solicita al usuario que ingrese un valor de tipo double y lo valida mediante
	 * una expresión regular. Solo son posibles valores positivos.
	 * 
	 * @param pregunta una pregunta que se muestra al usuario para solicitar la
	 *                 entrada.
	 * @return el valor de entrada validado del usuario formato double.
	 */
	public static double pedirDecimal(String pregunta) {

		return Double.valueOf(validation(pregunta, REGEX_DOUBLE_SOLO_POSITIVO));
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
	public static String validation(String statement, String regex) {

		int attemptSelection = 0;
		String userEntryValue;

		do {

			if (attemptSelection > 0)
				System.out.println("¡¡¡VALOR INVALIDO!!!");

			System.out.print(statement);

			userEntryValue = getScanner().nextLine().replace(",", ".");

			attemptSelection++;

		} while (!userEntryValue.matches(regex));

		return userEntryValue;
	}

	/**
	 * Retorna la instancia {@code Scanner} estática y final de la clase
	 * {@code Pregunta} para leer las entradas del usuario desde el teclado. Esta
	 * instancia solo es cerrada {@code Scanner.close()} en la función de salida del
	 * programa
	 * 
	 * @return instancia de la clase {@code Scanner(System.in)}
	 */
	public final static Scanner getScanner() {
		return SCANNER;
	}

	/**
	 * Instancia de la clase Scanner para leer la entrada del usuario desde el
	 * teclado
	 */
	public static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Regex que define aceptación de valores enteros y solo positivos
	 */
	private static final String REGEX_ENTERO_SOLO_POSITIVO = "^\\d+$";

	/**
	 * Regex que define aceptación de valores doubles y solo positivos
	 */
	private static final String REGEX_DOUBLE_SOLO_POSITIVO = "^\\d+(\\.\\d+)?$";
}
