package act03.operaciones;

import java.text.DecimalFormat;

import static act03.auxiliary.auxiliaryMain.turnToMenu;
import static act03.introduceDatos.Pregunta.pideDouble;

public final class OperacionesLinkia {

	/**
	 * La función convierte un valor en euros a su equivalente en LinkiaCoins
	 * utilizando una cotización generada al azar. Se solicita al usuario que
	 * introduzca el valor en euros que desea convertir, y se muestra el resultado
	 * de la conversión en la pantalla junto con un mensaje que indica la cotización
	 * utilizada. Finalmente, se devuelve al usuario al menú principal.
	 */
	public static void convertirLinkiaCoins() {
		double quotationValue = 1 + Math.random();
		System.out.println("\nCotización LinkiaCoin => 1€ para " + twoDecimal(quotationValue) + "Lc");
		double valueToConvert = pideDouble("Cuanto desea convertir ahora? => ");
		System.out.println("TU SALDO EN LinkiaCoins ES DE: " + twoDecimal(valueToConvert * quotationValue));
		turnToMenu();
	}

	/**
	 * La función toma un número de punto flotante {@code valueToFormat} como
	 * entrada y devuelve una cadena de caracteres que representa el número
	 * formateado con dos decimales. Se utiliza un objeto {@code DecimalFormat} para
	 * aplicar el formato adecuado.
	 * 
	 * @param valueToFormat El número de punto flotante a formatear.
	 * @return Una cadena de caracteres que representa el número formateado con dos
	 *         decimales.
	 */
	private static String twoDecimal(double valueToFormat) {
		return new DecimalFormat("#.##").format(valueToFormat);
	}

}
