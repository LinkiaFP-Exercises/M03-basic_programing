package act06;

/**
 * Esta clase se llama ErrorLeerArchivo y es una clase que extiende de la clase
 * Exception, lo que significa que es una clase de excepción. La clase tiene un
 * constructor que toma un mensaje de error y lo pasa al constructor de la clase
 * base Exception utilizando la palabra clave super.
 * 
 * En resumen, esta clase se utiliza para lanzar una excepción personalizada
 * cuando hay un error al leer un archivo. Al extender la clase Exception, esta
 * excepción es una excepción comprobada, lo que significa que cualquier método
 * que llame a un método que lanza esta excepción debe manejarla o propagarla a
 * su vez.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 *
 */
public class ErrorLeerArchivo extends Exception {

	private static final long serialVersionUID = 1L;

	public ErrorLeerArchivo(String mensaje) {
		super(mensaje);
	}
}
