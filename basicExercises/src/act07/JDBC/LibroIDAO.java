package act07.JDBC;

import java.util.List;
import act07.Model.Libro;

/**
 *
 * Esta es una interfaz llamada LibroIDAO que define los métodos que una clase
 * DAO (Data Access Object) para la entidad Libro debe implementar.
 *
 * La interfaz define dos métodos:
 *
 * readAll(): este método debe retornar una lista de todos los libros existentes
 * en la base de datos. delete(int IDlibro): este método recibe como parámetro
 * el identificador único de un libro y debe eliminarlo de la base de datos. Es
 * importante destacar que esta interfaz solo define los métodos que debe
 * implementar una clase DAO para la entidad Libro. Cada implementación de esta
 * interfaz puede tener su propia implementación de estos métodos, dependiendo
 * de cómo se desea interactuar con la base de datos.
 *
 * @author Fauno Guazina
 */
public interface LibroIDAO {

	public List<Libro> readAll();

	public void delete(int IDlibro);
}
