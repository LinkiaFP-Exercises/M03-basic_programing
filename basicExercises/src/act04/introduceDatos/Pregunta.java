package act04.introduceDatos;

import java.util.Scanner;

/**
 * @author Fauno Guazina
 */
public final class Pregunta {

	/**
	 * Valida la entrada del usuario mediante expresión regular
	 * {@code REGEX_FILE_NAME} y solicita al usuario que ingrese un valor hasta que
	 * se proporcione una entrada que cumpla con el patrón especificado.
	 * 
	 * @see #REGEX_FILE_NAME
	 * @param pregunta que se muestra al usuario para solicitar la entrada.
	 * @return el valor de entrada validado del usuario en formato {@code String}.
	 */
	public static String pideFileName(String pregunta) {
		return validation(pregunta, REGEX_FILE_NAME, ERROR_FILE_NAME);
	}

	/**
	 * Solicita al usuario que ingrese un valor de tipo entero positivo y lo valida
	 * mediante una expresión regular.
	 * 
	 * @param pregunta que se muestra al usuario para solicitar la entrada.
	 * @return el valor de entrada validado del usuario en formato {@code int}.
	 */
	public static int pideEntero(String pregunta) {

		return Integer.valueOf(validation(pregunta, REGEX_ENTERO_SOLO_POSITIVO, null));
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
	private static String validation(String statement, String regex, String error) {

		int attemptSelection = 0;
		String userEntryValue;

		do {

			if (attemptSelection > 0) {
				System.out.println("¡¡¡VALOR INVALIDO!!!");

				if (error != null)
					System.out.println(error);
			}

			System.out.print(statement);

			userEntryValue = getScanner().nextLine();

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
	 * Regex que define aceptación de valores enteros y solo positivos para la
	 * función {@code pideEntero}
	 * 
	 * @see #pideEntero
	 */
	private static final String REGEX_ENTERO_SOLO_POSITIVO = "^\\d+$";

	/**
	 * Regex que define aceptación de los caracteres a-z, A-Z, 0-9, _ y - para la
	 * funcion {@code pideFileName}
	 * 
	 * @see #pideFileName
	 */
	private static final String REGEX_FILE_NAME = "^\\w+(-\\w+)*$";

	/**
	 * String con mensaje de error para user cuando no cumple regex
	 * {@code REGEX_FILE_NAME}
	 * 
	 * @see #REGEX_FILE_NAME
	 */
	private static final String ERROR_FILE_NAME = "Solo son permitidos caracteres a-z, A-Z, 0-9, _ y -";
}
