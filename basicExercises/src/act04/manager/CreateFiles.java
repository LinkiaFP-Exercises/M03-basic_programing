package act04.manager;

import static act04.introduceDatos.Pregunta.pideFileName;
import static act04.introduceDatos.Pregunta.getScanner;
import static act04.auxiliary.AuxiliaryMain.turnToMenu;
import static act04.manager.FolderArchivos.getArchivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CreateFiles {

	/**
	 * Esta función crea un nuevo archivo de texto y permite escribirle varias
	 * líneas de texto. Se llama a la función
	 * {@code requestNewNameFile_VerifyIsAvailable()} para solicitar al usuario un
	 * nuevo nombre de archivo y verificar que el nombre no esté ya en uso en la
	 * carpeta actual. El nombre de archivo disponible se guarda en la variable
	 * {@code newNameFile}.
	 * 
	 * Se llama a la función {@code createNewFileTxt()} para crear un nuevo archivo
	 * de texto con el nombre especificado en {@code newNameFile}. El objeto
	 * {@code File} recién creado se guarda en la variable {@code newFileTxt}.
	 * 
	 * Se llama a la función {@code writeMultiplesLinesInFile()} para escribir
	 * varias líneas de texto en el archivo de texto recién creado
	 * {@code newFileTxt}.
	 * 
	 * Finalmente, se llama a la función {@code turnToMenu()} para volver al menú
	 * principal de la aplicación.
	 */
	public static final void nuevoArchivoTxt() {
		String newNameFile = requestNewNameFile_VerifyIsAvailable();
		File newFileTxt = createNewFileTxt(newNameFile);
		writeMultiplesLinesInFile(newFileTxt);
		turnToMenu();
	}

//	FUNCIONES AUXILIARES DE LA FUNCIÓN PRINCIPAL nuevoArchivoTxt()

	/**
	 * Esta función tiene como objetivo solicitar un nuevo nombre de archivo al
	 * usuario y verificar si ese nombre ya está en uso en la carpeta actual. Se
	 * define una cadena que se usará para solicitar el nombre del archivo al
	 * usuario. Luego, se define una variable booleana {@code fileNameExists} para
	 * almacenar si el nombre del archivo ya existe o no en la carpeta actual.
	 * 
	 * Se realiza un bucle {@code do-while} que se ejecuta hasta que el usuario
	 * ingresa un nombre de archivo que no existe en la carpeta actual. Dentro del
	 * bucle:
	 * 
	 * a. Si {@code fileNameExists} es verdadero, significa que el nombre del
	 * archivo ya existe en la carpeta, por lo que se le informa al usuario que debe
	 * ingresar otro nombre de archivo.
	 * 
	 * b. Se solicita el nombre del archivo al usuario utilizando la función
	 * {@code pideFileName()} y se agrega la extensión ".txt" al final del nombre de
	 * archivo.
	 * 
	 * c. Se llama a la función {@code verifyFileNameAlreadydExists()} para
	 * verificar si el nombre del archivo ya existe en la carpeta actual. Si el
	 * nombre del archivo ya existe, se establece {@code fileNameExists} en
	 * verdadero y el bucle continúa. Si no existe, {@code fileNameExists} se
	 * establece en falso y el bucle termina.
	 * 
	 * Una vez que se ha ingresado un nombre de archivo válido, la función devuelve
	 * la ruta completa del nuevo archivo con el nombre disponible y la extensión
	 * ".txt" agregada.
	 * 
	 * @return la ruta completa del nuevo archivo con un nombre disponible y la
	 *         extensión .txt agregada
	 */
	static String requestNewNameFile_VerifyIsAvailable() {
		String statement = "Indique el nombre del Archivo SIN extensión => ";
		String newFileName;
		boolean fileNameExists = false;

		do {
			if (fileNameExists)
				System.out.println("¡¡¡Este nombre ya existe, elige otro!!!");
			newFileName = pideFileName(statement) + EXTENSION_TXT;
			fileNameExists = verifyFileNameAlreadydExists(newFileName);
		} while (fileNameExists);

		return getArchivo().getFolderPath() + newFileName;
	}

	/**
	 * Verifica si un archivo con el nombre especificado ya existe en la carpeta del
	 * archivo actual.
	 * 
	 * @see #requestNewNameFile_VerifyIsAvailable
	 * @param fileName el nombre del archivo a buscar
	 * @return true si el archivo existe, false de lo contrario
	 */
	private static boolean verifyFileNameAlreadydExists(String fileName) {
		return Arrays.stream(getArchivo().getFolder().list()).anyMatch(e -> e.equals(fileName));
	}

	/**
	 * La función {@code createNewFileTxt} recibe como parámetro una cadena de
	 * caracteres que representa la ruta y el nombre del archivo a crear, verifica
	 * si existe un archivo con ese nombre y si no existe crea un nuevo archivo
	 * vacío con el nombre y ruta especificados.
	 * 
	 * La función devuelve un objeto de tipo {@code File} que representa el archivo
	 * creado.
	 * 
	 * En caso de que el archivo no pueda ser creado, la función muestra un mensaje
	 * de error con la causa del problema.
	 * 
	 * Dentro de la función se utiliza un bucle {@code do-while} para intentar crear
	 * el archivo hasta que se logre o hasta que se produzca un error.
	 * 
	 * La función también muestra un mensaje de confirmación en caso de que el
	 * archivo sea creado exitosamente, y muestra la ruta completa del archivo
	 * creado.
	 * 
	 * @see #nuevoArchivoTxt
	 * 
	 * @param pathWithNewNameVerified cadena de texto con ruta absoluto del archivo
	 *                                a ser creado.
	 * @return instancia File del archivo creado.
	 */
	private static File createNewFileTxt(String pathWithNewNameVerified) {
		File newFileTxt = new File(pathWithNewNameVerified);
		boolean fileNotCreated = true;

		do {
			try {
				fileNotCreated = !newFileTxt.createNewFile();
				if (!fileNotCreated)
					System.out
							.println("   ¡¡¡ ARCHIVO CREADO CORRECTAMENTE !!!\n" + newFileTxt.getAbsolutePath() + "\n");
			} catch (Exception e) {
				System.out.println("Por el motivo:\n" + e.getMessage() + "\nno se ha podido crear el fichero");
			}
		} while (fileNotCreated);

		return newFileTxt;
	}

	/**
	 * La función {@code writeMultiplesLinesInFile} permite al usuario escribir
	 * múltiples líneas de texto en un archivo especificado.
	 * 
	 * La función toma como entrada un objeto de tipo {@code File} que representa el
	 * archivo en el cual se van a escribir las líneas de texto.
	 * 
	 * En primer lugar, la función crea un objeto {@code FileWriter} y un objeto
	 * {@code BufferedWriter}, los cuales se utilizan para escribir en el archivo de
	 * manera eficiente.
	 * 
	 * Luego, se le muestra al usuario un mensaje indicando que ha iniciado el modo
	 * de escritura y se le informa que puede teclear "EX!T" para salir del modo de
	 * escritura. A continuación, se le pide al usuario que escriba el contenido que
	 * desea añadir al archivo.
	 * 
	 * La función recibe la entrada del usuario utilizando el método
	 * {@code nextLine()} de un objeto {@code Scanner}. Si la entrada no es "EX!T",
	 * entonces se escribe el contenido en el archivo utilizando el método
	 * {@code write()} del objeto {BufferedWriter}, seguido de una nueva línea
	 * utilizando el método {@code newLine()}.
	 * 
	 * Este proceso se repite hasta que el usuario escribe "EX!T", momento en el
	 * cual se finaliza el modo de escritura y se cierra el objeto
	 * {@code BufferedWriter} y el objeto {@code FileWriter}. Si ocurre alguna
	 * excepción al intentar escribir en el archivo, se informa al usuario el motivo
	 * del fallo.
	 * 
	 * @see #nuevoArchivoTxt
	 * @param fileToWrite el archivo en el que se escribirá el contenido
	 */
	private static void writeMultiplesLinesInFile(File fileToWrite) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		String userContent = null;

		try {
			fileWriter = new FileWriter(fileToWrite, StandardCharsets.UTF_8);
			bufferedWriter = new BufferedWriter(fileWriter);

			System.out.println("         ¡¡¡ modo escritura iniciado !!!".toUpperCase());
			System.out.println("¡¡¡ tecle EX!T para salir del modo escritura !!!");
			System.out.println(">>ESCRIBA EN EL ARCHIVO " + fileToWrite.getName() + " LO QUE QUIERA:");

			do {
				userContent = getScanner().nextLine();

				if (notEXIT(userContent)) {
					bufferedWriter.write(userContent);
					bufferedWriter.newLine();
				}

			} while (notEXIT(userContent));

			System.out.println("       ¡¡¡ modo escritura finalizado !!!".toUpperCase());

		} catch (Exception e) {
			System.out.println("Por el motivo:\n" + e.getMessage() + "\nno se ha podido escribir en el fichero");

		} finally {
			try {
				if (bufferedWriter != null)
					bufferedWriter.close();
				if (fileWriter != null)
					fileWriter.close();
			} catch (Exception e) {
				System.out.println("¡¡¡ ALGO NO SE HA PODIDO CERRAR !!! => " + e.getMessage());
			}
		}

	}

	/**
	 * La función {@code notEXIT} toma una cadena de texto {@code toVerify} y
	 * verifica si no contiene alguna de las posibles combinaciones para salir del
	 * programa, que son "ex!t", "Ex!t", "EX!t", "EX!T", "eX!T", "ex!T" o "Ex!T". La
	 * función retorna true si la cadena de texto no contiene alguna de las posibles
	 * combinaciones para salir del programa y false si la cadena de texto contiene
	 * alguna de estas combinaciones. La función utiliza expresiones regulares para
	 * verificar si alguna de estas combinaciones se encuentra en la cadena de
	 * texto.
	 * 
	 * @see #writeMultiplesLinesInFile
	 * @param toVerify cadena de texto a verificar
	 * @return true si la cadena de texto no contiene alguna de las posibles
	 *         combinaciones para salir del programa, false de lo contrario.
	 */
	private static boolean notEXIT(String toVerify) {
		String exitsPosibilities = "ex!t|Ex!t|EX!t|EX!T|eX!T|ex!T|Ex!T|eX!t";
		return !Arrays.stream(toVerify.split(" ")).anyMatch(e -> e.matches(exitsPosibilities));
	}

	private final static String EXTENSION_TXT = ".txt";
}
