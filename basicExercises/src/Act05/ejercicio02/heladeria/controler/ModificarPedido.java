package act05.ejercicio02.heladeria.controler;

import static act05.ejercicio02.heladeria.controler.Controler.abrirChiringuito;
import static act05.ejercicio02.heladeria.controler.Controler.println;
import static act05.ejercicio02.heladeria.controler.Controler.separadorConTitulo;
import static act05.ejercicio02.heladeria.controler.Controler.turnToMenuInicial;
import static act05.ejercicio02.heladeria.controler.MuestraDetallaSeleccionaComanda.detallarComanda;
import static act05.ejercicio02.heladeria.controler.NuevoPedido.nuevaHorchata;
import static act05.ejercicio02.heladeria.controler.NuevoPedido.nuevaLoteria;
import static act05.ejercicio02.heladeria.controler.NuevoPedido.nuevoCucurucho;
import static act05.ejercicio02.heladeria.controler.NuevoPedido.printMenu_NuevoPedido;
import static act05.Utilidades.pedirEntero;

import java.util.ArrayList;

import act05.ejercicio02.heladeria.model.Vendible;

/**
 * @author Fauno Guazina
 */
public class ModificarPedido {

	/**
	 * Esta función es para eliminar un elemento de la comanda actual. Primero,
	 * muestra una lista detallada de los elementos de la comanda mediante la
	 * función detallarComanda(). Luego, pide al usuario que elija el índice del
	 * elemento a eliminar de la comanda mediante la función
	 * elegirPosicionEnComanda(). Una vez que se ha seleccionado el índice del
	 * elemento a eliminar, se utiliza el método remove() para eliminar el elemento
	 * de la lista comanda. Finalmente, se llama a turnToMenuInicial() para volver
	 * al menú principal del programa.
	 */
	public static void borrarItem() {
		println(separadorConTitulo("BORRAR ITEN"));

		ArrayList<Vendible> comanda = detallarComanda(false);

		String statement = "\nCUAL ITEN DESEA ELIMINAR DE 1 a " + comanda.size() + " => ";

		int selectIten = elegirPosicionEnComanda(statement, comanda);

		selectIten -= 1; // ajuste del array

		comanda.remove(selectIten);

		turnToMenuInicial();

	}

	/**
	 * Esta función permite al usuario alterar un item existente en una comanda.
	 * Primero, se llama a la función detallarComanda para mostrar todos los items
	 * en la comanda seleccionada. Luego, se pide al usuario que seleccione el item
	 * que desea alterar ingresando el número correspondiente. Después de eso, se
	 * llama a la función nuevoItem, que presenta un menú para que el usuario
	 * seleccione un nuevo Vendible que reemplazará el Vendible existente en la
	 * posición seleccionada en la comanda. Finalmente, se llama a la función
	 * turnToMenuInicial para volver al menú principal.
	 */
	public static void alterarIten() {
		println(separadorConTitulo("ALTERAR PEDIDO"));

		ArrayList<Vendible> comanda = detallarComanda(false);

		String statement = "\nCUAL ITEN DESEA ALTERAR DE 1 a " + comanda.size() + " => ";

		int selectIten = elegirPosicionEnComanda(statement, comanda);

		selectIten -= 1; // ajuste del array

		nuevoItem(comanda, selectIten);

		turnToMenuInicial();

	}

	/**
	 * Esta función permite agregar un nuevo item a una comanda ya existente. Recibe
	 * como parámetros la lista de vendibles que conforman la comanda y la posición
	 * del ítem al que se le quiere agregar un nuevo producto.
	 * 
	 * Primero, llama a la función printMenu_NuevoPedido() que muestra las opciones
	 * para agregar un nuevo producto a la comanda.
	 * 
	 * Luego, espera la entrada del usuario y utiliza un switch para determinar la
	 * opción elegida. Si el usuario elige la opción 0, se llama a la función
	 * abrirChiringuito() para volver al menú principal. Si elige la opción 1, se
	 * llama a la función nuevaLoteria() para agregar un nuevo producto de tipo
	 * lotería a la comanda. Si elige la opción 2, se llama a la función
	 * nuevaHorchata() para agregar una nueva bebida de tipo horchata a la comanda.
	 * Si elige la opción 3, se llama a la función nuevoCucurucho() para agregar un
	 * nuevo producto de tipo cucurucho a la comanda.
	 * 
	 * Si la opción ingresada por el usuario no es válida, se muestra un mensaje de
	 * error y se vuelve a llamar a la función nuevoItem() para que el usuario
	 * vuelva a elegir una opción válida.
	 * 
	 * @param comanda    sobre la cual vá actuar el cambio de produto
	 * @param selectIten posición en la Lista de Vendible que debe efectuar la
	 *                   substituición.
	 */
	private static void nuevoItem(ArrayList<Vendible> comanda, int selectIten) {

		printMenu_NuevoPedido();

		switch (pedirEntero("QUE DESEA HACER de 0 a 3 => ")) {
		case 0 -> abrirChiringuito();
		case 1 -> nuevaLoteria(comanda, selectIten);
		case 2 -> nuevaHorchata(comanda, selectIten);
		case 3 -> nuevoCucurucho(comanda, selectIten);
		default -> {
			println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
			nuevoItem(comanda, selectIten);
		}
		}

	}

	/**
	 * Esta función permite al usuario elegir una posición específica de un iten en
	 * una comanda existente. Primero, inicializa la variable pedidoSelecionado en
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
	private static int elegirPosicionEnComanda(String statement, ArrayList<Vendible> comanda) {

		int pedidoSelecionado = -1;

		while (pedidoSelecionado < 0 || pedidoSelecionado > comanda.size()) {
			pedidoSelecionado = pedirEntero(statement);
			if (pedidoSelecionado < 0 || pedidoSelecionado > comanda.size())
				println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
		}
		return pedidoSelecionado;
	}

}
