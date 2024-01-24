package act05.ejercicio02.heladeria.controler;

import static act05.ejercicio02.heladeria.controler.EncerrarComanda.cerrarComanda;
import static act05.ejercicio02.heladeria.controler.ModificarPedido.alterarIten;
import static act05.ejercicio02.heladeria.controler.ModificarPedido.borrarItem;
import static act05.ejercicio02.heladeria.controler.MuestraDetallaSeleccionaComanda.detallarComanda;
import static act05.ejercicio02.heladeria.controler.MuestraDetallaSeleccionaComanda.muestrarTodasComandas;
import static act05.ejercicio02.heladeria.controler.NuevoPedido.nuevoPedido;
import static act05.Utilidades.getScanner;
import static act05.Utilidades.pedirEntero;

import java.util.ArrayList;
import java.util.Arrays;

import act05.ejercicio02.heladeria.model.Cucurucho;
import act05.ejercicio02.heladeria.model.Horchata;
import act05.ejercicio02.heladeria.model.Loteria;
import act05.ejercicio02.heladeria.model.Vendible;
import act05.ejercicio02.heladeria.model.Cucurucho.cucuruchos;
import act05.ejercicio02.heladeria.model.Cucurucho.helados;
import act05.ejercicio02.heladeria.model.Horchata.horchatas;

/**
 * @author Fauno Guazina
 */
public class Controler {

	/**
	 * La función muestra un menú de opciones para el usuario y procesa su elección
	 * utilizando la sentencia {@code switch}. Además, se muestra una opción
	 * predeterminada en caso de que el usuario ingrese una opción inválida.
	 * 
	 * @see #printMenuInicial()
	 * @see #ejercicio6_PedidoBase()
	 * @see #turnToMenuInicial()
	 * @see #println()
	 * @see #separadorConTitulo()
	 */
	protected static void abrirChiringuito() {

		if (pedidos.isEmpty())
			ejercicio6_PedidoBase();

		printMenuInicial();

		switch (pedirEntero("QUE DESEA HACER de 0 a 5 => ")) {
		case 0 -> exitMsgPrint();
		case 1 -> muestrarTodasComandas(true);
		case 2 -> nuevoPedido(null);
		case 3 -> alterarIten();
		case 4 -> borrarItem();
		case 5 -> detallarComanda(true);
		case 6 -> cerrarComanda();
		default -> {
			println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
			turnToMenuInicial();
		}
		}
	}

	private static void printMenuInicial() {
		String menuInicial = """

				            ************ HELADERIA ***********
				            **********************************
				            ** [1] - Consultar Comandas     **
				            ** [2] - Nuevo Pedido           **
				            ** [3] - Alterar Iten           **
				            ** [4] - Borrar Iten            **
				            ** [5] - Detallar Comanda       **
				            ** [6] - Cerrar Comanda         **
				            ** [0] - Salir                  **
				            **********************************
				""";
		println(menuInicial);
	}

	/**
	 * La función cierra la intancia {@code Scanner} invocada por la función
	 * {@code getScanner} de la clase {@code Utilidades} del paquete
	 * {@code ejercicio01.cuentaCorriente}, posteriormente imprime un mensaje de
	 * salida al usuario cuando finaliza el programa, utilizando una cadena de
	 * texto.
	 */
	private static void exitMsgPrint() {

		getScanner().close();
		println("", separadorConTitulo("GRACIAS POR VENIR"));
	}

	/**
	 * La función imprime un mensaje para que el usuario pueda volver al menú
	 * principal del programa, y espera a que el usuario presione la tecla ENTER
	 * antes de llamar a la función {@code abrirChiringuito()} para volver al menú
	 * principal.
	 * 
	 * @see #abrirChiringuito()
	 */
	static final void turnToMenuInicial() {
		println("", separadorConTitulo("ENTER para volver al MENU"));
		getScanner().nextLine();
		abrirChiringuito();
	}

	/**
	 * Función hace stream del array VARARGS y para cada uno lo imprime en una línea
	 * 
	 * @param strings VARARGS para facilitar las multiples impresiones
	 */
	public static void println(String... strings) {
		Arrays.stream(strings).forEach(System.out::println);
	}

	/**
	 * La función separadorConTitulo recibe como parámetro un String titulo que se
	 * utiliza para generar un nuevo separador que incluye el título centrado en la
	 * parte superior del separador.
	 * 
	 * Para ello, la función calcula la mitad del separador (que es una constante
	 * definida previamente), le resta la longitud del título y divide el resultado
	 * entre dos para obtener la cantidad de asteriscos que deben preceder y seguir
	 * al título. Luego, en un ciclo for se recorre el separador original, y cuando
	 * se llega al punto medio de la resta del separador con la longitud del título,
	 * se inserta el título en el nuevo separador generado y se continua con el
	 * ciclo, agregando el resto de asteriscos faltantes. Finalmente, la función
	 * retorna el nuevo separador con el título centrado.
	 * 
	 * @param titulo String se quiera hacer de cabecera de menu
	 * @return string con el texto del argumento {@code titulo} dentro del
	 */
	public static String separadorConTitulo(String titulo) {
		int mitadRestaSeparadorTitulo = (separador.length() - titulo.length() - 2) / 2;
		String separadorConTitulo = prefix;

		for (int i = 0; i <= prefPlusSep.length(); i++) {
			if (i == mitadRestaSeparadorTitulo) {
				separadorConTitulo += " " + titulo + " ";
				i = separadorConTitulo.length();
			} else
				separadorConTitulo += "*";

		}

		return separadorConTitulo;
	}

	/**
	 * Función básica para cumplir con el ejercício 6 de la actividad. Llenar con un
	 * pedido mínimo para poder averiguar el funcionamiento del programa.
	 */
	private static void ejercicio6_PedidoBase() {
		ArrayList<Vendible> pedidoBase = new ArrayList<Vendible>();
		pedidoBase.add(new Loteria(3.5));
		pedidoBase.add(new Horchata(horchatas.Tradicional, 250));
		pedidoBase.add(new Cucurucho(cucuruchos.Galleta, helados.Vainilla, helados.Chocolate));
		pedidoBase.add(new Cucurucho(cucuruchos.Galleta, helados.Cookies, helados.Fresa));
		pedidos.add(pedidoBase);
		pedidoBase = new ArrayList<Vendible>();
		pedidoBase.add(new Loteria(7.25));
		pedidoBase.add(new Loteria(3.50));
		pedidoBase.add(new Horchata(horchatas.Plus, 300));
		pedidoBase.add(new Cucurucho(cucuruchos.Chocolate, helados.Cookies, helados.Chocolate));
		pedidoBase.add(new Cucurucho(cucuruchos.Galleta, helados.Vainilla, helados.Fresa));
		pedidos.add(pedidoBase);

	}

	/**
	 * ArrayList que guarda ArrayLists de pedidos, he idelaizado como si cada
	 * Arraylist<Vendibles> fuera una comanda, y este array {@code pedidos} armazena
	 * las comandas.
	 */
	static final ArrayList<ArrayList<Vendible>> pedidos = new ArrayList<ArrayList<Vendible>>();

	// Variables de gestión visual para apresentar los menus
	static final String separador = "**********************************";
	static final String prefix = "            ";
	static final String prefPlusSep = prefix + separador;
}
