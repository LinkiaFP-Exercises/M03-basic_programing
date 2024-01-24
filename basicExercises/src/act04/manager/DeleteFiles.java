package act04.manager;

import static act04.auxiliary.AuxiliaryMain.turnToMenu;
import static act04.manager.DisplayFiles.requestFilePosition;
import static act04.manager.FolderArchivos.getArchivo;
import static act04.manager.FolderArchivos.listarArchivos;

import java.io.File;

public class DeleteFiles {

	/**
	 * Esta función tiene como objetivo eliminar un archivo existente. Se llama a la
	 * función {@code listarArchivos(false)} para obtener una lista de los archivos
	 * en la carpeta actual y se guarda en la matriz {@code archivos}.
	 * 
	 * Se llama a la función {@code requestFilePosition(archivos)} para solicitar al
	 * usuario que seleccione el archivo que desea eliminar de la lista de archivos.
	 * La función devuelve la posición del archivo seleccionado en la matriz
	 * {@code archivos}, que se guarda en la variable {@code filePosition}.
	 * 
	 * Se crea un nuevo objeto {@code File} con la ruta del archivo seleccionado que
	 * se va a eliminar. La ruta se compone de la ruta de la carpeta actual y el
	 * nombre del archivo seleccionado.
	 * 
	 * Se llama al método {@code delete()} del objeto {@code File} para eliminar el
	 * archivo. Si el archivo se elimina correctamente, el valor booleano
	 * {@code wasDeleted} se establece en {@code true}. De lo contrario, se
	 * establece en {@code false}.
	 * 
	 * Se imprime un mensaje que indica si se ha eliminado el archivo o no.
	 * Finalmente, se llama a la función {@code turnToMenu()} para volver al menú
	 * principal de la aplicación.
	 */
	public static void borrarArchivo() {

		String[] archivos = listarArchivos(false);

		int filePositision = requestFilePosition(archivos);

		File fileToDelete = new File(getArchivo().getFolderPath() + archivos[filePositision]);

		boolean wasDeleted = fileToDelete.delete();

		if (wasDeleted)
			System.out.println(DIVISOR + "\n" + "ARCHIVO " + fileToDelete.getName() + " BORRADO" + "\n" + DIVISOR);
		else
			System.out.println(
					DIVISOR + "\n" + "NO SE HA PODIDO BORRAR EL ARCHIVO " + fileToDelete.getName() + "\n" + DIVISOR);

		turnToMenu();
	}

	private final static String DIVISOR = ">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<";

}
