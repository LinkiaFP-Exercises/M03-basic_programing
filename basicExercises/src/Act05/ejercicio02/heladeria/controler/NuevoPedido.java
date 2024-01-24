package act05.ejercicio02.heladeria.controler;

import static act05.ejercicio02.heladeria.controler.Controler.abrirChiringuito;
import static act05.ejercicio02.heladeria.controler.Controler.pedidos;
import static act05.ejercicio02.heladeria.controler.Controler.println;
import static act05.ejercicio02.heladeria.controler.Controler.separadorConTitulo;
import static act05.ejercicio02.heladeria.controler.MuestraDetallaSeleccionaComanda.selectComanda;
import static act05.Utilidades.pedirDecimal;
import static act05.Utilidades.pedirEntero;

import java.util.ArrayList;

import act05.ejercicio02.heladeria.model.Cucurucho;
import act05.ejercicio02.heladeria.model.Horchata;
import act05.ejercicio02.heladeria.model.Loteria;
import act05.ejercicio02.heladeria.model.Vendible;
import act05.ejercicio02.heladeria.model.Cucurucho.cucuruchos;
import act05.ejercicio02.heladeria.model.Horchata.horchatas;

/**
 * @author Fauno Guazina
 */
public class NuevoPedido {

	/**
	 * La función nuevoPedido recibe como parámetro una lista de objetos Vendible
	 * llamada comanda. Si comanda es null, se llama a la función
	 * elegirComanda_Nueva_o_Existente que muestra un menú para que el usuario elija
	 * entre crear una nueva comanda o seleccionar una existente. La función retorna
	 * la comanda seleccionada o la comanda nueva creada.
	 * 
	 * Luego, la función muestra un menú para que el usuario elija entre agregar un
	 * nuevo ítem a la comanda o volver al menu principal. Dependiendo de la opción
	 * elegida por el usuario, se llamará a las funciones nuevaLoteria,
	 * nuevaHorchata o nuevoCucurucho, las cuales agregan un nuevo objeto Vendible a
	 * la comanda.
	 * 
	 * Al final, si la comanda era nueva, se agrega a la lista de comandas (pedidos)
	 * y llama la función addMasPedidosEstaComanda_o_TurnToMenuInicial que indaga si
	 * quiere seguir añadiendo pedidos a esta comanda o volver al menú principal.
	 * 
	 * @param comanda ArrayList<Vendible>
	 */
	static void nuevoPedido(ArrayList<Vendible> comanda) {

		if (comanda == null)
			comanda = elegirComanda_Nueva_o_Existente();

		boolean nuevaComanda = (comanda.isEmpty()) ? true : false;

		printMenu_NuevoPedido();

		switch (pedirEntero("QUE DESEA HACER de 0 a 3 => ")) {
		case 0 -> abrirChiringuito();
		case 1 -> nuevaLoteria(comanda, -1);
		case 2 -> nuevaHorchata(comanda, -1);
		case 3 -> nuevoCucurucho(comanda, -1);
		default -> {
			println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
			nuevoPedido(comanda);
		}
		}

		if (nuevaComanda)
			pedidos.add(comanda);

		addMasPedidosEstaComanda_o_TurnToMenuInicial(comanda);
	}

	static void printMenu_NuevoPedido() {
		String menuNuevoPedido = """
				            **********************************
				            ** [1] - Loteria                **
				            ** [2] - Horchata               **
				            ** [3] - Cucurucho              **
				            ** [0] - Menu Inicial           **
				            **********************************
				""";
		println("", separadorConTitulo("NUEVO PEDIDO"), menuNuevoPedido);
	}

	/**
	 * Esta función nuevaLoteria es utilizada para añadir un nuevo objeto Loteria a
	 * la lista de objetos Vendible que conforman la comanda. Toma dos argumentos:
	 * comanda, que es la lista actual de objetos Vendible, y selectIten, que es la
	 * posición de la lista de objetos Vendible que se desea cambiar o actualizar.
	 * 
	 * Primero, se le pide al usuario que ingrese el precio de la lotería utilizando
	 * la función pedirDecimal. Luego, si selectIten es igual a -1, significa que no
	 * se ha seleccionado un objeto Vendible para ser actualizado, por lo que se
	 * crea una nueva instancia de Loteria con el precio ingresado y se agrega a la
	 * lista comanda utilizando la función add.
	 * 
	 * En caso contrario, si selectIten es diferente de -1, significa que se ha
	 * seleccionado un objeto Vendible para ser actualizado, por lo que se crea una
	 * nueva instancia de Loteria con el precio ingresado y se reemplaza el objeto
	 * Vendible en la posición selectIten de la lista comanda utilizando la función
	 * set.
	 * 
	 * @param comanda    ArrayList<Vendible> de la comanda en cuestión
	 * @param selectIten si -1 añade nuevo vendible, al contrario actualiza la
	 *                   posición indicada
	 */
	static void nuevaLoteria(ArrayList<Vendible> comanda, int selectIten) {
		double precioLoteria = pedirDecimal("CUAL VALOR DE LA LOTERIA => ");
		if (selectIten == -1)
			comanda.add(new Loteria(precioLoteria));
		else
			comanda.set(selectIten, new Loteria(precioLoteria));
	}

	/**
	 * Esta función permite agregar una nueva bebida de horchata a la comanda o
	 * editar una existente, dependiendo del valor del parámetro selectIten.
	 * 
	 * Primero, muestra un menú con tres opciones de horchata: Tradicional, Plus y
	 * Premium. Luego, pide al usuario que ingrese la cantidad deseada en ml. Si
	 * selectIten es igual a -1, entonces se agrega una nueva instancia de la clase
	 * Horchata a la comanda con los valores seleccionados. Si selectIten es mayor o
	 * igual a 0, entonces se actualiza la instancia correspondiente en la comanda
	 * con los valores seleccionados.
	 * 
	 * @param comanda    ArrayList<Vendible> de la comanda en cuestión
	 * @param selectIten si -1 añade nuevo vendible, al contrario actualiza la
	 *                   posición indicada
	 */
	static void nuevaHorchata(ArrayList<Vendible> comanda, int selectIten) {
		printMenu_Horchata();

		horchatas horchata = null;

		switch (pedirEntero("CUAL HORCHATA DESEA 1 a 3 => ")) {
		case 1 -> horchata = horchatas.Tradicional;
		case 2 -> horchata = horchatas.Plus;
		case 3 -> horchata = horchatas.Premiun;
		default -> {
			println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
			nuevaHorchata(comanda, selectIten);
		}
		}

		int cantidad = pedirEntero("CANTIDAD DESEADA EN ml => ");

		if (selectIten == -1)
			comanda.add(new Horchata(horchata, cantidad));
		else
			comanda.set(selectIten, new Horchata(horchata, cantidad));
	}

	private static void printMenu_Horchata() {
		String menuNuevoPedido = """
				            **********************************
				            ** [1] - Tradicional            **
				            ** [2] - Plus                   **
				            ** [3] - Premiun                **
				            **********************************
				""";
		println("", separadorConTitulo("ELIJE LA HORCHATA"), menuNuevoPedido);
	}

	/**
	 * Este método permite agregar un nuevo Cucurucho a la comanda existente. Si el
	 * parámetro selectIten tiene el valor de -1, se crea un nuevo ítem de Cucurucho
	 * en la comanda. De lo contrario, se reemplaza el ítem seleccionado de la
	 * comanda con el nuevo ítem de Cucurucho.
	 * 
	 * Primero se muestra el menú de opciones para el tipo de cucurucho que se desea
	 * agregar. Luego, se utiliza una estructura de control switch para determinar
	 * la opción seleccionada por el usuario. Si la opción es válida, se almacena en
	 * una variable llamada cucurucho. De lo contrario, se muestra un mensaje de
	 * error y se llama al mismo método de nuevo.
	 * 
	 * Luego, se solicita al usuario que ingrese la cantidad de bolas de helado que
	 * desea en el cucurucho. Se utiliza un ciclo do-while para validar que el valor
	 * ingresado esté dentro del rango permitido (1 a 3). Si es así, se crea un
	 * nuevo ítem de Cucurucho con los valores de cucurucho y cantidadBolasHelado.
	 * Si selectIten no es igual a -1, se reemplaza el ítem seleccionado en la
	 * comanda con el nuevo ítem de Cucurucho.
	 * 
	 * @param comanda    ArrayList<Vendible> de la comanda en cuestión
	 * @param selectIten si -1 añade nuevo vendible, al contrario actualiza la
	 *                   posición indicada
	 */
	static void nuevoCucurucho(ArrayList<Vendible> comanda, int selectIten) {
		printMenu_Cucurucho();

		cucuruchos cucurucho = null;

		switch (pedirEntero("CUAL CUCURUCHO DESEA 1 a 2 => ")) {
		case 1 -> cucurucho = cucuruchos.Galleta;
		case 2 -> cucurucho = cucuruchos.Chocolate;
		default -> {
			println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
			nuevoCucurucho(comanda, selectIten);
		}
		}

		int cantidadBolasHelado;

		do {
			cantidadBolasHelado = pedirEntero("CUANTAS BOLAS DE HELADO 1 a 3 => ");
			if (cantidadBolasHelado < 1 || cantidadBolasHelado > 3)
				println(separadorConTitulo("¡Min 1 <> Max 3!"));
		} while (cantidadBolasHelado < 1 || cantidadBolasHelado > 3);

		if (selectIten == -1)
			comanda.add(new Cucurucho(cucurucho, cantidadBolasHelado));
		else
			comanda.set(selectIten, new Cucurucho(cucurucho, cantidadBolasHelado));
	}

	private static void printMenu_Cucurucho() {
		String menuNuevoPedido = """
				            **********************************
				            ** [1] - Galleta                **
				            ** [2] - Chocolate              **
				            **********************************
				""";
		println("", separadorConTitulo("ELIJE EL CUCURUCHO"), menuNuevoPedido);
	}

	/**
	 * La función elegirComanda_Nueva_o_Existente() muestra un menú para que el
	 * usuario elija entre crear una nueva comanda o seleccionar una existente. La
	 * función devuelve una lista de Vendible que representa la comanda elegida.
	 * 
	 * Primero, la función llama a printMenu_Comanda() para imprimir el menú de
	 * opciones que el usuario puede elegir. Luego, declara una variable comanda
	 * inicializada como null.
	 * 
	 * Después, utiliza un switch para determinar qué opción ha seleccionado el
	 * usuario. Si el usuario selecciona 0, se llama a abrirChiringuito() para salir
	 * del programa. Si el usuario selecciona 1, se crea una nueva lista de Vendible
	 * y se asigna a la variable comanda. Si el usuario selecciona 2, se llama a
	 * selectComanda() para que el usuario seleccione una comanda existente y se
	 * asigna a la variable comanda.
	 * 
	 * Si el usuario ingresa una opción no válida, se imprime un mensaje de error y
	 * se llama recursivamente a elegirComanda_Nueva_o_Existente() hasta que se
	 * seleccione una opción válida. Al final, la función devuelve la comanda
	 * seleccionada.
	 * 
	 * @return ArrayList<Vendible> nueva o seleccionada de las abiertas
	 */
	private static ArrayList<Vendible> elegirComanda_Nueva_o_Existente() {
		printMenu_Comanda();
		ArrayList<Vendible> comanda = null;
		switch (pedirEntero("QUE DESEA HACER de 0 a 2 => ")) {
		case 0 -> abrirChiringuito();
		case 1 -> comanda = new ArrayList<Vendible>();
		case 2 -> comanda = selectComanda();
		default -> {
			println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
			elegirComanda_Nueva_o_Existente();
		}
		}
		return comanda;
	}

	private static void printMenu_Comanda() {
		String menuNuevoPedido = """
				            **********************************
				            ** [1] - Nueva Comanda          **
				            ** [2] - Comanda Abierta        **
				            ** [0] - Menu Inicial           **
				            **********************************
				""";
		println("", separadorConTitulo("ELIJE COMANDA"), menuNuevoPedido);
	}

	/**
	 * Esta función se encarga de dar opciones al usuario después de agregar un ítem
	 * a la comanda.
	 * 
	 * Primero, se imprime un menú con dos opciones: "SIM, a esta comanda" (agregar
	 * más ítems a la comanda actual) y "Menu Inicial" (regresar al menú principal
	 * del programa).
	 * 
	 * Luego, se utiliza un switch para determinar qué opción seleccionó el usuario.
	 * Si elige "Menu Inicial", se llama a la función abrirChiringuito() para
	 * regresar al menú principal. Si elige "SIM, a esta comanda", se llama a la
	 * función nuevoPedido(comanda) para que el usuario pueda agregar más ítems a la
	 * comanda actual. Si elige una opción inválida, se imprime un mensaje de error
	 * y se llama a la función addMasPedidosEstaComanda_o_TurnToMenuInicial(comanda)
	 * para darle otra oportunidad al usuario de seleccionar una opción válida.
	 * 
	 * @param comanda ArrayList<Vendible> de la comanda en cuestión
	 */
	private static void addMasPedidosEstaComanda_o_TurnToMenuInicial(ArrayList<Vendible> comanda) {
		String menuNuevoPedido = """
				            **********************************
				            ** [1] - SIM, a esta comanda    **
				            ** [0] - Menu Inicial           **
				            **********************************
				""";
		println("", separadorConTitulo("AÑADIR MAS PEDIDOS"), menuNuevoPedido);

		switch (pedirEntero("QUE DESEA HACER de 0 a 1 => ")) {
		case 0 -> abrirChiringuito();
		case 1 -> nuevoPedido(comanda);
		default -> {
			println("", separadorConTitulo("¡OPCIÓN INVALIDA!"));
			addMasPedidosEstaComanda_o_TurnToMenuInicial(comanda);
		}
		}
	}

}
