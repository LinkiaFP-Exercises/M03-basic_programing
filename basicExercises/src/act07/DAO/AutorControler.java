package act07.DAO;

import act07.JDBC.AutorIDAO;
import act07.JDBC.AutorDTO;
import act07.Model.Autor;
import static act07.View.Libreria.turnToMenu;
import static act07.Resources.Pregunta.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * Esta es la clase AutorControler, que es una especie de controlador que
 * utiliza la interfaz AutorIDAO y la implementación AutorDTO para realizar
 * operaciones en la tabla "autores" de la base de datos.
 *
 * La clase contiene dos métodos importantes: printAllAutores y updateAutor.
 *
 * El método printAllAutores llama al método readAll de la interfaz AutorIDAO,
 * que devuelve una lista de todos los autores presentes en la tabla "autores"
 * de la base de datos. A continuación, formatea e imprime esta lista en la
 * salida estándar. Si el parámetro turnToMenu es verdadero, llama al método
 * turnToMenu de la clase Libreria.
 *
 * El método updateAutor pide al usuario el ID del autor que se desea modificar,
 * el campo (nombre o apellido) que se desea actualizar y el nuevo valor del
 * campo. A continuación, llama al método update de la interfaz AutorIDAO,
 * pasando el campo y el autor actualizado como parámetros. Luego imprime un
 * mensaje indicando que el autor ha sido actualizado y llama al método
 * turnToMenu de la clase Libreria.
 *
 * Además, la clase AutorControler también contiene dos métodos auxiliares:
 * printListAutorFormated, que formatea e imprime la lista de autores, y la
 * clase printAutor, que es una implementación de la interfaz Consumer<Autor> y
 * se utiliza para imprimir cada autor en la lista en un formato determinado.
 *
 * @author Fauno Guazina
 */
public class AutorControler {

	private static final AutorIDAO autorDAO = new AutorDTO();

	public static List<Autor> printAllAutores(boolean turnToMenu) {

		System.out.println("\n¡¡¡ LISTA DE AUTORES DISPONIBLES !!!");
		List<Autor> autoresList = autorDAO.readAll();
		printListAutorFormated(autoresList);

		if (turnToMenu)
			turnToMenu(true);

		return autoresList;
	}

	public static void updateAutor() {
		List<Autor> autoresList = printAllAutores(false);

		int idAutor = 0;
		do {
			idAutor = pideEntero("\nIngrese el ID del autor que desea modificar => ");
		} while (idAutor < 1 || idAutor > autoresList.size());

		int optionToUpdate;
		do {
			optionToUpdate = pideEntero("\nCual es el dato que desea modificar?\n1 - Nombre"
					+ "\n2 - Apellido\nIndique la opción deseada =>");
		} while (optionToUpdate < 1 || optionToUpdate > 2);

		String campoToUpdate = (optionToUpdate == 1) ? "nombre" : "apellidos";

		String dataToUpdate = pidePalabra("Indique el nuevo " + campoToUpdate + " => ");

		Autor autorToUpdate = (optionToUpdate == 1) ? new Autor(idAutor, dataToUpdate, "")
				: new Autor(idAutor, "", dataToUpdate);

		autorDAO.update(campoToUpdate, autorToUpdate);

		System.out.println("\n¡¡¡ AUTOR ACTUALIZADO CORRECTAMENTE !!!");
		turnToMenu(false);
	}

	private static void printListAutorFormated(List<Autor> autoresList) {
		System.out.println(
				"ID   |   First name   |       Last name      \n" + "-----|----------------|----------------------");

		autoresList.forEach(new printAutor());
	}

	private static class printAutor implements Consumer<Autor> {

		@Override
		public void accept(Autor t) {
			System.out.printf("%-5d| %-15s| %-20s%n", t.getId_autor(), t.getNombre(), t.getApellido());
		}

	}
}
