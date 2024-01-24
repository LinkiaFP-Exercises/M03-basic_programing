package act05.ejercicio01.cuentaCorriente.model;

import java.text.NumberFormat;
import java.util.Locale;

import act05.Utilidades;

/**
 * @author Fauno Guazina
 */
public final class Cuenta {

	// Variables básicas solicitadas por el ejercício

	private final long numeroCuenta;
	private double saldo;
	private String nombreTitular;
	public static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));

	// Constructor único
	public Cuenta(long numeroCuenta, double saldo, String nombreTitular) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.nombreTitular = nombreTitular;
	}

	// GETTERS & SETTERS

	public final double getSaldo() {
		return saldo;
	}

	public final String getSaldoFormated() {
		return currencyFormatter.format(this.getSaldo());
	}

	public final void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Sobrecarga de setter
	public final void setSaldo() {
		this.saldo = Utilidades.pedirDecimal("Informe el SALDO a Ingresar => ");
	}

	public final String getNombreTitular() {
		return nombreTitular;
	}

	public final void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	// no hay setter de NumeroCuenta para que no se pueda cambiar
	public final long getNumeroCuenta() {
		return numeroCuenta;
	}

	@Override
	public String toString() {
		return "Cuenta Nº : " + this.getNumeroCuenta() + " | " + "Titular : " + this.getNombreTitular() + " | "
				+ "Saldo : " + currencyFormatter.format(this.getSaldo());
	}

}
