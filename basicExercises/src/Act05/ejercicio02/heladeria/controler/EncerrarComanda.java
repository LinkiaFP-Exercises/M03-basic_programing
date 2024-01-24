package act05.ejercicio02.heladeria.controler;

import static act05.ejercicio02.heladeria.controler.Controler.prefPlusSep;
import static act05.ejercicio02.heladeria.controler.Controler.println;
import static act05.ejercicio02.heladeria.controler.Controler.separadorConTitulo;
import static act05.ejercicio02.heladeria.controler.Controler.turnToMenuInicial;
import static act05.ejercicio02.heladeria.controler.MuestraDetallaSeleccionaComanda.detallarComanda;

import java.util.ArrayList;

import act05.ejercicio02.heladeria.model.Vendible;

/**
 * @author Fauno Guazina
 */
public class EncerrarComanda {

	/**
	 * La función cerrarComanda cierra una comanda, es decir, muestra los detalles
	 * de la comanda y calcula el valor total de la misma. Primero, se muestra el
	 * título "CERRAR COMANDA" utilizando la función separadorConTitulo. Luego, se
	 * llama a la función detallarComanda para mostrar los detalles de la comanda y
	 * guardarlos en la variable comanda.
	 * 
	 * Después, se inicializa la variable valorTotalComanda en cero y se recorre la
	 * lista comanda para sumar el precio de cada Vendible y agregarlo a
	 * valorTotalComanda. Luego, se formatea valorTotalComanda como una cadena de
	 * texto utilizando el formateador de moneda de Vendible y se muestra el valor
	 * total utilizando la función separadorConTitulo.
	 * 
	 * Finalmente, se llama a turnToMenuInicial para volver al menú principal.
	 */
	public static void cerrarComanda() {
		println(separadorConTitulo("CERRAR COMANDA"));

		ArrayList<Vendible> comanda = detallarComanda(false);

		double valorTotalComanda = 0;

		for (Vendible v : comanda) {
			valorTotalComanda += v.getPrecio();
		}

		String valorFormatado = Vendible.currencyFormatter.format(valorTotalComanda);

		println(separadorConTitulo("TOTAL A PAGAR"), separadorConTitulo(valorFormatado), prefPlusSep);

		turnToMenuInicial();
	}
}
