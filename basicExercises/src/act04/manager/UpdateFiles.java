package act04.manager;

import static act04.auxiliary.AuxiliaryMain.turnToMenu;
import static act04.manager.CreateFiles.requestNewNameFile_VerifyIsAvailable;
import static act04.manager.DisplayFiles.requestFilePosition;
import static act04.manager.FolderArchivos.getArchivo;
import static act04.manager.FolderArchivos.listarArchivos;

import java.io.File;

public class UpdateFiles {

	/**
	 * Esta función cambia el nombre de un archivo en la carpeta "archivos". La
	 * función utiliza la función {@code listarArchivos(false)} para obtener una
	 * lista de archivos en la carpeta y luego pide al usuario que seleccione un
	 * archivo para ser renombrado.
	 * 
	 * Después de obtener el archivo a renombrar, la función solicita al usuario que
	 * ingrese un nuevo nombre para el archivo y verifica que no exista ya un
	 * archivo con ese nombre. Luego, crea un objeto {@code File} para el archivo
	 * original y otro objeto File para el archivo renombrado.
	 * 
	 * Luego, la función intenta renombrar el archivo original utilizando el método
	 * {@code renameTo()} de la clase {@code File}. Si la operación de renombrar es
	 * exitosa, la función muestra un mensaje de éxito en consola. Si falla, lanza
	 * una excepción con un mensaje de error personalizado.
	 * 
	 * Después de renombrar el archivo, la función llama a la función
	 * {@code turnToMenu()} que probablemente muestra un menú de opciones en
	 * consola.
	 * 
	 */
	public static void renombrarArchrivo() {
		String[] archivos = listarArchivos(false);

		int filePositision = requestFilePosition(archivos);

		File fileToUpdateName = new File(getArchivo().getFolderPath() + archivos[filePositision]);

		String newNameFile = requestNewNameFile_VerifyIsAvailable();

		File fileRenamed = new File(newNameFile);

		try {

			boolean renameIsSuccessful = fileToUpdateName.renameTo(fileRenamed);

			if (renameIsSuccessful)
				System.out.println(DIVISOR + "\n" + ">>> ARCHIVO RENOMBRADO CON ÉXITO <<<" + "\n" + DIVISOR);
			else
				throw new RuntimeException("RENOMBRAR NO FUE POSIBLE");

		} catch (Exception e) {
			System.out.println(DIVISOR + "\n" + e.getMessage() + "\n" + DIVISOR);
		}

		turnToMenu();
	}

	private final static String DIVISOR = ">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<";
}
