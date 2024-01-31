package act07.JDBC;

import java.util.List;
import act07.Model.Autor;

/**
 * Esta es una interfaz Java que define el contrato para una clase DAO (Data
 * Access Object) que accede y manipula los datos de la tabla de autores en la
 * base de datos.
 *
 * La interfaz AutorIDAO define dos métodos abstractos:
 *
 * readAll(): Este método debe devolver una lista de objetos Autor que contienen
 * todos los registros de la tabla de autores en la base de datos.
 *
 * update(String campoToUpdate, Autor autor): Este método debe actualizar un
 * registro existente en la tabla de autores en la base de datos. Recibe como
 * parámetros el nombre del campo a actualizar y el objeto Autor con los nuevos
 * datos para ese campo.
 *
 * Cualquier clase que implemente esta interfaz debe proporcionar una
 * implementación para estos dos métodos.
 *
 * @author Fauno Guazina
 */
public interface AutorIDAO {

	public List<Autor> readAll();

	public void update(String campoToUpdate, Autor autor);
}
