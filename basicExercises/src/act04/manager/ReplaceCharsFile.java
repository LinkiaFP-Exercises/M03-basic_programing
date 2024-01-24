package act04.manager;

import static act04.introduceDatos.Pregunta.getScanner;
import static act04.auxiliary.AuxiliaryMain.turnToMenu;
import static act04.manager.DisplayFiles.requestFilePosition;
import static act04.manager.FolderArchivos.getArchivo;
import static act04.manager.FolderArchivos.listarArchivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReplaceCharsFile {

	/**
	 * Esta función se encarga de reemplazar caracteres en un archivo de texto
	 * seleccionado por el usuario. Primero, utiliza la función
	 * {@code listarArchivos()} para obtener la lista de archivos de texto en la
	 * carpeta seleccionada. Luego, pide al usuario que seleccione el archivo que
	 * desea modificar y crea un objeto de tipo {@code File} con la ruta y el nombre
	 * del archivo seleccionado.
	 * 
	 * Después, la función crea un objeto {@code RandomAccessFile} para acceder al
	 * contenido del archivo de texto y modificarlo. Utiliza la función
	 * {@code readLine_convertCharUTF()} para leer todo el contenido del archivo y
	 * convertir los caracteres del conjunto de caracteres {@code ISO-8859-1} a
	 * {@code UTF-8}. Luego, muestra el contenido del archivo en la consola.
	 * 
	 * La función le pide al usuario que ingrese el carácter que desea reemplazar y
	 * el nuevo carácter que desea utilizar para reemplazarlo. A continuación,
	 * utiliza la función {@code replace()} para reemplazar todas las instancias del
	 * carácter a reemplazar con el nuevo carácter.
	 * 
	 * Finalmente, la función utiliza el método {@code write()} de
	 * {@code RandomAccessFile} para escribir el contenido modificado en el archivo.
	 * Si la operación de reemplazo es exitosa, la función muestra un mensaje de
	 * éxito. Si no lo es, muestra un mensaje de error.
	 * 
	 * En caso de cualquier excepción, la función maneja el error y muestra un
	 * mensaje en la consola. La función también cierra el objeto
	 * {@code RandomAccessFile} en un bloque finally para asegurarse de que los
	 * recursos del sistema sean liberados correctamente. Al final, llama a la
	 * función {@code turnToMenu()} para volver al menú principal.
	 * 
	 * @see #readLine_convertCharUTF
	 */
	public static void reemplazarCaracteresEnArchivo() {
		String[] archivos = listarArchivos(false);

		int filePositision = requestFilePosition(archivos);

		File fileToUpdateName = new File(getArchivo().getFolderPath() + archivos[filePositision]);

		RandomAccessFile randomAccessFile = null;

		try {
			randomAccessFile = new RandomAccessFile(fileToUpdateName, "rw");

			String fileContent = readLine_convertCharUTF(randomAccessFile);

			String fileName = fileToUpdateName.getName();

			System.out.println("\n>>> CONTENIDO DEL ARCHIVO >>> " + fileName + " <\n\n" + fileContent
					+ "\n>>>>>>>>> FIN DEL ARCHIVO >>> " + fileName + " <");

			System.out.print("Indique el caracter a reemplzar => ");
			String charToChange = getScanner().nextLine();
			System.out.print("Indique el nuevo caracter => ");
			String charForChange = getScanner().nextLine();

			String contentFileChanged = fileContent.replace(charToChange, charForChange);

			randomAccessFile.seek(0);
			randomAccessFile.write(contentFileChanged.getBytes());

			System.out.println("¡¡¡ REEMPLAZO EFECTUADO CON EXITO !!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (randomAccessFile != null)
					randomAccessFile.close();
			} catch (Exception e) {
				System.out.println("¡¡¡ AALGO NO SE HA PODIDO CERRAR !!! => " + e.getMessage());
			}
		}

		turnToMenu();
	}

	/**
	 * Esta función lee un archivo de acceso aleatorio y convierte los caracteres de
	 * la codificación {@code "ISO-8859-1"} a {@code "UTF-8"}.
	 * 
	 * La función toma como parámetro un objeto {@code RandomAccessFile}, que es una
	 * clase de Java que permite acceder a un archivo de forma aleatoria. Dentro de
	 * la función, se crea un objeto StringBuilder llamado lines que se utilizará
	 * para almacenar el contenido del archivo.
	 * 
	 * La función comienza estableciendo el puntero del archivo en la posición cero
	 * (es decir, el principio del archivo) utilizando el método {@code seek} del
	 * objeto {@code RandomAccessFile}. A continuación, entra en un bucle
	 * {@code while} que se ejecuta mientras el puntero del archivo sea menor que la
	 * longitud total del archivo.
	 * 
	 * Dentro del bucle, la función lee cada línea del archivo utilizando el método
	 * {@code readLine} del objeto {@code RandomAccessFile}. Luego, la línea se
	 * convierte de "ISO-8859-1" a "UTF-8" utilizando la clase {@code String}. Esto
	 * se hace creando una nueva instancia de String y pasando como parámetro la
	 * línea leída del archivo, concatenada con el separador de línea del sistema
	 * {@code System.lineSeparator()}, convertida en bytes utilizando la
	 * codificación "ISO-8859-1" y luego convertida a una cadena utilizando la
	 * codificación "UTF-8". La línea convertida se agrega al objeto
	 * {@code StringBuilder lines}.
	 * 
	 * Después de leer y convertir todas las líneas del archivo, la función devuelve
	 * el contenido del objeto StringBuilder lines como una cadena utilizando el
	 * método toString.
	 * 
	 * @param randomAccessFile del archivo que será leído
	 * @return objeto StringBuilder lines como una cadena utilizando el método
	 *         toString
	 * @throws IOException
	 */
	private static String readLine_convertCharUTF(RandomAccessFile randomAccessFile) throws IOException {
		StringBuilder lines = new StringBuilder();
		randomAccessFile.seek(0);
		while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
			lines.append(
					new String((randomAccessFile.readLine() + System.lineSeparator()).getBytes("ISO-8859-1"), "UTF-8"));
		}
		return lines.toString();
	}
}
