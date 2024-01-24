package act04.auxiliary;

import static act04.introduceDatos.Pregunta.*;
import static act04.manager.CreateFiles.nuevoArchivoTxt;
import static act04.manager.DeleteFiles.borrarArchivo;
import static act04.manager.DisplayFiles.muestraArchivo;
import static act04.manager.FolderArchivos.listarArchivos;
import static act04.manager.UpdateFiles.renombrarArchrivo;
import static act04.manager.ReplaceCharsFile.reemplazarCaracteresEnArchivo;

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
	public static void start() {

		printMenu();

		switch (pideEntero("QUE DESEA HACER de 0 a 6 => ")) {
		case 0 -> exitMsgPrint();
		case 1 -> nuevoArchivoTxt();
		case 2 -> listarArchivos(true);
		case 3 -> muestraArchivo();
		case 4 -> borrarArchivo();
		case 5 -> renombrarArchrivo();
		case 6 -> reemplazarCaracteresEnArchivo();
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

				OPCIONES DE ARCHIVOS:
				1 -> Crear
				2 -> Listar
				3 -> Enseñar
				4 -> Borrar
				5 -> Renombrar
				6 -> Reemplazar Caracteres
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

}
