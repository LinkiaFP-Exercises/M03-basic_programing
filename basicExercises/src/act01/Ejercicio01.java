package act01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author fauno guazina
 */
public class Ejercicio01 {

	public static void main(String[] args) throws IOException {

		/*
		 * 1.1 - Configura tu IDE y crea un archivo de nombre Ejercicio01.java dentro de
		 * un package (una carpeta) de nombre actividad01. Copia el siguiente código,
		 * añade los import necesarios (import java.io.BufferedReader; import
		 * java.io.IOException; import java.io.InputStreamReader;) y ejecútalo.
		 */

		printEjercio1_1();

		/*
		 * Al código anterior (ejercicio01.java) añade después del último
		 * System.out.println() : 1.2.1 - Un mensaje indicando que quedan 30 mangos a 2€
		 * la unidad. 1.2.2 - Un mensaje que pregunte al usuario cuántos mangos quiere
		 * comprar. 1.2.3 - El código que reciba del usuario el número de mangos que
		 * quiere comprar y muestre el coste total con decimales (multiplica el número
		 * de mangos por el precio de cada mango) 1.2.4 - Un mensaje indicando el total
		 * de mangos que quedan en la tienda.
		 */

		printEjercio1_2();

	}

	public static void printEjercio1_1() throws IOException {
		int manzanas_tienda;
		int manzanas_queremos_comprar;
		double precio_manzana;
		double dinero_pagado;

		manzanas_tienda = 20;
		manzanas_queremos_comprar = 2;
		precio_manzana = 0.40;

		System.out.println("Vamos a comprar " + manzanas_queremos_comprar + " manzanas");
		// modificamos el contenido de las variables numericas para representar la
		// compra de manzanas
		dinero_pagado = precio_manzana * manzanas_queremos_comprar;
		manzanas_tienda = manzanas_tienda - manzanas_queremos_comprar;

		// mostramos por consola el valor de las variables numericas. De forma implícita
		// se convierte de de numero a string.
		System.out.println("Nos han costado:" + dinero_pagado);
		System.out.println("En la tienda quedan " + manzanas_tienda + " manzanas");

		System.out.println("Quantas mazanas más quieres comprar?");
		// Declaramos una variable compleja de nombre "br" y de tipo "BufferedReader".
		// Las variables del tipo "BufferedReader" contienen funciones para leer datos
		// por consola
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// utilizamos la función "readLine" de la variable "br" para leer un dato por
		// consola. Guardamos el número introducido en la variable "valor_escrito"
		String valor_escrito = br.readLine();

		// Convertimos mediante una conversion explicita la variable "valor_escrito" a
		// un valor entero para poder operar con él y lo almacenamos en la variable
		manzanas_queremos_comprar = Integer.parseInt(valor_escrito);

		System.out.println("Vamos a comprar " + manzanas_queremos_comprar + " manzanas");
		// modificamos el contenido de las variables numericas para representar la
		// compra de manzanas
		dinero_pagado = precio_manzana * manzanas_queremos_comprar;
		manzanas_tienda = manzanas_tienda - manzanas_queremos_comprar;
		// mostramos por consola el valor de las variables numericas. De forma implícita
		// se convierte de de numero a string.
		System.out.println("Nos han costado:" + dinero_pagado);
		System.out.println("En la tienda quedan " + manzanas_tienda + " manzanas");
		System.out.println("\n");
	}

	public static void printEjercio1_2() {

		// VARIABLES DE APOIO A LA COMPRA
		int mangoEstoque = 30;
		int mangoCantidadComprar = -1;
		double mangoPrecio = 2;
		double mangoValorPagado;
		Scanner sc = new Scanner(System.in);

		// IMPRESIONES DE CABECERA
		System.out.println(" ================================\n" + " ¡¡¡¡¡¡¡¡¡¡¡PROMOCIÓN!!!!!!!!!!!\n\n" + "Tenemos "
				+ mangoEstoque + " MANGOS a €" + mangoPrecio + " la unidad" + "\n\n ¡¡¡¡¡¡¡¡¡¡¡PROMOCIÓN!!!!!!!!!!!\n"
				+ " ================================\n" + " ================================");

		// IMPRESIÓN INDAGANDO USER, ESPERA VALOR DE 0 A 30
		System.out.print("   Cuantos Mangos quieres? => ");

		// DOWHILE QUE GARANTIZA ENTRADA DENTRORANGO DEL ESTOQUE
		do {
			// IF CON MENSAJE INFORMANDO ERROR DE CANTIDAD
			if (mangoCantidadComprar > 30) {
				System.out.print("\n    SOLO HAY 30 UNIDADES!!!   " + "\n    *presione 0 para salir*      \n\n"
						+ "   Cuantos Mangos quieres? => ");
			}
			mangoCantidadComprar = sc.nextInt();
		} while (mangoCantidadComprar > 30 || mangoCantidadComprar < 0);

		// CERRAR LA VARIABLE DE ENTRADA DE DATOS
		sc.close();

		// PRINT DE CIERRE DE PEDIDO
		System.out.println(" ================================\n");

		// IF CASO HAYA COMPRA COM PROCESAMENTO DEL PEDIDO Y ACTUALIZACIÓN DE ESTOQUE
		if (mangoCantidadComprar > 0) {

			mangoValorPagado = mangoPrecio * mangoCantidadComprar;
			mangoEstoque -= mangoCantidadComprar;

			System.out.println(" ================================\n" + "       TOTAL A PAGAR: " + mangoValorPagado
					+ "€\n" + " ================================\n\n" + " ==============MANGO=============\n"
					+ "        Queda " + mangoEstoque + " en estoque!\n" + " ==============MANGO=============\n");
		}

		System.out.println("""
				 ================================
				GRACIAS POR VISITAR NUESTRA TIENDA
				 ================================\n
				""");

	}
}
