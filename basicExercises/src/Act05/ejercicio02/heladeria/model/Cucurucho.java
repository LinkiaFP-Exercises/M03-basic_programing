package act05.ejercicio02.heladeria.model;

import static act05.ejercicio02.heladeria.controler.Controler.println;
import static act05.ejercicio02.heladeria.controler.Controler.separadorConTitulo;
import static act05.Utilidades.pedirEntero;

/**
 * @author Fauno Guazina
 */
public final class Cucurucho extends Comida {

	// VARIABLES PRIVADAS POR ENCAPSULAMIENTO
	private final helados[] saboresHelado;
	private final cucuruchos cucurucho;

	// CONSTRUCTOR QUE LLAMA A LA CLASE MADRE
	public Cucurucho(cucuruchos cucurucho, int cantidadBolas) {
		super("Cucurucho", cucurucho.name(), cucurucho.precioBase);
		this.cucurucho = cucurucho;
		this.saboresHelado = new helados[cantidadBolas];
		addBolaHelado();
		calculaPrecioTotal();
	}

	// SOBRECARGA DE CONSTRUCTOR PARA CREAR LOS DATOS DE PRUEBA
	// EN LA FUNCIÓN AuxiliaryMain.printStatusBillsWithSeparators();
	public Cucurucho(cucuruchos cucurucho, helados... helados) {
		super("Cucurucho", cucurucho.name(), cucurucho.precioBase);
		this.cucurucho = cucurucho;
		this.saboresHelado = helados;
		calculaPrecioTotal();
	}

	// GETTERS & SETTERS

	public final helados[] getSaboresHelado() {
		return saboresHelado;
	}

	public final cucuruchos getCucurucho() {
		return cucurucho;
	}

	public final String getPrecioFormated() {
		return currencyFormatter.format(getPrecio());
	}

	@Override
	public String toString() {
		return getProducto() + " de " + getNombre() + " (" + cucurucho.kcal + "kcal) por "
				+ currencyFormatter.format(cucurucho.precioBase) + " y " + saboresHelado.length + " bolas de helado:\n"
				+ heladoDetailsToString() + "\n>>>>>>>> SUMANDO EL PRECIO DE " + getPrecioFormated();
	}

	/**
	 * Esta función heladoDetailsToString() es utilizada para generar una cadena de
	 * texto que contiene información detallada sobre el helado, como el sabor,
	 * información nutricional y precio. La función usa un objeto StringBuilder para
	 * construir gradualmente la cadena de texto.
	 * 
	 * La función recorre el arreglo saboresHelado que contiene las bolas de helado
	 * y para cada bola, agrega su información correspondiente en el StringBuilder.
	 * Cada línea de información sobre la bola del helado incluye el número de la
	 * bola, el sabor del helado, su información nutricional, su precio, y si hay
	 * más bolas de helado, una nueva línea.
	 * 
	 * Finalmente, la función devuelve la cadena de texto generada por el objeto
	 * StringBuilder.
	 * 
	 * @return string con infos de los helados añadidos al objeto Cucurucho.
	 */
	private String heladoDetailsToString() {
		StringBuilder infoHelado = new StringBuilder();

		for (int i = 0; i < saboresHelado.length; i++) {
			infoHelado.append(" " + (i + 1) + "º > " + saboresHelado[i].name());
			infoHelado.append(" con " + saboresHelado[i].info);
			infoHelado.append(" (" + saboresHelado[i].kcal + "kcal)");
			infoHelado.append(" por " + currencyFormatter.format(saboresHelado[i].precio));
			if (i < saboresHelado.length - 1)
				infoHelado.append("\n");

		}

		return infoHelado.toString();

	}

	/**
	 * Esta función se encarga de calcular el precio total de un cucurucho de
	 * helado, tomando en cuenta su precio base y el precio de los sabores de helado
	 * que se le han agregado. Primero se inicializa la variable precioTotal con el
	 * valor del precio base del cucurucho (this.getPrecio()). Luego se recorre la
	 * lista de sabores de helado (saboresHelado) y se suma el precio de cada uno de
	 * ellos a precioTotal. Finalmente, se llama al método setPrecio para actualizar
	 * el precio total del cucurucho con el valor calculado.
	 */
	private void calculaPrecioTotal() {
		double precioTotal = this.getPrecio();
		for (helados h : saboresHelado) {
			precioTotal += h.precio;
		}
		this.setPrecio(precioTotal);
	}

	/**
	 * Esta función permite agregar bolas de helado al cucurucho. Comienza pidiendo
	 * al usuario que elija entre los sabores de helado disponibles y va guardando
	 * la elección en un array de objetos de helados llamado "saboresHelado".
	 * 
	 * Primero se muestra la lista de helados disponibles con la función
	 * "listarHelados()", luego, en un bucle for, se itera sobre la cantidad total
	 * de helados que se pueden agregar al cucurucho y se le pide al usuario que
	 * elija el helado correspondiente, validando que la elección esté entre 1 y 4.
	 * 
	 * Luego, la función "guardaHelado()" se encarga de guardar la elección del
	 * usuario en el array "saboresHelado".
	 */
	private void addBolaHelado() {
		int elecionHelado;
		int totalHelado = saboresHelado.length;
		String statement;
		listarHelados();
		for (int i = 0; i < totalHelado; i++) {
			do {
				statement = "ELIJA EL " + (i + 1) + "º de " + totalHelado + " => ";
				elecionHelado = pedirEntero(statement);
				if (elecionHelado < 1 || elecionHelado > 4)
					System.out.println("¡¡¡ ELIJE DE 1 a 4 !!!");
			} while (elecionHelado < 1 || elecionHelado > 4);
			guardaHelado(elecionHelado, i);
		}
	}

	/**
	 * Simple menu de helados
	 */
	private void listarHelados() {
		String menuNuevoPedido = """
				            **********************************
				            ** [1] - Chocolate              **
				            ** [2] - Fresa                  **
				            ** [3] - Cookies                **
				            ** [4] - Vainilla               **
				            **********************************
				""";
		println("", separadorConTitulo("ELIJE EL HELADO"), menuNuevoPedido);

	}

	/**
	 * Esta función recibe dos parámetros: el primero es un número entero que
	 * representa el sabor de helado elegido (1 para Chocolate, 2 para Fresa, 3 para
	 * Cookies y 4 para Vainilla), y el segundo es un número entero que indica la
	 * posición en la que se debe guardar ese sabor de helado dentro del array de
	 * sabores de helado (saboresHelado) del objeto Cucurucho.
	 * 
	 * La función utiliza un switch para asignar el valor correspondiente al sabor
	 * de helado elegido a la posición indicada dentro del array saboresHelado. Si
	 * el valor de helado es 1, se guarda en la posición indicada el valor
	 * helados.Chocolate, si es 2 se guarda el valor helados.Fresa, si es 3 se
	 * guarda el valor helados.Cookies, y si es 4 se guarda el valor
	 * helados.Vainilla.
	 * 
	 * @param helado   elección hecha en el menu {@code listarHelados()}
	 * @param posicion posición del array {@code saboresHelado}
	 */
	private void guardaHelado(int helado, int posicion) {
		switch (helado) {
		case 1 -> saboresHelado[posicion] = helados.Chocolate;
		case 2 -> saboresHelado[posicion] = helados.Fresa;
		case 3 -> saboresHelado[posicion] = helados.Cookies;
		case 4 -> saboresHelado[posicion] = helados.Vainilla;
		}
	}

	/**
	 * En Java, una enum (enumeration) es un tipo de dato que representa un conjunto
	 * de constantes con nombre. En este caso, se ha creado una enum llamada
	 * "cucuruchos" que tiene dos valores posibles: "Galleta" y "Chocolate". Cada
	 * uno de estos valores tiene asociado un precio base y una cantidad de
	 * calorías, que se han definido como atributos de la enum.
	 * 
	 * Cada constante de la enum se define como un objeto de la misma, y se
	 * especifican sus valores mediante un constructor privado. En este caso, el
	 * constructor toma dos parámetros: el precio base y la cantidad de calorías,
	 * que se asignan a los atributos correspondientes.
	 * 
	 * @author Fauno Guazina
	 */
	public enum cucuruchos {
		Galleta(1, 20), Chocolate(1.5, 30);

		double precioBase;
		int kcal;

		private cucuruchos(double precioBase, int kcal) {
			this.precioBase = precioBase;
			this.kcal = kcal;
		}
	}

	/**
	 * Este es otro ejemplo de una enumeración en Java, en este caso se define un
	 * conjunto de valores posibles para la clase helados. En la definición de la
	 * enumeración, cada valor posible es un objeto de la clase helados. Cada objeto
	 * tiene tres atributos: precio, kcal e info.
	 * 
	 * Al igual que la enumeración cucuruchos, esta enumeración también tiene su
	 * propio constructor privado que se llama para inicializar cada objeto de la
	 * enumeración. En este caso, el constructor tiene tres parámetros para
	 * establecer los valores de precio, kcal e info de cada objeto.
	 * 
	 * En resumen, esta enumeración define los diferentes sabores de helado que se
	 * pueden ofrecer en la heladería, junto con su precio, contenido calórico e
	 * información adicional sobre los ingredientes y su composición.
	 * 
	 * @author Fauno Guazina
	 */
	public enum helados {
		Chocolate(1, 20, "15% grasa y aspartamo"), Fresa(1.5, 15, "5% grasa y aspartamo"),
		Cookies(2, 50, "20% grasa y azúcar"), Vainilla(1, 30, "15% grasa y azúcar");

		double precio;
		int kcal;
		String info;

		private helados(double precio, int kcal, String info) {
			this.precio = precio;
			this.kcal = kcal;
			this.info = info;
		}
	}
}
