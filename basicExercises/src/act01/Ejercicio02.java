package act01;

/**
 *
 * @author fauno guazina
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		/*
		 * 2.1 - Para cada tipo de dato simple añade dentro de la función main de
		 * Ejercicio02 un comentario indicando el tipo de dato. A demás para cada tipo
		 * de dato simple declara una variable de ese tipo, asígnale un valor y muestra
		 * un mensaje que explique las características del tipo de dato y muestre el
		 * valor de la variable.
		 */
		printTiposSimples();

		/*
		 * 2.2 - Dentro de la clase de nombre Ejercicio02, añade un ejemplo de uso de
		 * cada uno de los operadores aritméticos, relacionales, lógicos, unitarios y de
		 * asignación. Indicando con un comentario y con un mensaje por consola cual
		 * será el resultado de cada uno de ellos.
		 */
		printAritimeticos();

		printAritimeticosUnario();

		printAritimeticosAsignacion();

		printRelacionales();

		printLogicos();

	}

	// METODOS DEL EJERCICIO 2.1
	public static void printTiposSimples() {

		// variables de apoio:
		String[] preItens = { "Variable tipo ", " que almacena ", ", ocupa ", ". Ejemplo: " };
		String[] varEspacio = { "1 byte (8bits)", "2 byte (16bits)", "4 byte (32bits)", "8 byte (64bits)" };
		String[] tipos = { "BOOLEAN", "BYTE", "CHAR", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE" };
		String varTipo = "";
		String varDeescripcion = "";
		String varOcupa = "";
		String varEjemplo = "";

		// variables primitvas
		boolean boolEjemplo = true;
		byte byteEjemplo = -7;
		char charEjemplo = 'a';
		short shortEjemplo = 420;
		int intEjemplo = 2147483647;
		long longEjemplo = 9223372036854775807L;
		float floatEjemplo = 99.12345f;
		double doubleEjemplo = 0.12345678913151;

		// bucle for para reducir creación de variables y repetición de println
		System.out.println("%%%%%%%%%%%%%%%%%%%%%% VARIABLES " + "PRIMITIVAS %%%%%%%%%%%%%%%%%%%%%%");
		for (String tipo : tipos) {

			switch (tipo) {
			case "BOOLEAN" -> {
				varTipo = tipos[0];
				varDeescripcion = "dos posibles valores: true o false";
				varOcupa = varEspacio[0];
				varEjemplo = String.valueOf(boolEjemplo);
			}
			case "BYTE" -> {
				varTipo = tipos[1];
				varDeescripcion = "números enteros entre -128 y 127";
				varOcupa = varEspacio[0];
				varEjemplo = String.valueOf(byteEjemplo);
			}
			case "CHAR" -> {
				varTipo = tipos[2];
				varDeescripcion = "un carácter Unicode de 16 bits";
				varOcupa = varEspacio[1];
				varEjemplo = String.valueOf(charEjemplo);
			}
			case "SHORT" -> {
				varTipo = tipos[3];
				varDeescripcion = "números enteros entre -32768 y +32767";
				varOcupa = varEspacio[1];
				varEjemplo = String.valueOf(shortEjemplo);
			}
			case "INT" -> {
				varTipo = tipos[4];
				varDeescripcion = "números enteros entre -2³¹ y +2³¹-1";
				varOcupa = varEspacio[2];
				varEjemplo = String.valueOf(intEjemplo);
			}
			case "LONG" -> {
				varTipo = tipos[5];
				varDeescripcion = "números enteros entre -2^63 y +2^63-1";
				varOcupa = varEspacio[3];
				varEjemplo = String.valueOf(longEjemplo);
			}
			case "FLOAT" -> {
				varTipo = tipos[6];
				varDeescripcion = "números decimales con una precisión " + "aproximada de 7 dígitos";
				varOcupa = varEspacio[2];
				varEjemplo = String.valueOf(floatEjemplo);
			}
			case "DOUBLE" -> {
				varTipo = tipos[7];
				varDeescripcion = "números decimales con una precisión " + "aproximada de 16 dígitos";
				varOcupa = varEspacio[3];
				varEjemplo = String.valueOf(doubleEjemplo);
			}
			}

			System.out.println(preItens[0] + varTipo + preItens[1] + varDeescripcion + preItens[2] + varOcupa
					+ preItens[3] + varEjemplo);
		}
	}

	// METODOS DEL EJERCICIO 2.2
	public static void printAritimeticos() {

		System.out.println("\n\n%%%%%%%%%%%%%%%%%%%%%% OPERADORES " + "ARITIMÉTICOS %%%%%%%%%%%%%%%%%%%%%%");

		System.out.println(
				"\n++++++++++++++ OPERADOR (+) SUMAR ++++++++++++++" + "\nLa variable A vale 2 y la variable B vale 3"
						+ "\nEn el código \"int C = A + B\", C vale " + (A + B));

		System.out.println(
				"\n-------------- OPERADOR (-) RESTAR --------------" + "\nLa variable A vale 2 y la variable B vale 3"
						+ "\nEn el código \"int C = A - B\", C vale " + (A - B));

		System.out.println(
				"\n*********** OPERADOR (*) MULTIPLICAR ************" + "\nLa variable A vale 2 y la variable B vale 3"
						+ "\nEn el código \"int C = A * B\", C vale " + (A * B));

		System.out.println(
				"\n////////////// OPERADOR (/) DIVIDIR //////////////" + "\nLa variable X vale 6 y la variable B vale 3"
						+ "\nEn el código \"int C = X / B\", C vale " + (X / B));

		System.out.println("\n%%%%%%%%%%%%%% OPERADOR (%) MÓDULO %%%%%%%%%%%%%%"
				+ "\nLa variable X vale 6 y la variable A vale 2" + "\nEn el código \"int C = X % A\", C vale "
				+ (X % A) + "\nLa variable Y vale 7 y la variable A vale 2"
				+ "\nEn el código \"int C = Y % A\", C vale " + (Y % A) + "\nel módulo guarda el resto de la división");
	}

	public static void printAritimeticosUnario() {

		System.out.println("\n\n~~~~~~~~~~~~~~~~~~ OPERADORES " + "ARITIMÉTICOS UNÁRIOS ~~~~~~~~~~~~~~~~~~");

		System.out.println("\n++++++++++++++++ OPERADOR (++) INCREMENTAR ++++++++++++++++"
				+ "\nLa variable X vale 6 en el c\u00f3digo" + " \"int C = X++\", C vale " + (++X));

		System.out.println("\n---------------- OPERADOR (--) DECREMENTAR ----------------"
				+ "\nLa variable X vale 6 en el c\u00f3digo" + " \"int C = X--\", C vale " + (--X));

		System.out.println("\n---------------- OPERADOR (-) INVERSOR ----------------"
				+ "\nLa variable Y vale 7 en el c\u00f3digo" + " \"int C = -Y\", C vale " + (-Y)
				+ "\nLa variable Z vale -9 en el c\u00f3digo" + " \"int C = -Z\", C vale " + (-Z));

		System.out.println("\n!!!!!!!!!!!!!!!! OPERADOR (!) ALTERNADOR !!!!!!!!!!!!!!!!"
				+ "\nLa variable V vale TRUE en el c\u00f3digo" + " \"boolean C = !V\", C vale " + (!V)
				+ "\nLa variable F vale FALSE en el c\u00f3digo" + " \"boolean C = !F\", C vale " + (!F)

		);
	}

	public static void printAritimeticosAsignacion() {

		System.out.println("\n\n~~~~~~~~~~~~~~~~ OPERADORES " + "ARITIMÉTICOS DE ASIGANACIÓN ~~~~~~~~~~~~~~~~");

		System.out.println("\n================= OPERADOR (=) ASIGNAR ================="
				+ "\nEn el c\u00f3digo \"int X = 6;\" o \"boolean V = true;\" el"
				+ "\noperador \"=\" está asignando valor a las variables");

		System.out.println("\n+=+=+=+=+=+=+= OPERADOR (+=) SUMA Y ASIGNA +=+=+=+=+=+=+="
				+ "\nLa variable A vale 2 y la variable B vale 3" + "\nEn el código \"A += B\", A vale " + (A += B));

		System.out.println("\n-=-=-=-=-=-=-= OPERADOR (-=) RESTA Y ASIGNA -=-=-=-=-=-=-="
				+ "\nLa variable A vale 5 y la variable B vale 3" + "\nEn el código \"A -= B\", A vale " + (A -= B));

		System.out.println("\n*=*=*=*=*= OPERADOR (*=) MULTIPLICA Y ASIGNA *=*=*=*=*="
				+ "\nLa variable X vale 6 y la variable B vale 3" + "\nEn el código \"X *= B\", X vale " + (X *= B));

		System.out.println("\n/=/=/=/=/=/= OPERADOR (/=) DIVIDE Y ASIGNA /=/=/=/=/=/="
				+ "\nLa variable X vale 18 y la variable A vale 2" + "\nEn el código \"X /= A\", X vale " + (X /= A));

		System.out.println("\n%=%=%=%=%=%= OPERADOR (%=) MÓDULO Y ASIGNA %=%=%=%=%=%="
				+ "\nLa variable X vale 9 y la variable B vale 3" + "\nEn el código \"X %= B\", X vale " + (X %= B));
	}

	public static void printRelacionales() {

		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~ OPERADORES " + "RELACIONALES ~~~~~~~~~~~~~~~~~~~~~~~~");

		System.out.println("\n=============== OPERADOR (==) ES IGUAL ==============="
				+ "\nLa variable A vale 2 y en los códigos" + "\n\"(A == 2)\", el resultado es " + (A == 2)
				+ "\n\"(A == 3)\", el resultado es " + (A == 3));

		System.out.println("\n!=!=!=!=!=!=!= OPERADOR (!=) NO IGUAL !=!=!=!=!=!=!="
				+ "\nLa variable A vale 2 y en los códigos" + "\n\"(A != 2)\", el resultado es " + (A != 2)
				+ "\n\"(A != 3)\", el resultado es " + (A != 3));

		System.out.println("\n>>>>>>>>>>>>>>>> OPERADOR (>) MAYOR >>>>>>>>>>>>>>>>"
				+ "\nLa variable A vale 2 y en los códigos" + "\n\"(A > 1)\", el resultado es " + (A > 1)
				+ "\n\"(A > 2)\", el resultado es " + (A > 2) + "\n\"(A > 3)\", el resultado es " + (A > 3));

		System.out.println("\n>=>=>=>=>=>= OPERADOR (>=) MAYOR IGUAL >=>=>=>=>=>="
				+ "\nLa variable A vale 2 y en los códigos" + "\n\"(A >= 1)\", el resultado es " + (A >= 1)
				+ "\n\"(A >= 2)\", el resultado es " + (A >= 2) + "\n\"(A >= 3)\", el resultado es " + (A >= 3));

		System.out.println("\n<<<<<<<<<<<<<<< OPERADOR (<) MENOR <<<<<<<<<<<<<<<"
				+ "\nLa variable A vale 2 y en los códigos" + "\n\"(A < 1)\", el resultado es " + (A < 1)
				+ "\n\"(A < 2)\", el resultado es " + (A < 2) + "\n\"(A < 3)\", el resultado es " + (A < 3));

		System.out.println("\n<=<=<=<=<=<= OPERADOR (<=) MENOR IGUAL <=<=<=<=<=<="
				+ "\nLa variable A vale 2 y en los códigos" + "\n\"(A <= 1)\", el resultado es " + (A <= 1)
				+ "\n\"(A <= 2)\", el resultado es " + (A <= 2) + "\n\"(A <= 3)\", el resultado es " + (A <= 3));
	}

	public static void printLogicos() {

		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~ OPERADORES " + "LÓGICOS ~~~~~~~~~~~~~~~~~~~~~~~~");

		System.out.println("\n&&&&&&&&&&&&&&&& OPERADOR (&&) AND &&&&&&&&&&&&&&&&"
				+ "\nLas variables V y F valen TRUE y FALSE" + "\nen el código: \"(V && true)\" = " + (V && true)
				+ "\nen el código: \"(V && F)\" = " + (V && F) + "\nen el código: \"(V && !F)\" = " + (V && !F));

		System.out.println("\n|||||||||||||||| OPERADOR (||) OR ||||||||||||||||"
				+ "\nLas variables V y F valen TRUE y FALSE" + "\nen el código: \"(V || true)\" = " + (V && true)
				+ "\nen el código: \"(V || F)\" = " + (V && F) + "\nen el código: \"(V || !F)\" = " + (V && !F));

		System.out.println(
				"\n!!!!!!!!!!!!!!!! OPERADOR (!) NOT !!!!!!!!!!!!!!!!" + "\nLas variables V y F valen TRUE y FALSE"
						+ "\nen el código: \"(!V)\" = " + (!V) + "\nen el código: \"(!!V)\" = " + (!!V)
						+ "\nen el código: \"(!F)\" = " + (!F) + "\nen el código: \"(!!F)\" = " + (!!F));
	}

	// VARIABLES GLOBALES
	static int A = 2;
	static int B = 3;
	static int X = 6;
	static int Y = 7;
	static int Z = -9;
	static boolean V = true;
	static boolean F = false;
}
