package act07.JDBC;

import static act07.View.Libreria.turnToMenu;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * La clase Connector se encarga de conectarse y desconectarse de la base de
 * datos MySQL a través de JDBC. Además, proporciona funciones para crear una
 * base de datos de prueba, crear tablas y añadir datos básicos de prueba.
 *
 * La clase contiene los siguientes métodos públicos:
 *
 * getConnection(): Devuelve la conexión a la base de datos establecida.
 * connect(): Se conecta a la base de datos especificada utilizando el
 * controlador JDBC de MySQL. disconnect(): Cierra la conexión a la base de
 * datos, si está abierta. createBasicDataForTesting(): Este método crea una
 * base de datos de prueba llamada "libreria", crea tablas y añade datos de
 * prueba básicos, incluyendo dos autores (Jane Austen y George Orwell) y sus
 * respectivos libros. La clase también contiene los siguientes métodos
 * privados:
 *
 * createDB(): Este método se utiliza para crear la base de datos "libreria".
 * createTables(): Este método crea las tablas "autores" y "libros" en la base
 * de datos "libreria". Además, la clase contiene varias constantes privadas que
 * se utilizan para establecer la conexión con la base de datos, como la URL de
 * la base de datos, el nombre de usuario y la contraseña.
 *
 * En general, la clase Connector proporciona una manera fácil de conectarse y
 * desconectarse de la base de datos MySQL, así como de crear una base de datos
 * de prueba y cargar datos de prueba en ella.
 *
 * @author Fauno Guazina
 */
public class Connector {

	public Connection getConnection() {
		return connection;
	}

	/**
	 * La función "connect" de la clase "Connector" se encarga de conectar la
	 * aplicación Java con una base de datos MySQL. La conexión se establece
	 * utilizando la clase "DriverManager" de JDBC. En esta función, se realiza lo
	 * siguiente:
	 *
	 * Se carga el controlador JDBC de MySQL mediante la sentencia
	 * "Class.forName("com.mysql.cj.jdbc.Driver")". Esto es necesario para registrar
	 * el controlador en el entorno de la aplicación.
	 *
	 * Se establece la conexión con la base de datos MySQL mediante la llamada a
	 * "DriverManager.getConnection". La cadena de conexión se compone de la URL de
	 * la base de datos, el usuario y la contraseña. Estos valores se obtienen a
	 * partir de las variables miembro de la clase.
	 *
	 * Si la conexión se ha establecido correctamente, se muestra un mensaje de
	 * éxito en la consola.
	 *
	 * Si ocurre una excepción, se muestra el mensaje de error en la consola.
	 */
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_URL + JDBC_COMMU_OPT, JDBC_USER, JDBC_PASSWORD);
			System.out.println("\n¡¡¡ BASE DE DATOS CONECTADA !!!");
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

	/**
	 * La función disconnect() es un método de la clase DatabaseConnection que se
	 * encarga de cerrar la conexión a la base de datos que fue establecida
	 * previamente con la función connect().
	 *
	 * Cerrar la conexión a la base de datos es importante para liberar los recursos
	 * utilizados por la conexión y prevenir errores en futuras operaciones en la
	 * base de datos. Cuando se llama a disconnect(), se cierra la conexión activa a
	 * la base de datos y se realiza una limpieza de los recursos utilizados por la
	 * conexión.
	 *
	 * En resumen, la función disconnect() es utilizada para cerrar la conexión a la
	 * base de datos y liberar los recursos utilizados por la misma, asegurando una
	 * correcta gestión de la memoria y evitando posibles errores en futuras
	 * operaciones con la base de datos.
	 */
	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("\n¡¡¡ BASE DE DATOS DESCONECTADA !!!");
			} catch (SQLException ex) {
				System.out.println("No se puede desconectar de la base de datos " + JDBC_DDBB);
				ex.printStackTrace(System.out);
			}
		}
	}

	/**
	 * La función createBasicDataForTesting() se encarga de crear datos básicos para
	 * realizar pruebas en la base de datos. Primero, llama a las funciones
	 * createDB() y createTables() para crear la base de datos y las tablas
	 * necesarias.
	 *
	 * Luego, se prepara una consulta SQL para agregar un autor a la tabla "autor".
	 * En este caso, se agrega el autor "Jane Austen". La consulta se ejecuta y se
	 * obtiene el id del autor generado.
	 *
	 * A continuación, se prepara otra consulta SQL para agregar un libro a la tabla
	 * "libro". En este caso, se agrega el libro "Orgullo y Prejuicio", que se
	 * relaciona con el autor "Jane Austen". Se establecen los valores
	 * correspondientes para las diferentes columnas de la tabla "libro". La
	 * consulta se ejecuta y el libro se agrega a la base de datos.
	 *
	 * Luego, se repite el mismo proceso para agregar el autor "George Orwell" y su
	 * libro "1984".
	 *
	 * Finalmente, se imprime un mensaje de confirmación y se llama a la función
	 * turnToMenu() para volver al menú principal.
	 *
	 * En resumen, esta función crea datos básicos de prueba en la base de datos,
	 * específicamente dos autores y dos libros relacionados.
	 */
	public void createBasicDataForTesting() {
		createDB();
		createTables();
		try (PreparedStatement queryAutorCreation = connection.prepareStatement(ADD_AUTOR,
				Statement.RETURN_GENERATED_KEYS)) {
			queryAutorCreation.setString(1, "Jane");
			queryAutorCreation.setString(2, "Austen");
			queryAutorCreation.executeUpdate();

			ResultSet autoresID = queryAutorCreation.getGeneratedKeys();

			if (autoresID.next()) {

				try (PreparedStatement queryLibroCreation = connection.prepareStatement(ADD_LIBRO)) {
					queryLibroCreation.setString(1, "Orgullo y Prejuicio");
					queryLibroCreation.setInt(2, autoresID.getInt(1));
					queryLibroCreation.setString(3, "Reino Unido");
					queryLibroCreation.setInt(4, 432);
					queryLibroCreation.setString(5, "Romance");
					queryLibroCreation.executeUpdate();
				}
			}

			queryAutorCreation.setString(1, "George");
			queryAutorCreation.setString(2, "Orwell");
			queryAutorCreation.executeUpdate();
			autoresID = queryAutorCreation.getGeneratedKeys();
			if (autoresID.next()) {

				try (PreparedStatement bookStatement = connection.prepareStatement(ADD_LIBRO)) {
					bookStatement.setString(1, "1984");
					bookStatement.setInt(2, autoresID.getInt(1));
					bookStatement.setString(3, "Reino Unido");
					bookStatement.setInt(4, 328);
					bookStatement.setString(5, "Distopia");
					bookStatement.executeUpdate();
				}
			}
			System.out.println("\n¡¡¡ BASE DE DATOS TEST REINICIADA !!!");
			turnToMenu(false);

		} catch (SQLException e) {
			System.out.println("Error createBasicDataForTesting: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * La función createDB es una función privada que se encarga de crear la base de
	 * datos si no existe y cambiar a esa base de datos en la conexión actual.
	 *
	 * En primer lugar, se ejecuta una sentencia para borrar la base de datos si ya
	 * existe para evitar conflictos y luego se crea la base de datos utilizando la
	 * sentencia "CREATE DATABASE IF NOT EXISTS " + JDBC_DDBB, donde JDBC_DDBB es
	 * una constante que almacena el nombre de la base de datos.
	 *
	 * A continuación, se utiliza la sentencia "USE " + JDBC_DDBB para cambiar la
	 * conexión actual a la nueva base de datos creada, lo que significa que todas
	 * las sentencias SQL posteriores serán ejecutadas en esa base de datos.
	 *
	 * En caso de que haya algún problema en la ejecución de estas sentencias SQL,
	 * se captura la excepción de tipo SQLException y se muestra un mensaje de error
	 * en la consola junto con la traza de la excepción.
	 */
	private void createDB() {
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate("DROP DATABASE IF EXISTS " + JDBC_DDBB);
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + JDBC_DDBB);
			statement.executeUpdate("USE " + JDBC_DDBB);
			statement.close();
		} catch (SQLException ex) {
			System.out.println("No se puede crear la base de datos: " + JDBC_DDBB);
			ex.printStackTrace(System.out);
		}
	}

	/**
	 * La función createTables() se encarga de crear las tablas necesarias para la
	 * base de datos libreria utilizada en la aplicación. La tabla autores contiene
	 * información sobre los autores, mientras que la tabla libros contiene
	 * información sobre los libros, como el título, el autor, el país de origen, el
	 * número de páginas y el género.
	 *
	 * La función comienza creando dos consultas de SQL que definen las tablas
	 * autores y libros. A continuación, elimina las tablas autores y libros si ya
	 * existen en la base de datos libreria. Finalmente, ejecuta las consultas de
	 * creación de tablas usando executeUpdate() del objeto Statement y cierra la
	 * conexión.
	 *
	 * La tabla autores tiene tres columnas: id_autor, nombre, y apellidos. La
	 * columna id_autor es una clave primaria que se autoincrementa y se utiliza
	 * para identificar de forma única a cada autor. Las columnas nombre y apellidos
	 * se utilizan para almacenar el nombre y los apellidos del autor.
	 *
	 * La tabla libros tiene seis columnas: id_libro, titulo, autor, pais, paginas y
	 * genero. La columna id_libro es una clave primaria que se autoincrementa y se
	 * utiliza para identificar de forma única a cada libro. La columna titulo
	 * almacena el título del libro, la columna autor es una clave foránea que se
	 * refiere a la columna id_autor de la tabla autores, la columna pais almacena
	 * el país de origen del libro, la columna paginas almacena el número de páginas
	 * del libro y la columna genero almacena el género literario del libro.
	 */
	private void createTables() {
		try (Statement statement = connection.createStatement()) {
			String queryTablaAutores = "CREATE TABLE IF NOT EXISTS `libreria`.`autores` "
					+ "(`id_autor` INT NOT NULL AUTO_INCREMENT, `nombre` VARCHAR(50) NULL, "
					+ "`apellidos` VARCHAR(100) NULL, PRIMARY KEY (`id_autor`))";

			String queryTablaLibros = "CREATE TABLE IF NOT EXISTS `libreria`.`libros` ("
					+ "  `id_libro` int NOT NULL AUTO_INCREMENT," + "  `titulo` varchar(250) DEFAULT NULL,"
					+ "  `autor` int DEFAULT NULL," + "  `pais` varchar(45) DEFAULT NULL,"
					+ "  `paginas` int DEFAULT NULL," + "  `genero` varchar(45) DEFAULT NULL,"
					+ "  PRIMARY KEY (`id_libro`)," + "  KEY `id_autor_idx` (`autor`),"
					+ "  CONSTRAINT `id_autorFK` FOREIGN KEY (`autor`) REFERENCES `autores` (`id_autor`) ON UPDATE CASCADE"
					+ ")";

			statement.executeUpdate("DROP TABLE IF EXISTS " + JDBC_TABLE_LIBROS);
			statement.executeUpdate("DROP TABLE IF EXISTS " + JDBC_TABLE_AUTORES);
			statement.executeUpdate(queryTablaAutores);
			statement.executeUpdate(queryTablaLibros);
			statement.close();
		} catch (SQLException ex) {
			System.out.println("No se puede crear tablas en: " + JDBC_DDBB);
			ex.printStackTrace(System.out);
		}

	}

	private final String JDBC_URL = "jdbc:mysql://localhost:3306";
	private final String JDBC_COMMU_OPT = "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private final String JDBC_USER = "root";
	private final String JDBC_PASSWORD = "Root";

	private final String JDBC_DDBB = "libreria";
	private final String JDBC_TABLE_AUTORES = "autores";
	private final String JDBC_TABLE_LIBROS = "libros";

	private final String ADD_AUTOR = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE_AUTORES
			+ " (nombre, apellidos) VALUES (?, ?)";

	private final String ADD_LIBRO = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE_LIBROS
			+ " (titulo, autor, pais, paginas, genero) " + "VALUES (?, ?, ?, ?, ?)";

	private Connection connection = null;
}
