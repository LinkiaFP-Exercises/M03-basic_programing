package act07.JDBC;

import act07.Model.Autor;
import act07.Model.Libro;
import static act07.View.Libreria.getConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se llama LibroDTO e implementa la interfaz LibroIDAO. Contiene dos
 * métodos: readAll() y delete(), que leen y eliminan registros de la tabla de
 * libros en la base de datos.
 *
 * El método readAll() devuelve una lista de objetos Libro que se obtiene al
 * hacer una consulta a la base de datos mediante una sentencia SQL. En este
 * caso, se utiliza una sentencia SELECT para recuperar todos los registros de
 * la tabla libros y los datos de la tabla autores relacionados a través de la
 * clave foránea autor. Luego, se crea un objeto Libro con los datos recuperados
 * de la consulta y se agrega a la lista librosList, que se devuelve al final
 * del método.
 *
 * El método delete() elimina un registro de la tabla libros en la base de
 * datos, dado un ID de libro proporcionado como argumento. Esto se logra
 * mediante una sentencia SQL DELETE, donde se utiliza un PreparedStatement para
 * asignar el valor del ID del libro al parámetro de la sentencia. Si se produce
 * algún error en la eliminación, se captura la excepción y se imprime un
 * mensaje de error.
 *
 * La clase también tiene dos constantes de clase que contienen las sentencias
 * SQL utilizadas en los métodos readAll() y delete(), y una conexión a la base
 * de datos obtenida a través del método estático getConnector() de la clase
 * Libreria.
 *
 *
 * @author Fauno Guazina
 */
public class LibroDTO implements LibroIDAO {

	@Override
	public List<Libro> readAll() {
		List<Libro> librosList = new ArrayList<>();

		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(QUERY_SELECT_ALL_JOIN_AUTORES);

			while (resultSet.next()) {
				librosList.add(new Libro(resultSet.getInt("id_libro"), resultSet.getString("titulo"),
						new Autor(resultSet.getInt("id_autor"), resultSet.getString("nombre"),
								resultSet.getString("apellidos")),
						resultSet.getString("pais"), resultSet.getInt("paginas"), resultSet.getString("genero")));
			}

		} catch (SQLException e) {
			System.out.println("NO FUE POSIBLE RECUPERAR LOS LIBROS: ");
			e.printStackTrace(System.out);
		}

		return librosList;
	}

	@Override
	public void delete(int IDlibro) {
		try (PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_LIBRO)) {
			statement.setInt(1, IDlibro);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			System.out.println("NO FUE POSIBLE BORRAR EL LIBRO: ");
			e.printStackTrace(System.out);
		}
	}

	private final Connection connection = getConnector().getConnection();

	private final String QUERY_SELECT_ALL_JOIN_AUTORES = "SELECT * FROM libreria.libros join libreria.autores where libros.autor = autores.id_autor;";

	private final String QUERY_DELETE_LIBRO = "DELETE FROM libros WHERE id_libro = ?";

}
