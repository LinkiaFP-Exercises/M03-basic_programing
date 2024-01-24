package act05.ejercicio02.heladeria.model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Fauno Guazina
 */
public interface Vendible {

	// metodos solicitados por el ejercicio
	public double getPrecio();

	public void setPrecio(double precio);

	/**
	 * a variable currencyFormatter es una instancia de la clase NumberFormat de
	 * Java que se utiliza para formatear los valores numéricos como moneda en
	 * euros. Específicamente, la variable currencyFormatter utiliza el formato de
	 * moneda de España (es) y la región de España (ES), que utiliza el símbolo del
	 * euro (€) como su unidad monetaria.
	 * 
	 * Al utilizar esta variable, se puede formatear fácilmente los valores
	 * numéricos como moneda en euros, lo que resulta útil en el contexto de una
	 * aplicación bancaria como esta. Por ejemplo, si se tiene un valor numérico
	 * 123.45, se puede formatear como moneda utilizando la línea de código
	 * siguiente:
	 * {@code String formattedCurrency = currencyFormatter.format(123.45);} El
	 * resultado de la línea anterior sería una cadena de texto "123,45 €", que
	 * utiliza el formato de moneda de España y la región de España.
	 */
	public static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
}
