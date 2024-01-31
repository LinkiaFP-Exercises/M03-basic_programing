package act07.Model;

import java.util.Objects;

/**
 * La clase Autor representa un autor de un libro en la aplicación. Contiene los
 * siguientes atributos:
 *
 * id_autor: un entero que representa el identificador del autor.
 *
 * nombre: una cadena de caracteres que representa el nombre del autor.
 *
 * apellido: una cadena de caracteres que representa el apellido del autor. La
 * clase cuenta con un constructor que recibe los tres atributos, así como
 * métodos getters y setters para cada atributo.
 *
 * Además, la clase sobrescribe los métodos equals, hashCode y toString. El
 * método equals se encarga de comparar dos objetos Autor y determinar si son
 * iguales. El método hashCode devuelve un código hash único para cada objeto
 * Autor. El método toString devuelve una cadena de caracteres que representa el
 * objeto Autor en formato legible para humanos.
 *
 * @author Fauno Guazina
 */
public class Autor {
	private int id_autor;
	private String nombre;
	private String apellido;

	public Autor(int id_autor, String nombre, String apellido) {
		this.id_autor = id_autor;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + this.id_autor;
		hash = 47 * hash + Objects.hashCode(this.nombre);
		hash = 47 * hash + Objects.hashCode(this.apellido);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Autor other = (Autor) obj;
		if (this.id_autor != other.id_autor) {
			return false;
		}
		if (!Objects.equals(this.nombre, other.nombre)) {
			return false;
		}
		return Objects.equals(this.apellido, other.apellido);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Autor{");
		sb.append("id_autor=").append(id_autor);
		sb.append(", nombre=").append(nombre);
		sb.append(", apellido=").append(apellido);
		sb.append('}');
		return sb.toString();
	}

}
