package act02;

import java.util.Scanner;

/**
 * programa que almacene en un array bidimensional (tipo String) el nombre de
 * tres asignaturas y sus cuatro puntuaciones
 * 
 * @version 1.2
 * @author Fauno Guazina
 */
public class Ejercicio02 {

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
	 *        hay más 4 cases que son las opciones de la aplicación: #option_1() en
	 *        el {case 1} Mostrar el nombre de todas las asignaturas. #option_2() en
	 *        el {case 2} Modificar el nombre de una asignatura. #option_3() en el
	 *        {case 3} Modificar la puntuación de una asignatura. #option_4() en el
	 *        {case 4} Mostrar la puntuación menor de cada una de las asignaturas.
	 *
	 * @see #menuEntry()
	 * @see #exitMsgPrint()
	 * @see #option_1()
	 * @see #option_2()
	 * @see #option_3()
	 * @see #option_4()
	 */
	public static void start() {

		switch (menuEntry()) {
		case 0 -> exitMsgPrint();
		case 1 -> option_1();
		case 2 -> option_2();
		case 3 -> option_3();
		case 4 -> option_4();
		default -> exitMsgPrint();
		}
	}

	/**
	 * FUNCIÓN DE IMPRESIÓN Y SELECIÓN DEL MENU:
	 *
	 * @since 1.0
	 *
	 *        Incia imprimindo el estado de la matriz invocando la función
	 *        #showMatriz(). Después hace una {parseInt} del return de la función
	 *        userEntryLoop(Options.MENU), que siempre devuelve una String numerica
	 *        de rango 0 a 4 con el parámetro #Options.MENU.
	 *
	 * @see #showMatriz()
	 * @see #userEntryLoop(Options.MENU)
	 * @return caracter tipo {int} de rango 0 a 4.
	 */
	private static int menuEntry() {

		showMatriz();

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
	 * FUNCIÓN AUXILIAR QUE IMPRIME EL ESTADO DE LAS NOTAS
	 *
	 * @since 1.0
	 *
	 *        Inicialmente invoca la función printBorderline() para crear un marco
	 *        alrededor del status de los recipientes, así que es la primera y
	 *        última cosa que hace. Entre los marcos utiliza dos bucles {for}
	 *        anidados para hacer la impresión del nombre de las asignaturas y sus
	 *        notas. Hay un bloque {ifElseIf} con 3 condiciones para organziar la
	 *        impresion, primero nombre de la asignatura segido de dos puntos,
	 *        despues cada nota separada por espacio guión espacio y por fim la
	 *        última nota con un salto de línea.
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 */
	private static void showMatriz() {

		printBorderline("=", false);

		for (String[] m : matriz) {
			for (int i = 0; i < m.length; i++) {
				if (i == 0) {
					System.out.print(m[i] + ": ");
				} else if (i < 3) {
					System.out.print(m[i] + " - ");
				} else {
					System.out.println(m[i]);
				}
			}
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
	 * FUNCIÓN QUE DESARROLLA LA OPCIÓN 1 : Mostrar el nombre de todas las
	 * asignaturas.
	 *
	 * @since 1.0
	 * 
	 * 
	 *        La función option_1() muestra en la consola las asignaturas
	 *        registradas en una matriz utilizando la función printBorderline() para
	 *        imprimir un borde de separación, System.out.println() para imprimir el
	 *        mensaje "Las asignaturas registradas son:", un bucle {for} para
	 *        imprimir el nombre de cada asignatura en la matriz, un bloque {if
	 *        else} donde la función System.out.print() imprime las tres primeras en
	 *        la misma línea más un espacio guión espacio y la última finaliza con
	 *        un salto de línea con la función System.out.println(). Y finalmente
	 *        turnToMenu() para mostrar un mensaje y esperar la entrada del usuario
	 *        para volver al menú principal. En resumen, esta función es una opción
	 *        del menú principal que permite al usuario ver las asignaturas
	 *        registradas en el programa.
	 *
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 * @see #matriz
	 * @see #turnToMenu(java.lang.String)
	 */
	private static void option_1() {

		printBorderline("=", false);

		System.out.println("Las assignaturas registradas son:".toUpperCase());

		for (int i = 0; i < matriz.length; i++) {
			if (i < 3) {
				System.out.print(matriz[i][0] + " - ");
			} else {
				System.out.println(matriz[i][0]);
			}
		}

		turnToMenu("-");
	}

	/**
	 * FUNCIÓN QUE DESARROLLA LA OPCIÓN 2 : Modificar el nombre de una asignatura
	 *
	 * @since 1.0 La función comienza llamando a la función printBorderline() para
	 *        imprimir un borde de separación en la consola con el carácter "-" como
	 *        elemento y false porque no es el final de la función.
	 *
	 *        Luego, llama a la función userEntryLoop() con el parámetro
	 *        {Options.OPTION_2}. Esta función es utilizada para obtener la entrada
	 *        del usuario de forma segura y mostrar un mensaje específico según la
	 *        opción del menú que el usuario ha seleccionado. En este caso, la
	 *        entrada del usuario se convierte en un número entero con la función
	 *        Integer.parseInt() y se resta 1, ya que los índices de las matrices
	 *        comienzan en 0. El resultado se almacena en la variable
	 *        {subjectPosition}.
	 *
	 *        A continuación, la función imprime un mensaje que muestra la
	 *        asignatura seleccionada por el usuario, utilizando
	 *        {matriz[subjectPosition][0]} para obtener el nombre de la asignatura
	 *        seleccionada. Luego, la función pregunta al usuario por el nuevo
	 *        nombre que desea asignar a la asignatura seleccionada y guarda la
	 *        respuesta en la variable newName.
	 *
	 *        Después, la función actualiza el nombre de la asignatura seleccionada
	 *        en la matriz con la línea matriz[subjectPosition][0] = newName;.
	 *
	 *        Por último, la función llama a turnToMenu() para mostrar un mensaje y
	 *        esperar la entrada del usuario antes de volver al menú principal.
	 *
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 * @see #matriz
	 * @see #turnToMenu(java.lang.String)
	 */
	private static void option_2() {

		printBorderline("-", false);

		int subjectPosition = Integer.parseInt(userEntryLoop(Options.OPTION_2)) - 1;

		System.out.print("Has seleccionado " + matriz[subjectPosition][0] + ", ¿Cual nuevo nombre? => ");

		String newName = sc.nextLine();

		matriz[subjectPosition][0] = newName;

		turnToMenu("-");
	}

	/**
	 * FUNCIÓN QUE DESARROLLA LA OPCIÓN 3 : Modificar la puntuación de una
	 * asignatura
	 *
	 * @since 1.0 La función comienza llamando a la función printBorderline() para
	 *        imprimir un borde de separación en la consola con el carácter "-" como
	 *        elemento y false porque no es el final de la función.
	 *
	 *        Luego, se le pide al usuario que seleccione una asignatura específica
	 *        ingresando su posición en la matriz. Para esto se utiliza la función
	 *        userEntryLoop que muestra un mensaje en la consola y espera a que el
	 *        usuario ingrese una respuesta válida.
	 *
	 *        A continuación, se le pide al usuario que seleccione una nota
	 *        específica dentro de la asignatura seleccionada anteriormente. De
	 *        nuevo, se utiliza la función userEntryLoop para solicitar al usuario
	 *        que ingrese una respuesta válida.
	 *
	 *        Luego, se muestra en la consola el valor actual de la nota
	 *        seleccionada utilizando System.out.println. Seguidamente, se utiliza
	 *        la función userEntryLoop para solicitar al usuario que ingrese el
	 *        nuevo valor de la nota. El nuevo valor ingresado se almacena en la
	 *        matriz para la asignatura y nota seleccionadas anteriormente.
	 *
	 *        Finalmente, se llama a la función turnToMenu para volver al menú
	 *        principal. La función turnToMenu muestra un borde y una línea de texto
	 *        indicando al usuario que debe presionar "Enter" para volver al menú
	 *        principal. Luego, espera a que el usuario presione "Enter" para
	 *        continuar.
	 *
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 * @see #matriz
	 * @see #turnToMenu(java.lang.String)
	 */
	private static void option_3() {

		printBorderline("-", false);

		int subjectPosition = Integer.parseInt(userEntryLoop(Options.OPTION_3)) - 1;

		int notePosition = Integer.parseInt(userEntryLoop(Options.NOTE_POSITION));

		System.out
				.println("E valor actual de la " + notePosition + "ª nota es " + matriz[subjectPosition][notePosition]);

		matriz[subjectPosition][notePosition] = userEntryLoop(Options.NOTE_VALUE);

		turnToMenu("-");
	}

	/**
	 * FUNCIÓN QUE DESARROLLA LA OPCIÓN 4 : Mostrar la puntuación menor de cada una
	 * de las asignaturas.
	 *
	 * @since 1.0
	 *
	 *        La función option_4() comienza definiendo una variable
	 *        {subjectNamesAndLowerNotes}como una cadena vacía. Luego, se itera
	 *        sobre la matriz de asignaturas y se concatena el nombre de cada
	 *        asignatura a {subjectNamesAndLowerNotes} seguido de dos puntos y un
	 *        espacio.
	 *
	 *        Dentro del bucle exterior, se define una variable {lowerNote} como 10,
	 *        lo que significa que inicialmente se supone que la nota más baja es
	 *        10. Luego, se itera sobre las notas de cada asignatura (del índice 1
	 *        al 3) y se compara si la nota actual es menor que {lowerNote}. Si es
	 *        así, se actualiza lowerNote con la nueva nota.
	 *
	 *        Después de iterar por las notas de cada asignatura, se concatena la
	 *        nota más baja de la asignatura actual a {subjectNamesAndLowerNotes}.
	 *        Si el índice actual es menor que 3, se agrega un salto de línea para
	 *        separar los resultados de cada asignatura.
	 *
	 *        Finalmente, se llama a la función printBorderline() para imprimir una
	 *        línea de guiones como separador y luego se imprime el resultado de
	 *        {subjectNamesAndLowerNotes}. Después de eso, se llama a la función
	 *        turnToMenu() para volver al menú principal.
	 *
	 * @see #printBorderline(java.lang.String, boolean)
	 * @see #matriz
	 * @see #turnToMenu(java.lang.String)
	 */
	private static void option_4() {

		String subjectNamesAndLowerNotes = "";

		for (int i = 0; i < matriz.length; i++) {
			subjectNamesAndLowerNotes += matriz[i][0] + ": ";
			double lowerNote = 10;

			for (int j = 1; j <= 3; j++) {
				lowerNote = (lowerNote > toDouble(matriz[i][j])) ? toDouble(matriz[i][j]) : lowerNote;
			}

			subjectNamesAndLowerNotes += lowerNote;
			if (i < 3)
				subjectNamesAndLowerNotes += "\n";
		}

		printBorderline("-", false);
		System.out.println("Las menores notas son:".toUpperCase());
		System.out.println(subjectNamesAndLowerNotes);

		turnToMenu("-");
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
	 * FUNCIÓN AUXILIAR PARSEA STRING -> DOUBLE
	 *
	 * @since 1.1
	 *
	 *        recibe una String como parámetro, reemplaza la coma por punto en la
	 *        representación decimal y la convierte en double
	 *
	 * @param note (String)
	 * @return double note
	 */
	private static double toDouble(String note) {
		return Double.parseDouble(note.replace(",", "."));
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
	 * @see #userEntryLoop(actividad02.Ejercicio02.Options)
	 */
	private enum Options {

		MENU("^[0-4]{1}$", "\n¡¡¡OPCIÓN INVALIDA!!!\n", """
				MENÚ DE OPCIONES:
				1 -> Mostrar el nombre de todas las asignaturas.
				2 -> Modificar el nombre de una asignatura.
				3 -> Modificar la puntuación de una asignatura.
				4 -> Mostrar la puntuación menor de cada una de las asignaturas.
				0 -> Finalizar Programa""" + "\nQUE DESEA HACER de 0 a 4 =>  ".toUpperCase()),

		OPTION_2("^[1-4]{1}$", "\n¡¡¡ OPCIÓN INVALIDA !!! Elija de 1 a 4 !!!\n",
				"¿Hay 4 asignaturas, a cual desea cambiar? =>  ".toUpperCase()),

		OPTION_3("^[1-4]{1}$", "\n¡¡¡ OPCIÓN INVALIDA !!! Elija de 1 a 4 !!!\n",
				"¿Hay 4 asignaturas, a cual desea cambiar una nota? =>  ".toUpperCase()),

		NOTE_POSITION("^[1-3]{1}$", "\n¡¡¡ OPCIÓN INVALIDA !!! Elija de 1 a 3 !!!\n",
				"¿Hay 3 notas, a cual desea cambiar? =>  ".toUpperCase()),

		NOTE_VALUE("^(10(\\.0)?|\\d\\.\\d|\\d)$", "\n¡¡¡ VALOR INVALIDO solo de 0 a 10 y un decimal Ej:6.5!!!\n",
				"¿Cual es la nueva nota? =>  ".toUpperCase());

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
	 * Array que guarda la información base del programa.
	 */
	private static final String[][] matriz = { { "M01", "8.0", "5.0", "10.0" }, { "M02", "3.0", "8.0", "9.0" },
			{ "M03", "9.0", "7.0", "6.0" }, { "M04", "10.0", "4.0", "9.0" } };

}
