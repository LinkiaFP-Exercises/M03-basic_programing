package act05.ejercicio02.heladeria.model;

/**
 * @author Fauno Guazina
 */
public class Loteria implements Vendible {

	// variables basicas
	private double precio;
	private String numero;

	// constructor
	public Loteria(double precio) {
		setNumero(); // me pareció mas divertido hacer aleatório
		this.precio = precio;
	}

	// GETTERS Y SETTERS

	public final String getNumero() {
		return this.numero;
	}

	/**
	 * Esta función se encarga de generar un número de loteria aleatorio de 5
	 * dígitos para una instancia de la clase Loteria. Primero, genera un número
	 * aleatorio entre 0 y 1 y lo multiplica por 100000, lo que dará como resultado
	 * un número entero entre 0 y 99999. Luego, convierte este número entero a un
	 * String usando el método valueOf() de la clase String.
	 * 
	 * A continuación, se verifica si el String generado tiene menos de 5
	 * caracteres, lo que significa que no tiene suficientes dígitos. En este caso,
	 * se agrega un cero al principio del String. Este proceso se repite hasta que
	 * el String tenga exactamente 5 caracteres.
	 * 
	 * Finalmente, se asigna el String generado como el número de loteria de la
	 * instancia de la clase Loteria en la que se está ejecutando la función.
	 */
	public final void setNumero() {
		String numeroRandon = String.valueOf(((int) (Math.random() * 100000)));
		while (numeroRandon.length() < 5) {
			numeroRandon = "0" + numeroRandon;
		}
		this.numero = numeroRandon;
	}

	// implementación de métodos de la interface Vendible
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public final String getPrecioFormated() {
		return currencyFormatter.format(getPrecio());
	}

	@Override
	public String toString() {
		return "Loteria Nº" + numero + "\n>>>>>>>> POR EL PRECIO DE " + getPrecioFormated();
	}

}
