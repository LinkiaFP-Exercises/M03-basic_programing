package act05.ejercicio01.cuentaCorriente.view;

import static act05.ejercicio01.cuentaCorriente.controler.Controler.*;
import static act05.Utilidades.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import act05.ejercicio01.cuentaCorriente.model.Cuenta;

/**
 * Clase auxiliar del paquete {@code main}
 * 
 * @author Fauno Guazina
 */
public final class AuxiliaryMain {

	/**
	 * La función muestra un menú de opciones para el usuario y procesa su elección
	 * utilizando la sentencia {@code switch}. Además, se muestra una opción
	 * predeterminada en caso de que el usuario ingrese una opción inválida.
	 * 
	 * @see #printMenu()
	 */
	public static final void start() {

		printStatusBillsWithSeparators();
		printMenu();

		switch (pedirEntero("QUE DESEA HACER de 0 a 4 => ")) {
		case 0 -> exitMsgPrint();
		case 1 -> consultarSaldo();
		case 2 -> ingresarDinero();
		case 3 -> sacarDinero();
		case 4 -> transferirDinero();
		default -> {
			System.out.println("\n    ¡¡¡ Opción Invalida !!!".toUpperCase());
			turnToMenu();
		}
		}
	}

	/**
	 * La función imprime el menú de opciones para el usuario, utilizando una cadena
	 * de texto multilínea en formato de cadena de texto.
	 */
	private static void printMenu() {
		String menu = """
				               **********************************
				               ** [1] - Consultar saldo        **
				               ** [2] - Ingresar dinero        **
				               ** [3] - Sacar dinero           **
				               ** [4] - Realizar transferencia **
				               ** [0] - Salir                  **
				               **********************************
				""";

		System.out.println(menu);
	}

	/**
	 * La función cierra la intancia {@code Scanner} invocada por la función
	 * {@code getScanner} de la clase {@code Pregunta} del paquete
	 * {@code introduceDatos}, posteriormente imprime un mensaje de salida al
	 * usuario cuando finaliza el programa, utilizando una cadena de texto.
	 */
	private static void exitMsgPrint() {

		getScanner().close();

		String exitMsg = "\n    ¡¡¡ GRACIAS POR VENIR !!!\n";

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
		System.out.println("\n¡¡¡ ENTER para volver al MENU !!!");
		getScanner().nextLine();
		start();
	}

	/**
	 * Función que atiende al requisito 3 de la actividad: "Crear un menú principal
	 * con las siguientes opciones teniendo presente que con cada operación se debe
	 * mostrar el estado actual de todas las cuentas". Utiliza la función
	 * {@code separadorConTitulo} para generar una cabecera que facilita la
	 * visualización. Después haz un stream del array {@code BANCO} para reducirlo a
	 * líneas String y los junta con un salto de línea. Al final lo imprime por
	 * pantalla.
	 */
	static void printStatusBillsWithSeparators() {
		final String headSeparator = separadorConTitulo("ESTATUS CUENTAS");
		final String cuentas = Arrays.stream(BANCO).map(c -> c.toString()).collect(Collectors.joining("\n"));
		println("", headSeparator, cuentas, separador, "");
	}

	/**
	 * Función hace stream del array VARARGS y para cada uno lo imprime en una línea
	 * 
	 * @param strings VARARGS para facilitar las multiples impresiones
	 */
	public static void println(String... strings) {
		Arrays.stream(strings).forEach(System.out::println);
	}

	/**
	 * @return array {@code BANCO} que armazenas las cuentas, ya que por
	 *         encapsulamiento el array es private
	 */
	public static Cuenta[] getBanco() {
		return BANCO;
	}

	/**
	 * La función separadorConTitulo recibe como parámetro un String titulo que se
	 * utiliza para generar un nuevo separador que incluye el título centrado en la
	 * parte superior del separador.
	 * 
	 * Para ello, la función calcula la mitad del separador (que es una constante
	 * definida previamente), le resta la longitud del título y divide el resultado
	 * entre dos para obtener la cantidad de asteriscos que deben preceder y seguir
	 * al título. Luego, en un ciclo for se recorre el separador original, y cuando
	 * se llega al punto medio de la resta del separador con la longitud del título,
	 * se inserta el título en el nuevo separador generado y se continua con el
	 * ciclo, agregando el resto de asteriscos faltantes. Finalmente, la función
	 * retorna el nuevo separador con el título centrado.
	 * 
	 * @param titulo String se quiera hacer de cabecera de menu
	 * @return string con el texto del argumento {@code titulo} dentro del
	 */
	public static String separadorConTitulo(String titulo) {
		int mitadRestaSeparadorTitulo = (separador.length() - titulo.length()) / 2;
		String separadorConTitulo = "";

		for (int i = 0; i <= separador.length(); i++) {
			if (i == mitadRestaSeparadorTitulo) {
				separadorConTitulo += " " + titulo + " ";
				i = separadorConTitulo.length();
			} else
				separadorConTitulo += "*";

		}

		return separadorConTitulo;
	}

	/**
	 * Esta función es responsable de solicitar al usuario que ingrese un número de
	 * cuenta bancaria válido. Primero, crea una variable statement que contiene el
	 * mensaje de solicitud que se mostrará al usuario.
	 * 
	 * A continuación, se utiliza la función Arrays.stream() junto con el método
	 * collect() y Collectors.joining() para crear una expresión regular que
	 * coincida con todos los números de cuenta existentes en el arreglo banco. El
	 * resultado se guarda en la variable regexCuentas.
	 * 
	 * Después, la función validation() es llamada, que solicita al usuario que
	 * ingrese un valor y luego verifica si el valor coincide con la expresión
	 * regular regexCuentas. Si el usuario ingresa un valor que no coincide con la
	 * expresión regular, se le solicita que lo vuelva a intentar.
	 * 
	 * Finalmente, la función devuelve el número de cuenta bancaria ingresado por el
	 * usuario como un valor de tipo long.
	 * 
	 * @return número de cuenta bancaria ingresado por el usuario como un valor de
	 *         tipo long.
	 */
	public static long pedirNumeroCuenta() {
		String statement = "INGRESE NUMERO DE CUENTA => ";
		String regexCuentas = Arrays.stream(BANCO).map(c -> Long.toString(c.getNumeroCuenta()))
				.collect(Collectors.joining("|"));

		return Long.valueOf(validation(statement, regexCuentas));
	}

	/**
	 * Standarización para visualización
	 */
	public static final String separador = "******************************************************************";

	/**
	 * Array que guarda la "base de datos" de las cuentas
	 */
	private static final Cuenta[] BANCO = { new Cuenta(1234, 1379.50, "Fauno Guazina"),
			new Cuenta(6543, 12268.69, "Francesc Pérez"), new Cuenta(4321, 24832.69, "Adrián Gutierrez") };

}
