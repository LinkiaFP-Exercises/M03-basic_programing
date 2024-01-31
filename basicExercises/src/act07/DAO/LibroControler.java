package act07.DAO;

import act07.JDBC.LibroDTO;
import act07.JDBC.LibroIDAO;
import act07.Model.Libro;
import static act07.Resources.Pregunta.pideEntero;
import static act07.View.Libreria.turnToMenu;
import java.util.List;

/**
 * Esta clase LibroControler es otra capa intermedia de la arquitectura DAO,
 * encargada de manejar la lógica de negocio relacionada con los libros en la
 * aplicación.
 *
 * La clase tiene dos métodos estáticos que manejan la lógica de negocio para
 * mostrar y borrar libros respectivamente. Ambos métodos usan el objeto
 * LibroIDAO para realizar operaciones de lectura y borrado de libros en la base
 * de datos.
 *
 * El método printAllLibros recibe un parámetro booleano turnToMenu que indica
 * si después de imprimir la lista de libros se debe volver al menú principal.
 * Este método primero muestra la lista de libros usando el objeto LibroIDAO
 * para obtener la lista completa de libros desde la base de datos, y luego
 * llama al método printListLibrosFormated para imprimir la lista de libros en
 * la consola en un formato específico. Si el parámetro turnToMenu es true, el
 * método llama al método turnToMenu de la clase Libreria para volver al menú
 * principal.
 *
 * El método borrarLibro también usa el objeto LibroIDAO para borrar un libro
 * específico de la base de datos. Este método también muestra la lista de
 * libros usando el método printAllLibros antes de permitir al usuario
 * seleccionar un libro para borrar. Después de borrar el libro seleccionado, el
 * método llama al método turnToMenu de la clase Libreria para volver al menú
 * principal.
 *
 * Además, la clase también tiene un método privado llamado
 * printListLibrosFormated que se utiliza para imprimir la lista de libros en un
 * formato específico. El método utiliza la función lambda para imprimir cada
 * libro en un formato de tabla legible en la consola.
 *
 * @author Fauno Guazina
 */
public class LibroControler {

	private static final LibroIDAO libroDAO = new LibroDTO();

	public static List<Libro> printAllLibros(boolean turnToMenu) {
		System.out.println("\n¡¡¡ LISTA DE LIBROS DISPONIBLES !!!");
		List<Libro> librosList = libroDAO.readAll();
		printListLibrosFormated(librosList);

		if (turnToMenu)
			turnToMenu(true);

		return librosList;
	}

	public static void borrarLibro() {
		List<Libro> librosList = printAllLibros(false);

		int idlibro = 0;
		do {
			idlibro = pideEntero("\nIngrese el ID del libro que desea borrar => ");
		} while (idlibro < 1 || idlibro > librosList.size());

		libroDAO.delete(idlibro);

		System.out.println("\n¡¡¡ LIBRO BORRADO CORRECTAMENTE !!!");

		turnToMenu(false);
	}

	private static void printListLibrosFormated(List<Libro> librosList) {
		System.out.println(
				"ID   | Title                              | Author                 | Country          | Pages | Genre   |\n"
						+ "-----|------------------------------------|------------------------|------------------|-------|----------");

		librosList.forEach(t -> {
			System.out.printf("%-5d| %-35s| %-19s| %-20s| %-6d| %-9s%n", t.getId_libro(), t.getTitulo(),
					t.getAutor().getNombre() + " " + t.getAutor().getApellido(), t.getPais(), t.getPaginas(),
					t.getGenero());
		});
	}

}
