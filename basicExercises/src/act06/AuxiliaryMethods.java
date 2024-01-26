package act06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase AuxiliaryMethods contiene una serie de métodos auxiliares que son
 * utilizados por el programa principal para realizar diversas operaciones. A
 * continuación se explica la funcionalidad de cada método:
 * 
 * @see #start()
 * 
 * @see #iniciarVentanaPricipal()
 * 
 * @see #armazenarEmpleados()
 * 
 * @see #llenarEmpleados()
 * 
 * @see #leerArchivo()
 * 
 * @see #recuperarEmpleados()
 * 
 * @see #titleCase(String word)
 * 
 * @see #isEmpty(String toVerify)
 * 
 * @see #DATOS_EMPLEADOS
 * 
 * @see #ARCHIVO_EMPLEADOS
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 *
 */
final class AuxiliaryMethods {

	/**
	 * Este método es el punto de entrada al programa y se encarga de llamar a otros
	 * métodos auxiliares para llenar la lista de empleados, almacenar la lista en
	 * un archivo, y luego iniciar la ventana principal del programa.
	 */
	public static void start() {
		llenarEmpleados();
		armazenarEmpleados();
		iniciarVentanaPricipal();
	}

	/**
	 * Este método crea una nueva instancia de la clase VentanaBienvenida y la hace
	 * visible para el usuario.
	 */
	private static void iniciarVentanaPricipal() {
		new VentanaBienvenida().setVisible(true);
	}

	/**
	 * Este método se encarga de almacenar la lista de empleados en un archivo
	 * utilizando la clase ObjectOutputStream.
	 */
	private static void armazenarEmpleados() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EMPLEADOS));
			objectOutputStream.writeObject(DATOS_EMPLEADOS);
			objectOutputStream.close();
			System.out.println("Todos los empleados serializados en el archivo DATOS_EMPLEADOS.hashMap");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este método agrega tres objetos de la clase Empleado a la lista de empleados
	 * utilizando el método put() de la clase HashMap.
	 */
	private static void llenarEmpleados() {
		Empleado empleado = new Empleado("Fauno", "Guazina", 1850);
		DATOS_EMPLEADOS.put(empleado.getNombre(), empleado);
		empleado = new Empleado("Adrian", "Gutierrez", 2500);
		DATOS_EMPLEADOS.put(empleado.getNombre(), empleado);
		empleado = new Empleado("Francesc", "Perez", 4500);
		DATOS_EMPLEADOS.put(empleado.getNombre(), empleado);
	}

	/**
	 * Este método es utilizado para leer la lista de empleados desde el archivo
	 * donde fue almacenada, utilizando la clase ObjectInputStream. Si se produce
	 * algún error, se lanza la excepción ErrorLeerArchivo.
	 * 
	 * @throws ErrorLeerArchivo
	 */
	static void leerArchivo() throws ErrorLeerArchivo {
		try {
			recuperarEmpleados();
			DATOS_EMPLEADOS.values().forEach(System.out::println);
		} catch (Exception e) {
			throw new ErrorLeerArchivo("No se pudo leer el archivo de empleados : " + e.getLocalizedMessage());
		}
	}

	/**
	 * Este método es llamado por el método leerArchivo() y se encarga de leer los
	 * objetos de la clase Empleado almacenados en el archivo y agregarlos a la
	 * lista de empleados.
	 */
	static void recuperarEmpleados() {
		DATOS_EMPLEADOS.clear();
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ARCHIVO_EMPLEADOS));
			@SuppressWarnings("unchecked")
			Map<String, Empleado> readObject = (Map<String, Empleado>) objectInputStream.readObject();
			DATOS_EMPLEADOS.putAll(readObject);
			objectInputStream.close();
		} catch (Exception e) {
			System.out.println("ERROR EN LA FUNCIÓN recuperarEmpleados() de AuxiliaryMethods");
			e.printStackTrace();
		}
	}

	/**
	 * Este método recibe una palabra como parámetro y la convierte en formato
	 * "Title Case", es decir, la primera letra en mayúscula y el resto en
	 * minúscula.
	 * 
	 * @param word
	 * @return title case of same word
	 */
	static String titleCase(String word) {
		return (isEmpty(word)) ? word : Character.toTitleCase(word.charAt(0)) + word.substring(1).toLowerCase();

	}

	/**
	 * Este método recibe una cadena como parámetro y verifica si es nula o está
	 * vacía (sin contenido) utilizando una serie de métodos de cadena
	 * proporcionados por Java. Retorna un valor booleano indicando si la cadena es
	 * o no vacía.
	 * 
	 * @param toVerify
	 * @return boolean
	 */
	static boolean isEmpty(String toVerify) {
		return toVerify == null | toVerify.isEmpty() | toVerify.isBlank() | toVerify.strip().isEmpty();

	}

	/**
	 * Este campo es un objeto de la clase HashMap que se utiliza para almacenar los
	 * objetos de la clase Empleado. 
	 */
	static final Map<String, Empleado> DATOS_EMPLEADOS = new HashMap<>();

	/**
	 * Este campo es una cadena que contiene el nombre del archivo donde se
	 * almacenan los objetos de la clase Empleado.
	 */
	static final String ARCHIVO_EMPLEADOS = System.getProperty("user.dir") + File.separator + "DATOS_EMPLEADOS.hashMap";
}
