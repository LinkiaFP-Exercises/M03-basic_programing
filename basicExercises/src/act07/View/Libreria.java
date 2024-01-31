package act07.View;

import static act07.Resources.Pregunta.*;
import static act07.DAO.AutorControler.*;
import static act07.DAO.LibroControler.*;
import act07.JDBC.Connector;

/**
 * La clase Libreria es la main de una pequeña aplicación que ofrece opciones
 * para administrar una base de datos de autores y libros. La aplicación se
 * ejecuta desde el método main en la clase "Libreria". El método "start()"
 * muestra un menú de opciones y procesa la elección del usuario utilizando la
 * sentencia "switch". El método "printMenu()" imprime el menú de opciones. El
 * método "exitMsgPrint()" cierra la instancia del escáner y desconecta la base
 * de datos antes de imprimir un mensaje de salida al usuario. El método
 * "turnToMenu()" imprime un mensaje para que el usuario pueda volver al menú
 * principal y espera a que el usuario presione ENTER antes de llamar al método
 * "start()" para volver al menú principal. La clase también importa métodos de
 * otras clases y paquetes para realizar operaciones en la base de datos.
 *
 * @author Fauno Guazina
 */
public class Libreria {

	public static void main(String[] args) {
		connector.connect();
		start();
	}

	/**
	 * La función muestra un menú de opciones para el usuario y procesa su elección
	 * utilizando la sentencia {@code switch}. Además, se muestra una opción
	 * predeterminada en caso de que el usuario ingrese una opción inválida.
	 * 
	 * @see #printMenu()
	 */
	static void start() {

		printMenu();

		switch (pideEntero("QUE DESEA HACER de 0 a 5 => ")) {
		case 0 -> exitMsgPrint();
		case 1 -> connector.createBasicDataForTesting();
		case 2 -> printAllAutores(true);
		case 3 -> printAllLibros(true);
		case 4 -> updateAutor();
		case 5 -> borrarLibro();
		default -> {
			System.out.println("\n    ¡¡¡ Opción Invalida !!!".toUpperCase());
			turnToMenu(true);
		}
		}
	}

	/**
	 * La función imprime el menú de opciones para el usuario, utilizando una cadena
	 * de texto multilínea en formato de cadena de texto.
	 */
	private static void printMenu() {
		String menu = """

				OPCIONES DE ARCHIVOS:
				1 -> Restart DataBase
				2 -> Listar Autores
				3 -> Listar Libros
				4 -> Modificar Autor
				5 -> Borrar Libro
				0 -> Finalizar Programa
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

		connector.disconnect();

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
	public static final void turnToMenu(boolean withConfirmation) {
		if (withConfirmation) {
			System.out.println("\n¡¡¡ ENTER para volver al MENU !!!");
			getScanner().nextLine();
		}
		start();
	}

	public static Connector getConnector() {
		return connector;
	}

	private static final Connector connector = new Connector();
}
