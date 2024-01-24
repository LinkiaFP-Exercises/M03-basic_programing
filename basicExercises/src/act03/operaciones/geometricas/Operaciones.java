package act03.operaciones.geometricas;

import static act03.auxiliary.auxiliaryMain.turnToMenu;
import static act03.introduceDatos.Pregunta.pideDouble;

public class Operaciones {

	/**
	 * Esta función calcula el seno de un ángulo en grados, utilizando la función
	 * {@code angleInDegreesAndRadians()} para obtener el ángulo en radianes y la
	 * función {@code printResultGeometric()} para imprimir el resultado.
	 * 
	 * Primero, se llama a la función {@code angleInDegreesAndRadians()} para
	 * obtener un ángulo en grados y convertirlo a radianes. Luego, se utiliza la
	 * función {@code Math.sin()} para calcular el coseno del ángulo en radianes.
	 * Finalmente, se llama a la función {@code printResultGeometric()} para
	 * imprimir el resultado en la consola.
	 * 
	 * @see #angleInDegreesAndRadians()
	 * @see #printResultGeometric(double[], double)
	 */
	public static void muestraSeno() {

		double[] angle = angleInDegreesAndRadians();
		double seno = Math.sin(angle[1]);
		printResultGeometric(angle, seno);
	}

	/**
	 * Esta función calcula el coseno de un ángulo en grados, utilizando la función
	 * {@code angleInDegreesAndRadians()} para obtener el ángulo en radianes y la
	 * función {@code printResultGeometric()} para imprimir el resultado.
	 * 
	 * Primero, se llama a la función {@code angleInDegreesAndRadians()} para
	 * obtener un ángulo en grados y convertirlo a radianes. Luego, se utiliza la
	 * función {@code Math.cos()} para calcular el coseno del ángulo en radianes.
	 * Finalmente, se llama a la función {@code printResultGeometric()} para
	 * imprimir el resultado en la consola.
	 * 
	 * @see #angleInDegreesAndRadians()
	 * @see #printResultGeometric(double[], double)
	 */
	public static void muestraCoseno() {

		double[] angle = angleInDegreesAndRadians();
		double coseno = Math.cos(angle[1]);
		printResultGeometric(angle, coseno);
	}

	/**
	 * Esta función es una función privada que devuelve un array de dos elementos.
	 * El propósito de esta función es solicitar al usuario que introduzca un ángulo
	 * en grados, validar que se encuentre entre 0 y 360 grados, y luego convertir
	 * ese ángulo en radianes. La función comienza definiendo una cadena de mensaje
	 * que se utilizará para solicitar al usuario que introduzca un ángulo en
	 * grados. Luego, crea un array de dos elementos inicializados con los valores
	 * "-1" y "0". El primer elemento, angle[0], se utilizará para almacenar el
	 * valor del ángulo en grados, mientras que el segundo elemento, angle[1], se
	 * utilizará para almacenar el valor del ángulo en radianes.
	 * 
	 * @return array "angle" que contiene el valor del ángulo en grados y radianes.
	 */
	private static double[] angleInDegreesAndRadians() {
		String msg = "Introduce un ángulo de 0 a 360° => ";

		double[] angle = { -1, 0 };

		while (angle[0] < 0 || angle[0] > 360) {
			angle[0] = pideDouble(msg);
		}

		angle[1] = Math.toRadians(angle[0]);

		return angle;
	}

	/**
	 * Esta función se encarga de imprimir el resultado de un cálculo
	 * trigonométrico, específicamente el seno o coseno de un ángulo en grados. Toma
	 * como entrada un arreglo de tipo double con dos elementos, el primero es el
	 * ángulo en grados y el segundo es el valor del seno o coseno del ángulo en
	 * radianes.
	 * 
	 * La función utiliza la función printf de Java para imprimir el resultado en un
	 * formato específico, donde se muestra el ángulo en grados con cero decimales y
	 * el valor del seno o coseno con dos decimales. Antes de imprimir el valor, se
	 * verifica si su valor absoluto es muy cercano a cero (es decir, si es un valor
	 * "casi" cero), en cuyo caso se considera que el valor es cero para evitar
	 * errores de redondeo.
	 * 
	 * Finalmente, la función llama a la función turnToMenu() para volver al menú
	 * principal después de imprimir el resultado.
	 * 
	 * @param angle      array que contiene el valor del ángulo en grados y
	 *                   radianes.
	 * @param senOrCosen valor del seno o coseno del ángulo.
	 */
	private static void printResultGeometric(double[] angle, double senOrCosen) {
		senOrCosen = (senOrCosen < 0.00001 && senOrCosen > -0.00001) ? 0 : senOrCosen;
		String result = "El seno de %.0f° es %.2f";
		System.out.printf(result, angle[0], senOrCosen);
		turnToMenu();
	}
}
