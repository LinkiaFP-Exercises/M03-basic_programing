package act04.manager;

import static act04.introduceDatos.Pregunta.pideEntero;
import static act04.auxiliary.AuxiliaryMain.turnToMenu;
import static act04.manager.FolderArchivos.getArchivo;
import static act04.manager.FolderArchivos.listarArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DisplayFiles {

	/**
	 * Esta función tiene como objetivo permitir al usuario ver el contenido de un
	 * archivo de texto existente.
	 * 
	 * Se llama a la función {@code listarArchivos()} para obtener una lista de
	 * todos los archivos de texto en la carpeta actual. Estos nombres de archivo se
	 * almacenan en un array llamado {@code archivos}.
	 * 
	 * Se llama a la función {@code requestFilePosition()} para solicitar al usuario
	 * que seleccione un archivo de la lista de archivos de texto. La posición
	 * seleccionada se almacena en la variable {@code filePosition}.
	 * 
	 * Se llama a la función {@code findFileAndPrintContent()} para encontrar el
	 * archivo seleccionado y mostrar su contenido en la pantalla.
	 * 
	 * Finalmente, se llama a la función {@code turnToMenu()} para volver al menú
	 * principal de la aplicación.
	 */
	public static void muestraArchivo() {

		String[] archivos = listarArchivos(false);

		int filePositision = requestFilePosition(archivos);

		findFileAndPrintContent(archivos[filePositision]);

		turnToMenu();
	}

	/**
	 * Esta función se utiliza para solicitar al usuario que seleccione un archivo
	 * de una lista de archivos de texto. Aquí está cómo funciona la función:
	 * 
	 * Se recibe una lista de nombres de archivos de texto llamada
	 * {@code listFiles}.
	 * 
	 * Se inicializa la variable {@code filePosition} a 0 y
	 * {@code positionFileCorrect} a {@code false}.
	 * 
	 * Se ejecuta un bucle {@code do-while} que solicita al usuario que ingrese la
	 * posición del archivo que desea seleccionar en el rango de 1 a
	 * {@code listFiles.length}.
	 * 
	 * La posición ingresada por el usuario se ajusta para que coincida con el
	 * índice del array, y luego se verifica si es una posición válida en la lista
	 * de archivos de texto.
	 * 
	 * Si la posición es válida, la variable {@code positionFileCorrect} se
	 * establece en true y el bucle se detiene. De lo contrario, se imprime un
	 * mensaje de error y se continúa ejecutando el bucle.
	 * 
	 * Una vez que se ha seleccionado una posición de archivo válida, se devuelve el
	 * valor de {@code filePosition}.
	 * 
	 * @param listFiles array de nombres de archivos
	 * @return la posición de la selección del archivo en dicho array
	 */
	static int requestFilePosition(String[] listFiles) {

		int filePositision;

		boolean positionFileCorrect = false;

		do {

			filePositision = pideEntero("Cual archivo de 1 a " + listFiles.length + " => ") - 1; // ajuste indice array

			positionFileCorrect = filePositision >= 0 && filePositision <= listFiles.length;

			if (!positionFileCorrect)
				System.out.println("   ¡¡¡ OPCIÓN INVALIDA !!!");

		} while (!positionFileCorrect);

		return filePositision;
	}

	/**
	 * Esta función recibe como argumento el nombre de un archivo, y se encarga de
	 * abrirlo, leer su contenido y mostrarlo por pantalla. Primero, se crea un
	 * objeto {@code File} con la ruta y nombre del archivo seleccionado. A
	 * continuación, se crea un objeto {@code FileReader} y un objeto
	 * {@code BufferedReader} para poder leer el contenido del archivo.
	 * 
	 * Dentro de un bloque {@code try-catch}, se intenta abrir el archivo y leer su
	 * contenido, y si ocurre algún error se maneja la excepción y se muestra un
	 * mensaje de error. Si todo va bien, se obtiene el nombre del archivo, se
	 * muestra una cabecera indicando el nombre del archivo y se muestran las líneas
	 * del archivo utilizando la función {@code forEach} de la clase {@code Stream}.
	 * 
	 * Por último, en un bloque {@code finally}, se cierran los objetos
	 * {@code BufferedReader} y {@code FileReader}. Si ocurre algún error al
	 * cerrarlos, se muestra un mensaje indicando que no se han podido cerrar.
	 * 
	 * @param nameFileSelection nombre del archivo seleccionado para ser impreso el
	 *                          contenido
	 */
	private static void findFileAndPrintContent(String nameFileSelection) {

		File fileSelected = new File(getArchivo().getFolderPath() + nameFileSelection);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(fileSelected);
			bufferedReader = new BufferedReader(fileReader);

			String fileName = fileSelected.getName();

			System.out.println("\n>>> CONTENIDO DEL ARCHIVO >>> " + fileName + " <\n");
			bufferedReader.lines().forEach(System.out::println);
			System.out.println("\n>>>>>>>>> FIN DEL ARCHIVO >>> " + fileName + " <");

		} catch (Exception e) {
			System.out.println("Por el motivo:\n" + e.getMessage() + "\nno se ha podido leer en el fichero");

		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
				if (fileReader != null)
					fileReader.close();

			} catch (Exception e) {
				System.out.println("¡¡¡ ALGO NO SE HA PODIDO CERRAR !!! => " + e.getMessage());
			}
		}
	}
}
