package act04.manager;

import static act04.auxiliary.AuxiliaryMain.turnToMenu;

import java.io.File;
import java.util.Arrays;

public final class FolderArchivos {

	/**
	 * Esta función devuelve un array de tipo {@code String} que contiene el nombre
	 * de todos los archivos en una carpeta específica, ordenados alfabéticamente.
	 * La función también imprime en consola el listado de archivos con un formato
	 * específico, utilizando un contador para numerar cada archivo.
	 * 
	 * La función toma un parámetro booleano llamado {@code turnToMenu}, que si es
	 * true, llama a otra función llamada {@code turnToMenu()}. Si este parámetro es
	 * false, la función simplemente devuelve el {@code array} de nombres de
	 * archivos de la carpeta.
	 * 
	 * La función utiliza el método {@code getArchivo()} para obtener un objeto de
	 * tipo {@code FolderArchivos}. Luego, utiliza el método {@code getFolder()} en
	 * este objeto para obtener la carpeta en la que se encuentran los archivos.
	 * Después, utiliza el método {@code list()} en esta carpeta para obtener un
	 * array de tipo String que contiene los nombres de todos los archivos en la
	 * carpeta. A continuación, utiliza el método {@code sorted()} para ordenar los
	 * nombres de los archivos alfabéticamente. Por último, utiliza el método
	 * {@code toArray()} para convertir el array de nombres de archivos a un array
	 * de tipo {@code String[]}. Una vez que se ha creado el array de archivos, la
	 * función imprime en consola un mensaje de encabezado y luego recorre el array
	 * para imprimir cada nombre de archivo con un contador que los numerará.
	 * Finalmente, la función imprime un mensaje de pie de página.
	 * 
	 * @param turnToMenu booleano para si al terminar el listado de archivos debe o
	 *                   no volver al menu
	 * @return String array con nombres de los archivos listados
	 */
	public final static String[] listarArchivos(boolean turnToMenu) {

		String[] archivos = Arrays.stream(getArchivo().getFolder().list()).sorted().toArray(String[]::new);

		System.out.println("\n>>> LISTADO DE ARCHIVOS DE TEXTO <<<");

		int position = 0;
		for (String file : archivos) {
			System.out.println(">>>>> " + (++position) + " - " + file);
		}

		System.out.println(">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<");

		if (turnToMenu)
			turnToMenu();

		return archivos;
		/*
		 * he optado por retornar solo los nombres de los archivos, ya que tengo la ruta
		 * siempre a mano por como desarollé la clase FolderArchivos.java, así evito
		 * tratar las ruta para sacar los nombres y ahorro memoria en montar objetos
		 * File
		 */
	}

	@Override
	public final int hashCode() {
		int clave = "DAM.M03.actividad04.FaunoGuazina".hashCode();
		int base = folderPath.hashCode();
		int result = clave + base;
		return result;
	}

	@Override
	public String toString() {
		return "FolderArchivos: [" + "\n getBasePath() => " + getBasePath() + "\n getSeparator() => " + getSeparator()
				+ "\n getFolderPath() => " + getFolderPath() + "\n getFolder() => " + getFolder() + "\n hashCode() => "
				+ hashCode() + "\n]";
	}

	// METODOS GETTERS PARA ACCEDER A LAS VARIABLES

	/**
	 * @return la instancia de esta clase que contiene el objeto con todos las
	 *         caracteristicas y metodos necesarios para manejarla
	 */
	final static FolderArchivos getArchivo() {
		return carpetaArchivos;
	}

	final String getBasePath() {
		return basePath;
	}

	final String getSeparator() {
		return separator;
	}

	// HE OPTADO POR ESTE GET CON SEPARADOR PARA FAICLITAR EL FLUJO
	final String getFolderPath() {
		return folderPath + separator;
	}

	final File getFolder() {
		return folder;
	}

	// CONTRUCTOR PRIVADO PARA QUE NO SE PUEDA CONSTRUIR NINGUNA OTRA INSTANCIA
	// EXCEPTO LA QUE TENEMOS EN LA CLASE
	private FolderArchivos() {
		this.basePath = System.getProperty("user.dir");
		this.separator = File.separator;
		this.folderPath = basePath + separator + "archivos";
		this.folder = new File(folderPath);

		if (!folder.exists())
			folder.mkdir();
	}

	// VARIABLES DE LA CLASE PARA QUE SI PUEDA INVOCAR LOS METODOS GET

	private final static FolderArchivos carpetaArchivos = new FolderArchivos();
	private final String basePath;
	private final String separator;
	private final String folderPath;
	private final File folder;

}
