package act03.operaciones;

import static act03.introduceDatos.Pregunta.pideEntero;
import static act03.auxiliary.auxiliaryMain.turnToMenu;
import static act03.introduceDatos.Pregunta.pideDouble;
import java.text.DecimalFormat;

public final class Valores {

	/**
	 * 
	 * Muestra el valor de PI con el número de decimales especificado por el
	 * usuario.
	 * 
	 * Si el número de decimales está fuera del rango permitido (2-15), se ajusta al
	 * valor más cercano dentro del rango.
	 * 
	 * Después de mostrar el resultado, vuelve al menú principal.
	 */
	public static final void muestraPI() {
		int manyDecimalValue = pideEntero("Cuantos decimales desea en PI, de 2 a 15? ");

		// Verifica si el número de decimales está fuera del rango permitido
		boolean decimalCondition = manyDecimalValue < 2 || manyDecimalValue > 15;

		// Si está fuera del rango, muestra un mensaje de error
		if (decimalCondition)
			System.out.println("¡¡¡Lo siento el rango es de 2 a 15!!!");

		// Ternario para ajustar el valor dentro del rango
		manyDecimalValue = (decimalCondition) ? ((manyDecimalValue < 2) ? 2 : 15) : manyDecimalValue;

		String result = "Aqui tienes PI con " + manyDecimalValue + " decimales: " + piDecimalFormat(manyDecimalValue);
		System.out.println(result);

		turnToMenu();
	}

	/**
	 * Esta función toma un valor entero como entrada y devuelve una cadena de texto
	 * formateada que representa el valor de PI con el número de decimales
	 * especificados por el valor entero de entrada.
	 * 
	 * @param decimal el número de decimales que se desean mostrar de PI.
	 * @return una cadena de texto formateada que representa el valor de PI con el
	 *         número de decimales especificados
	 */
	private static String piDecimalFormat(int decimal) {

		String format = "#.##";
		for (int i = 2; i < decimal; i++) {
			format += "#";
		}
		return new DecimalFormat(format).format(Math.PI);
	}

	/**
	 * Muestra el valor absoluto de un número ingresado por el usuario. Si el
	 * usuario ingresa un número negativo, se devuelve su valor positivo. Después de
	 * mostrar el resultado, se llama a la función turnToMenu para volver al menú
	 * principal.
	 */
	public static void muestraValorAbsoluto() {

		String cuestion = "Elije un numero para saber su Valor Absoluto => ";
		double userValue = pideDouble(cuestion, true);

		// ternario para simular la función Math.abs()
		double absoluteValue = (userValue <= 0) ? 0 - userValue : userValue;
		System.out.println("El valor absoluto de " + userValue + " es: " + absoluteValue);
		turnToMenu();
	}

	/**
	 * Esta función genera un número aleatorio entre 0 y el número proporcionado por
	 * el usuario.
	 * 
	 * la línea 104 : Este código genera un número entero aleatorio entre 0 y
	 * {@code greaterRandom} (ambos inclusive) utilizando el método
	 * {@code Math.random()} de Java, que devuelve un número decimal aleatorio entre
	 * 0 y 1. Luego, se multiplica este número por {@code greaterRandom + 1} y se
	 * convierte el resultado en un entero mediante el casting explícito
	 * {@code (int)}. El resultado final es un número entero aleatorio dentro del
	 * rango especificado por el usuario.
	 */
	public static void muestraValorAleatorio() {

		String cuestion = "Vamos de aleatorios, dame numero techo => ";
		int greaterRandom = pideEntero(cuestion);
		int randonChoice = (int) (Math.random() * (greaterRandom + 1));
		System.out.println("Aqui tienes el: " + randonChoice + ", un aleatorio entre 0 y " + greaterRandom);
		turnToMenu();
	}
}
