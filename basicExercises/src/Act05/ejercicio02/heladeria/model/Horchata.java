package act05.ejercicio02.heladeria.model;

/**
 * @author Fauno Guazina
 */
public final class Horchata extends Comida {

	// VARIABLES PRIVADAS POR ENCAPSULAMIENTO
	private int cantidad;
	private horchatas horchata;

	// CONSTRUCTOR QUE LLAMA A LA CLASE MADRE
	public Horchata(horchatas horchata, int cantidad) {
		super("Horchata", horchata.name(), (horchata.precioLitro * cantidad));
		this.cantidad = cantidad;
		this.horchata = horchata;
	}

	// GETTERS & SETTERS

	public final horchatas getHorchata() {
		return horchata;
	}

	public final int getCantidad() {
		return cantidad;
	}

	public final void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public final int getChufaPerCent() {
		return horchata.chufaPerCent;
	}

	public final int getKcal() {
		return horchata.kcal;
	}

	public final String getPrecioFormated() {
		return currencyFormatter.format(getPrecio());
	}

	@Override
	public String toString() {
		return getProducto() + " " + getNombre() + " con " + getChufaPerCent() + "% de Chufa" + ", Cantidad:"
				+ getCantidad() + "ml" + "\n>>>>>>>> POR EL PRECIO DE " + getPrecioFormated();
	}

	/**
	 * @author Fauno Guazina : He decidido crear estructuras básicas para cada sabor
	 *         de horchata con esta clase ENUN, ya que pensé que estos valores no se
	 *         cambian y que un dependiente no tiene que estar poniendo el precio o
	 *         las características del producto.
	 */
	public enum horchatas {

		Tradicional(0.01, 30, 20), Plus(0.015, 50, 60), Premiun(0.025, 70, 100);

		double precioLitro;
		int chufaPerCent;
		int kcal;

		private horchatas(double precioLitro, int chufaPerCent, int kcal) {
			this.precioLitro = precioLitro;
			this.chufaPerCent = chufaPerCent;
			this.kcal = kcal;
		}

	}

}
