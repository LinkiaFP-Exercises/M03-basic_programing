package act05.ejercicio02.heladeria.controler;

import static act05.ejercicio02.heladeria.controler.Controler.pedidos;
import static act05.ejercicio02.heladeria.controler.Controler.prefPlusSep;
import static act05.ejercicio02.heladeria.controler.Controler.println;
import static act05.ejercicio02.heladeria.controler.Controler.separadorConTitulo;
import static act05.ejercicio02.heladeria.controler.Controler.turnToMenuInicial;
import static act05.Utilidades.pedirEntero;

import java.util.ArrayList;

import act05.ejercicio02.heladeria.model.Vendible;

/**
 * @author Fauno Guazina
 */
public class MuestraDetallaSeleccionaComanda {

	/**
	 * Esta función muestra todas las comandas abiertas en la heladería. Toma un
	 * parámetro booleano llamado "turnToMenu" que determina si después de mostrar
	 * las comandas, se debe volver al menú principal o no.
	 * 
	 * Primero, la función imprime una cadena vacía y dos líneas separadoras con el
	 * título "COMANDAS" y "Hay [número de comandas abiertas] Abiertas",
	 * respectivamente. Luego, utiliza un bucle for para iterar a través de todas
	 * las comandas abiertas en la lista de pedidos. Para cada comanda, imprime un
	 * separador con el título "[número de comanda] [número de elementos vendibles]
	 * Itens Vendibles". Después de iterar a través de todas las comandas, la
	 * función imprime otra línea separadora.
	 * 
	 * Si el parámetro "turnToMenu" es verdadero, la función llama a la función
	 * "turnToMenuInicial()" que lleva al usuario de vuelta al menú principal de la
	 * heladería. En resumen, esta función es útil para que el personal de la
	 * heladería pueda ver rápidamente todas las comandas abiertas y decidir qué
	 * hacer a continuación.
	 * 
	 * @param turnToMenu
	 */
	static void muestrarTodasComandas(boolean turnToMenu) {
		println("", separadorConTitulo("COMANDAS"), separadorConTitulo("Hay " + pedidos.size() + " Abiertas"));
		for (int i = 0; i < pedidos.size(); i++) {
			println(separadorConTitulo("[" + (i + 1) + "] " + pedidos.get(i).size() + " Itens Vendibles"));
		}
		println(prefPlusSep);
		if (turnToMenu)
			turnToMenuInicial();
	}

	/**
	 * La función detallarComanda tiene como objetivo mostrar los detalles de una
	 * comanda seleccionada por el usuario. Primero, llama a la función
	 * muestrarTodasComandas(false) para mostrar todas las comandas abiertas sin
	 * volver al menú principal. Luego, llama a la función
	 * elegirPosicionDeComandas() para que el usuario seleccione la comanda que
	 * desea detallar.
	 * 
	 * A continuación, se utiliza el valor seleccionado por el usuario para obtener
	 * la comanda correspondiente a través del método get() del objeto pedidos. Se
	 * ajusta el índice de la posición del array restando uno para que sea coherente
	 * con la numeración que se muestra al usuario. Luego, se muestra en pantalla el
	 * detalle de la comanda, iterando sobre cada uno de los elementos de la comanda
	 * y mostrando su información mediante el método println().
	 * 
	 * Finalmente, se llama a la función turnToMenuInicial() si turnToMenu es true,
	 * lo que significa que el programa volverá al menú principal después de mostrar
	 * los detalles de la comanda. Se devuelve la comanda como un objeto ArrayList
	 * de Vendible.
	 * 
	 * @param turnToMenu booleano para eligir si vuelve al menu principal
	 * @return ArrayList<Vendible> con la comanda
	 */
	static ArrayList<Vendible> detallarComanda(boolean turnToMenu) {
		muestrarTodasComandas(false);

		int pedidoSelecionado = elegirPosicionDeComandas();

		pedidoSelecionado -= 1; // ajuste antes del uso de la posición del array
		ArrayList<Vendible> comanda = pedidos.get(pedidoSelecionado);
		pedidoSelecionado += 1; // ajuste después del uso de la posición del array

		println("", separadorConTitulo("PEDIDO Nº" + (pedidoSelecionado)), "");
		int i = 1;
		for (Vendible v : comanda) {
			println("Iten[" + i++ + "] " + v, "");
		}
		println(separadorConTitulo("FIN PEDIDO Nº" + (pedidoSelecionado)));

		if (turnToMenu)
			turnToMenuInicial();

		return comanda;
	}

	/**
	 * Esta función es parte de la gestión de comandas de la heladería.
	 * selectComanda() permite al usuario seleccionar una comanda de la lista de
	 * comandas abiertas. Primero, llama a la función muestrarTodasComandas(false)
	 * para mostrar todas las comandas abiertas en pantalla. Luego, llama a
	 * elegirPosicionDeComandas() para que el usuario seleccione una comanda en
	 * particular. Por último, devuelve la lista de Vendible correspondiente a la
	 * comanda seleccionada.
	 * 
	 * @return ArrayList<Vendible> con la comanda
	 */
	static ArrayList<Vendible> selectComanda() {
		muestrarTodasComandas(false);

		int pedidoSelecionado = elegirPosicionDeComandas();

		return pedidos.get(pedidoSelecionado);
	}

	/**
	 * Esta función permite al usuario elegir una posición específica de una lista
	 * de comandas existentes. Primero, inicializa la variable pedidoSelecionado en
	 * -1. Luego, se ejecuta un bucle while que seguirá ejecutándose mientras el
	 * valor de pedidoSelecionado sea menor que cero o mayor que el tamaño de la
	 * lista pedidos. Dentro del bucle, se solicita al usuario que ingrese un número
	 * entero utilizando la función pedirEntero(). Si el número ingresado está fuera
	 * del rango válido, se imprime un mensaje de error. Si el número es válido, la
	 * función devuelve ese valor como la posición elegida. En resumen, la función
	 * permite al usuario elegir una posición válida dentro de una lista de comandas
	 * existentes.
	 * 
	 * @return int de la posición del menu de comandas que debe ser restado -1 para
	 *         utilizar en la posición del array
	 */
	private static int elegirPosicionDeComandas() {

		int pedidoSelecionado = -1;

		while (pedidoSelecionado < 0 || pedidoSelecionado > pedidos.size()) {
			pedidoSelecionado = pedirEntero("\nCUAL QUIERE de 1 a " + pedidos.size() + " => ");
			if (pedidoSelecionado < 0 || pedidoSelecionado > pedidos.size())
				println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
		}
		return pedidoSelecionado;
	}
}
