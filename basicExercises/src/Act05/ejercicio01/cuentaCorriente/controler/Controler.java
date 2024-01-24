package act05.ejercicio01.cuentaCorriente.controler;

import static act05.ejercicio01.cuentaCorriente.view.AuxiliaryMain.*;
import static act05.Utilidades.*;

import java.util.Arrays;

import act05.ejercicio01.cuentaCorriente.model.Cuenta;

public class Controler {

	/**
	 * La función consultarSaldo() permite al usuario consultar el saldo de una
	 * cuenta bancaria en particular.
	 * 
	 * Primero, la función llama a printTitulo_pideNumCuenta_findCuenta("CONSULTA
	 * SALDO"), la cual muestra un título en pantalla, solicita al usuario que
	 * ingrese un número de cuenta y devuelve la cuenta correspondiente, utilizando
	 * el método getNumeroCuenta() de la clase Cuenta para filtrar la cuenta del
	 * arreglo BANCO que coincide con el número ingresado por el usuario.
	 * 
	 * Luego, la función muestra en pantalla el resultado de la consulta del saldo,
	 * utilizando el método toString() de la clase Cuenta para imprimir los detalles
	 * de la cuenta, y separa el resultado con una línea de separación definida por
	 * la constante separador.
	 * 
	 * Finalmente, la función llama a turnToMenu() para volver al menú principal del
	 * programa.
	 */
	public static void consultarSaldo() {
		Cuenta cuenta = printTitulo_pideNumCuenta_findCuenta("CONSULTA SALDO");
		println(cuenta.toString(), separador);
		turnToMenu();
	}

	/**
	 * La función ingresarDinero permite al usuario ingresar una cantidad de dinero
	 * en la cuenta bancaria especificada.
	 * 
	 * Primero, llama a la función printTitulo_pideNumCuenta_findCuenta con el
	 * argumento "INGRESAR DINERO" para obtener la cuenta en la que se va a realizar
	 * la operación.
	 * 
	 * Luego, la función llama a la función pedirDecimal para solicitar al usuario
	 * la cantidad que desea ingresar. La función pedirDecimal valida la entrada del
	 * usuario para asegurarse de que se ingrese un número decimal válido.
	 * 
	 * A continuación, se actualiza el saldo de la cuenta con la cantidad ingresada
	 * utilizando el método setSaldo de la clase Cuenta.
	 * 
	 * Por último, se imprime un mensaje que indica que el saldo ha sido actualizado
	 * y se muestra la información actualizada de la cuenta. Luego se llama a la
	 * función turnToMenu para volver al menú principal.
	 */
	public static void ingresarDinero() {
		Cuenta cuenta = printTitulo_pideNumCuenta_findCuenta("INGRESAR DINERO");
		println(cuenta.toString());
		
		double cantidadIngresar = pedirDecimal("CANTIDAD A INGRESAR => €");
		cuenta.setSaldo(cuenta.getSaldo() + cantidadIngresar);
		
		println("--- SALDO ACTUALIZADO ---", cuenta.toString(), separador);
		turnToMenu();

	}

	/**
	 * Esta función implementa la funcionalidad de retirar dinero de una cuenta
	 * bancaria. Primero, se llama a la función printTitulo_pideNumCuenta_findCuenta
	 * para solicitar el número de cuenta del usuario y obtener la cuenta
	 * correspondiente. Luego, se solicita la cantidad de dinero que se desea
	 * retirar utilizando la función pedirDecimal. La función verifica si la
	 * cantidad a retirar es mayor que el saldo actual de la cuenta. Si es así, se
	 * muestra un mensaje de error y se vuelve a solicitar la cantidad de dinero. Si
	 * la cantidad a retirar es menor o igual que el saldo actual, se actualiza el
	 * saldo de la cuenta y se muestra un mensaje indicando que la operación se ha
	 * realizado con éxito. Finalmente, se llama a turnToMenu para volver al menú
	 * principal.
	 */
	public static void sacarDinero() {
		Cuenta cuenta = printTitulo_pideNumCuenta_findCuenta("SACAR DINERO");
		println(cuenta.toString());
		
		double cantidadSacar;
		do {
			cantidadSacar = pedirDecimal("CANTIDAD A SACAR => €");
			if (cantidadSacar > cuenta.getSaldo())
				println("¡¡¡ SAQUE NO PUEDE SER MAYOR QUE SALDO !!!");
		} while (cantidadSacar > cuenta.getSaldo());
		
		cuenta.setSaldo(cuenta.getSaldo() - cantidadSacar);
		
		println("--- SALDO ACTUALIZADO ---", cuenta.toString(), separador);
		turnToMenu();

	}
	
	/**
	 * Esta función permite transferir dinero de una cuenta a otra. Primero se
	 * muestra un separador con el título "TRANSFERIR DINERO". Luego, se pide al
	 * usuario que ingrese el número de cuenta de origen y se busca la cuenta
	 * correspondiente en el banco. Se muestra la información de la cuenta de origen
	 * y se repite el proceso para la cuenta de destino.
	 * 
	 * Luego, se pide al usuario que ingrese la cantidad de dinero que desea
	 * transferir. Se verifica que la cantidad sea menor o igual al saldo de la
	 * cuenta de origen. Si la cantidad ingresada es mayor al saldo, se muestra un
	 * mensaje de error y se pide al usuario que ingrese una nueva cantidad.
	 * 
	 * Si la cantidad ingresada es válida, se resta de la cuenta de origen y se suma
	 * a la cuenta de destino. Luego se muestra la información actualizada de ambas
	 * cuentas y se vuelve al menú principal.
	 */
	public static void transferirDinero() {
		println(separadorConTitulo("TRANSFERIR DINERO"));
		Cuenta cuentaOrigen = printTitulo_pideNumCuenta_findCuenta("ORIGEN");
		println(cuentaOrigen.toString());
		Cuenta cuentaDestino = printTitulo_pideNumCuenta_findCuenta("DESTINO");
		println(cuentaDestino.toString());

		double cantidadTransferir;
		do {
			cantidadTransferir = pedirDecimal("CANTIDAD A TRANSFERIR => €");
			if (cantidadTransferir > cuentaOrigen.getSaldo())
				println("¡¡¡ TRANSFERENCIA NO PUEDE SER MAYOR QUE SALDO !!!");
		} while (cantidadTransferir > cuentaOrigen.getSaldo());

		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidadTransferir);
		cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidadTransferir);

		println("--- SALDOS ACTUALIZADO ---", cuentaOrigen.toString(), cuentaDestino.toString(), separador);
		turnToMenu();
	}

	/**
	 * la función utiliza el título pasado como argumento para imprimir un separador
	 * con el título en el medio. Luego, llama a la función pedirNumeroCuenta para
	 * obtener del usuario el número de cuenta. A continuación, utiliza el método
	 * stream de la clase Arrays para convertir el array de cuentas en un flujo de
	 * datos. A continuación, se utiliza el método filter para filtrar el flujo y
	 * dejar sólo las cuentas cuyo número de cuenta coincide con el ingresado por el
	 * usuario. Por último, utiliza el método findFirst para obtener la primera
	 * cuenta que cumpla la condición del filtro y devuelve esa cuenta.
	 * 
	 * @param Titulo operación que será ejecutada en este momento
	 * @return la intancia de la cuenta armazenada en el array BANCO
	 */
	private static Cuenta printTitulo_pideNumCuenta_findCuenta(String Titulo) {
		println(separadorConTitulo(Titulo));
		long userCuenta = pedirNumeroCuenta();
		return Arrays.stream(getBanco())
				.filter(c -> c.getNumeroCuenta() == userCuenta)
				.findFirst().get();
	}

}
