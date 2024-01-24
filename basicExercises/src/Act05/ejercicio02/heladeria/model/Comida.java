package act05.ejercicio02.heladeria.model;

/**
 * @author Fauno Guazina
 *
 */
public abstract class Comida implements Vendible {

	// variables basicas de la clase con modificador de acceso protected
	// para que las hijas puedan tener acceso a ellas y que no sean públicas
	private static String tipo = "comida";
	private String producto;
	private String nombre;
	private double precio;

	// he cambiado el constructor para alterar el producto, ya que lo utilizaré en las hijas
	public Comida(String producto, String nombre, double precio) {
		super();
		this.producto = producto;
		this.nombre = nombre;
		this.precio = precio;
	}

	// GETTERS & SETTERS

	public static final String getTipo() {
		return tipo;
	}

	public final String getProducto() {
		return producto;
	}

	public final void setProducto(String tipo) {
		this.producto = tipo;
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// implementación de métodos de la interface Vendible
	public final double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Comida [Tipo:" + getProducto() + ", Nombre:" + getNombre() + ", Precio:"
				+ currencyFormatter.format(getPrecio()) + "]";
	}
}
