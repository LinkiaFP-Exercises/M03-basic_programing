package act07.JDBC;

import act07.Model.Autor;
import static act07.View.Libreria.getConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se llama AutorDTO y es una implementación de la interfaz AutorIDAO
 * que define la lógica de acceso a datos para la entidad Autor en una base de
 * datos relacional a través del lenguaje de programación Java utilizando el
 * patrón de diseño DAO (Data Access Object).
 *
 * La clase AutorDTO tiene dos métodos que implementan los métodos abstractos de
 * la interfaz AutorIDAO:
 *
 * readAll(): devuelve una lista de todos los autores registrados en la base de
 * datos.
 *
 * update(String campoToUpdate, Autor autor): actualiza un campo específico de
 * un autor en la base de datos, identificado por su ID.
 *
 * Además, la clase tiene un objeto Connection que proviene de la conexión a la
 * base de datos a través del método getConnector() de la clase View.Libreria.
 * También tiene dos constantes que representan las consultas SQL utilizadas
 * para recuperar todos los autores y actualizar un autor en particular.
 *
 * La clase utiliza objetos PreparedStatement y ResultSet para realizar
 * consultas y actualizaciones de la base de datos. También captura excepciones
 * SQLException para manejar errores en la interacción con la base de datos.
 *
 * @author Fauno Guazina
 */
public class AutorDTO implements AutorIDAO {

	@Override
	public List<Autor> readAll() {
		List<Autor> autoresList = new ArrayList<>();

		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(QUERY_SELECT_ALL);

			while (resultSet.next()) {
				autoresList.add(new Autor(resultSet.getInt("id_autor"), resultSet.getString("nombre"),
						resultSet.getString("apellidos")));
			}

		} catch (SQLException e) {
			System.out.println("NO FUE POSIBLE RECUPERAR LOS AUTORES: ");
			e.printStackTrace(System.out);
		}

		return autoresList;
	}

	@Override
	public void update(String campoToUpdate, Autor autor) {

		String queryUpdateAutorAjustada = String.format(QUERY_UPDATE_AUTOR, campoToUpdate);

		try (PreparedStatement statement = connection.prepareStatement(queryUpdateAutorAjustada)) {

			if (campoToUpdate.equalsIgnoreCase("nombre"))
				statement.setString(1, autor.getNombre());
			else
				statement.setString(1, autor.getApellido());

			statement.setInt(2, autor.getId_autor());

			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			System.out.println("NO FUE POSIBLE ACTUALIZAR LOS AUTORES: ");
			e.printStackTrace(System.out);
		}

	}

	private final Connection connection = getConnector().getConnection();

	private final String QUERY_SELECT_ALL = "SELECT * FROM AUTORES;";

	private static final String QUERY_UPDATE_AUTOR = "UPDATE autores SET %s = ? WHERE id_autor = ?";

}
