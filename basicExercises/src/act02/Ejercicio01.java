package act02;

import java.util.Scanner;

/**
 * Programa que gestiona un array de 5 posiciones para controlar la cantidad de
 * litros de refresco en 5 recipientes inicialmente a 0.
 *
 * @author Fauno Guazina
 * @version 1.2
 */
public class Ejercicio01 {

	public static void main(String[] args) {

		start();
	}

	/**
	 * FUNCIÓN BÁSICA QUE INICIA Y GERENCIA LA APLICACIÓN:
	 *
	 * @since 1.0
	 *
	 *        Se base en un switch que evalua el return de la función #menuEntry()
	 *        para selecionar cual de las funciones desea realizar el usuario. Por
	 *        defecto activa la función de salida #exitMsgPrint() y finaliza la
	 *        aplicación o cuando el usuário elige selecionar el {case 0}. Ademas
	 *        hay más 3 cases que son las opciones de la aplicación: #option_1() en
	 *        el {case 1} Añadir refresco a un recipiente. #option_2() en el {case
	 *        2} Quitar refresco de un recipiente. #option_3() en el {case 3}
	 *        Calcular el total de refresco.
	 *
	 * @see #menuEntry()
	 * @see #exitMsgPrint()
	 * @see #option_1()
	 * @see #option_2()
	 * @see #option_3()
	 */
	public static void start() {

		switch (menuEntry()) {
		case 0 -> exitMsgPrint();
		case 1 -> option_1();
		case 2 -> option_2();
		case 3 -> option_3();
		default -> exitMsgPrint();
		}
	}

	/**
	 * FUNCIÓN DE IMPRESIÓN Y SELECIÓN DEL MENU:
	 *
	 * @since 1.0
	 *
	 *        Incia imprimindo el estado de los recipientes invocando la función
	 *        #showSodaRapier(). Después hace una {parseInt} del return de la
	 *        función userEntryLoop(Options.MENU), que siempre devuelve una String
	 *        numerica de rango 0 a 3 con el parámetro #Options.MENU.
	 *
	 * @see #showSodaRapier()
	 * @see #userEntryLoop(Options.MENU)
	 * @return caracter tipo {int} de rango 0 a 3.
	 */
	private static int menuEntry() {

		showSodaRapier();

		return Integer.parseInt(userEntryLoop(Options.MENU));
	}

	/**
	 * FUNCIÓN QUE REALIZA TODAS LAS CONSULTAS AL USUARIO
	 *
	 * @since 1.1
	 *
	 *        Inicialmente define dos variables: una de tipo {int} para controlar la
	 *        cantidad de intentos del usuario en seleccionar la opción que se
	 *        presenta a él y la otra de tipo {String} que guarda el valor de su
	 *        selección. Dentro de un bucle {do while}, inicialmente, por medio de
	 *        un {if}, verifica si es el primer intento, caso negativo imprime un
	 *        mensaje de error indicando cuales son las opciones correctas. Después
	 *        hay una impresión con el enunciado de lo que está seleccionando el
	 *        usuario. Para entonces utilizar una variable de tipo {Scanner} para
	 *        colectar la entrada del teclado y guárdala en la variable
	 *        {userEntryValue} y entonces suma uno más, por medio de un operador
	 *        ternario, el intento de selección. La condición de evaluación es por
	 *        medio del método {matches} que utiliza una regex. Tanto en mensaje de
	 *        error, como el enunciado y la regex son obtenidas por medio del
	 *        parámetro {type}, un ENUN de tipo {Options}.
	 *
	 * @param type -> ENUM actividad02.Ejercicio01.Options
	 * @return String de valor numerico y el rango cambia conforme la regex.
	 */
	private static String userEntryLoop(Options type) {

		int attemptSelection = 0;
		String userEntryValue;

		do {

			if (attemptSelection > 0)
				System.out.println(type.invalid);

			System.out.print(type.statement);

			userEntryValue = sc.nextLine().replace(",", ".");

			attemptSelection++;

		} while (!userEntryValue.matches(type.regex));

		return userEntryValue;
	}

	/**
	 * FUNCIÓN QUE DESARROLLA LA OPCIÓN 1 : Añadir refresco a un recipiente
	 *
	 * @since 1.1
	 *
	 *        Inicialmente invoca la función printBorderline() para crear un marco
	 *        alrededor de su ejecución. Después define una variable
	 *        {containerPosition} de tipo {int} para guardar la posición del
	 *        recipiente que el usuario quiere añadir refresco por medio de la
	 *        función userEntryLoop() que será parseada a int. A posteriori define
	 *        una variable {quantityToAdd} de tipo {double} para guardar la cantidad
	 *        que el usuario desea añadir que será parseada a double. Después
	 *        utiliza estas dos variables para determinar la posición en el array
	 *        {sodaRapier} utiliza un operador {+=} para sumar la cantidad deseada.
	 *        Por fin invoca la función turnToMenu() que recrea el marco inicial
	 *        encerrado toda la función y vuelve al menú de opciones.
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 * @see #userEntryLoop(actividad02.Ejercicio01.Options)
	 * @see #sodaRapier
	 * @see #turnToMenu(java.lang.String)
	 */
	private static void option_1() {

		printBorderline("+", false);

		int containerPosition = Integer.parseInt(userEntryLoop(Options.RECIPIENTES)) - 1;
		double quantityToAdd = Double.parseDouble(userEntryLoop(Options.LITROS_Plus));

		sodaRapier[containerPosition] += quantityToAdd;

		turnToMenu("+");
	}

	/**
	 * FUNCIÓN QUE DESARROLLA LA OPCIÓN 2 : Quitar refresco a un recipiente
	 *
	 * @since 1.1
	 *
	 *        Inicialmente invoca la función printBorderline() para crear un marco
	 *        alrededor de su ejecución. Después define una variable
	 *        {containerPosition} de tipo {int} para guardar la posición del
	 *        recipiente que el usuario quiere añadir refresco por medio de la
	 *        función userEntryLoop() que será parseada a int. Por medio de un
	 *        bloque {if else} verifica si el recipiente está vacío, si es cierto
	 *        informa del estado del recipiente e invoca la función turnToMenu() que
	 *        recrea el marco inicial encerrado toda la función y vuelve al menú de
	 *        opciones. Caso el recipiente tenga contenido define una variable
	 *        {quantityTakeOut} de tipo {double} para guardar la cantidad que el
	 *        usuario desea quitar que será parseada a double. Posteriormente un
	 *        bucle{while} para verificar si cantidad que haya en el recipiente es
	 *        menor que la que desea ser restada, caso entre en bucle imprime un
	 *        mensaje informativo de la cantidad que hay en el recipiente y le pide
	 *        otra vez cuánto quiere restar. Después utiliza estas dos variables
	 *        para determinar la posición en el array {sodaRapier} utiliza un
	 *        operador {-=} para restar la cantidad deseada. Por fin invoca la
	 *        función turnToMenu() que recrea el marco inicial encerrado toda la
	 *        función y vuelve al menú de opciones.
	 * 
	 * @see #printBorderline(java.lang.String, boolean)
	 * @see #userEntryLoop(actividad02.Ejercicio01.Options)
	 * @see #sodaRapier
	 * @see #turnToMenu(java.lang.String)
	 */
	private static void option_2() {

		printBorderline("-", false);

		int containerPosition = Integer.parseInt(userEntryLoop(Options.RECIPIENTES)) - 1;

		if (sodaRapier[containerPosition] == 0) {

			System.out.println("\n¡¡¡EL RECIPIENTE ESTÁ VACÍO!!!");

			turnToMenu("-");

		} else {

			double quantityTakeOut = Double.parseDouble(userEntryLoop(Options.LITROS_Minus));

			while (sodaRapier[containerPosition] < quantityTakeOut) {

				System.out.println("   >>> Solo Hay " + sodaRapier[containerPosition] + " Litros <<<");

				quantityTakeOut = Double.parseDouble(userEntryLoop(Options.LITROS_Minus));
			}

			sodaRapier[containerPosition] -= quantityTakeOut;

			turnToMenu("-");
		}
	}

	/**
	 * FUNCIÓN QUE DESARROLLA LA OPCIÓN 3 : Calcular el total de refresco
	 *
	 * @since 1.1
	 *
	 *        Inicialmente define una variable {sumContainers} con valor 0 que será
	 *        la suma de todos los recipientes. Después utiliza un bucle {ForEach}
	 *        que suma por medio del operador {+=} la cantidad de cada recipiente
	 *        {eachContainer} a la variable de suma. Posteriormente crea una
	 *        variable {totalMsg} de tipo {String} con la concatenación del
	 *        resultado de suma y el mensaje que será impreso por consola. Después
	 *        invoca la función printBorderline() para crear un marco alrededor de
	 *        la impresión. Por fin invoca la función turnToMenu() que recrea el
	 *        marco inicial encerrado toda la función y vuelve al menú de opciones.
	 *
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 * @see #sodaRapier
	 * @see #turnToMenu(java.lang.String)
	 */
	private static void option_3() {

		double sumContainers = 0;

		for (double eachContainer : sodaRapier) {
			sumContainers += eachContainer;
		}

		String totalMsg = "La suma de los 5 recipientes es de " + sumContainers + " litros.";

		printBorderline("^", false);
		System.out.println(totalMsg);

		turnToMenu("^");
	}

	/**
	 * FUNCIÓN QUE DESARROLLA LA OPCIÓN 0 : Finaliza la aplicación
	 * 
	 * @since 1.0
	 *
	 *        Crea una variable {exitMsg} de tipo {String} con el contenido del
	 *        mensaje de finalización de la aplicación. Después hace la impresión
	 *        por pantalla del mensaje e invoca la función printBorderline() para
	 *        crear un marco alrededor de la impresión.
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 */
	private static void exitMsgPrint() {

		String exitMsg = "\n¡¡¡ GRACIAS POR VENIR!!!";

		System.out.println(exitMsg + "\n");
		printBorderline("=", false);
	}

	/**
	 * FUNCIÓN AUXILIAR QUE IMPRIME EL ESTADO DE LOS RECIPIENTES
	 *
	 * @since 1.0
	 *
	 *        Inicialmente invoca la función printBorderline() para crear un marco
	 *        alrededor del status de los recipientes, así que es la primera y
	 *        última cosa que hace. Entre los marcos utiliza un bucle {for} para
	 *        hacer la impresión de los recipientes y la variable {i} del bucle para
	 *        indicar su cardinalidad por medio de suma más uno.
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 */
	private static void showSodaRapier() {

		printBorderline("=", false);

		for (int i = 0; i < sodaRapier.length; i++) {
			System.out.println("En el " + (i + 1) + "º recipiente hay " + sodaRapier[i] + " litros");
		}

		printBorderline("=", true);
	}

	/**
	 * FUNCIÓN AUXILIAR QUE IMPRIME MARCOS
	 *
	 * @since 1.1
	 *
	 *        Para facilitar la lectura de las impresiones por pantalla de las
	 *        opciones del programa he creado una función que facilita la impresión
	 *        de marcos recibiendo un carácter de tipo {String} como parametro a
	 *        replicar en este marco por medio de un bucle {for} en 40 repeticiones
	 *        y dentro del bucle un {print} que los mantiene en la misma línea. El
	 *        parámetro booleano de la función es para indicar si el marco es el
	 *        final, caso sea {true} cambia el valor, por medio de un operador
	 *        ternario, de la variable {escapeFinal} le configurando con un salto de
	 *        línea o solo una string vacía.
	 *
	 * @param element
	 * @param end
	 */
	private static void printBorderline(String element, boolean end) {

		String escapeFinal = (end) ? "\n" : "";

		for (int i = 0; i < 40; i++) {
			System.out.print(element);
		}

		System.out.println(escapeFinal);

	}

	/**
	 * FUNCIÓN AUXILIAR PARA VOLVER AL MENÚ
	 *
	 * @since 1.2
	 *
	 *        Para evitar la repetición de de dos líneas de código en cada función
	 *        del menú (invocación de la función printBorderline() y start()),
	 *        además para evitar la confusión de tener una función “start” al final
	 *        de las opciones he optado por crear esta función auxiliar que hace
	 *        exactamente eso: invoca la función printBorderline() para crear un
	 *        marco finalizando la impresión de la opción seleccionada y cría una
	 *        pausa para que el usuario pueda contemplar la impresión de lo que ha
	 *        hecho, solicita un {enter} para que siga con el programa e invoca la
	 *        función start() para volver al menu.
	 *
	 *
	 * @param element que será usado para cierre de la impresión
	 */
	private static void turnToMenu(String element) {

		printBorderline(element, true);

		System.out.println(">>> TECLE ENTER <<<");
		sc.nextLine();

		start();
	}

	/**
	 * CLASE ENUN UTILIZADA PARA ALIMENTAR LA FUNCIÓN userEntryLoop()
	 *
	 * @since 1.2
	 *
	 *        Inicialmente cada opción y menú tenía dentro de sus funciones sus
	 *        variables tipo {String} con las info que necesitaban, regex, enunciado
	 *        y mensajes de error, pero me he dado cuenta que esto ensuciaba
	 *        demasiado el código y dificulta la lectura de las funciones, por eso
	 *        fue buscar una solución de una subclase o método que pudiese dar
	 *        cuenta de eso, acabé encontrando la clase especial ENUM que me ha
	 *        servido como un guante para lo que necesitaba. Básicamente he creado 4
	 *        tipos de ENUN con constructores y variables de tipo String para
	 *        almacenar las informaciones que necesitaba para alimentar el método
	 *        userEntryLoop().
	 *
	 *
	 * @see #userEntryLoop(actividad02.Ejercicio01.Options)
	 */
	private enum Options {

		MENU("^[0-3]{1}$", "\n¡¡¡OPCIÓN INVALIDA!!!\n", """
				MENÚ DE OPCIONES:
				1 -> Añadir refresco a un recipiente.
				2 -> Quitar refresco de un recipiente.
				3 -> Calcular el total de refresco.
				0 -> Finalizar Programa""" + "\nQUE DESEA HACER de 0 a 3 =>  ".toUpperCase()),

		RECIPIENTES("^[1-5]{1}$", "\n¡¡¡ OPCIÓN INVALIDA !!! Elija de 1 a 5 !!!\n",
				"¿Hay 5 recipientes, a cual desea modificar? =>  ".toUpperCase()),

		LITROS_Plus("^[0-9]+(\\.{1}[0-9]{1,2})?$", "\n¡¡¡ OPCIÓN INVALIDA !!! Solo valores mayores que 0,1 !!!\n",
				"¿Cantidad a añadir al recipiente? =>  ".toUpperCase()),

		LITROS_Minus("^[0-9]+(\\.{1}[0-9]{1,2})?$", "\n¡¡¡ OPCIÓN INVALIDA !!! Solo valores mayores que 0,1 !!!\n",
				"¿Cantidad a quitar del recipiente? =>  ".toUpperCase());

		private String regex;
		private String invalid;
		private String statement;

		Options(String regex, String invalid, String statement) {
			this.regex = regex;
			this.invalid = invalid;
			this.statement = statement;
		}

	}

	/**
	 * variable final para ccapturar las entradas de teclado del usuario.
	 */
	private static final Scanner sc = new Scanner(System.in);

	/**
	 * Array que guarda la información base del programa, los 5 recipientes.
	 */
	private static final double[] sodaRapier = { 0, 0, 0, 0, 0 };
}
