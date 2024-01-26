package act06;

import java.io.Serializable;
import java.util.Objects;

/**
 * La clase Empleado representa un objeto que almacena información sobre un
 * empleado, como su nombre, apellido y sueldo. Esta clase implementa la
 * interfaz Serializable, lo que significa que los objetos de esta clase se
 * pueden serializar y deserializar para ser almacenados en un archivo o
 * transmitidos a través de una red.
 * 
 * La clase tiene dos constructores, uno que recibe un nombre, un apellido y un
 * sueldo, y otro que recibe solo un nombre y un apellido. También tiene métodos
 * getters y setters para obtener y establecer los valores de las variables de
 * instancia nombre, apellido y sueldo.
 * 
 * Además, la clase tiene una variable de instancia clave marcada como
 * transient, lo que significa que esta variable no será serializada junto con
 * el objeto. Esta variable contiene una cadena que representa una clave de
 * acceso, lo que sugiere que la clave de acceso no debe ser serializada ni
 * transmitida, ya que se considera información confidencial.
 * 
 * La clase también implementa los métodos {@code hashCode()}, {@code equals()}
 * y {@code toString()} que se utilizan para comparar objetos de la clase y
 * representarlos en forma de cadena. El método {@code hashCode()} genera un
 * valor hash basado en los valores de las variables de instancia
 * {@code nombre}, {@code apellido} y {@code sueldo}, mientras que el método
 * {@code equals()} compara dos objetos de la clase en función de los valores de
 * sus variables de instancia. El método {@code toString()} devuelve una
 * representación en forma de cadena del objeto de la clase.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 *
 */
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	public Empleado(String nombre, String apellido, double sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
	}

	public Empleado(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, nombre, sueldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo);
	}

	@Override
	public String toString() {
		return "=> Empleado [nombre= " + nombre + ", apellido= " + apellido + ", sueldo= " + sueldo + "€]";
	}

	private String nombre;
	private String apellido;
	private double sueldo;
	private transient String clave = "patata";

}
