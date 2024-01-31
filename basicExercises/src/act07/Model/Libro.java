package act07.Model;

import java.util.Objects;

/**
 * La clase Libro tiene seis atributos: id_libro, titulo, autor, pais, paginas y
 * genero.
 *
 * Además, cuenta con un constructor que recibe como parámetros los valores de
 * cada atributo, así como sus correspondientes getters y setters para acceder a
 * los valores de cada atributo.
 *
 * La clase también cuenta con los métodos hashCode, equals y toString, que son
 * utilizados para manejar la comparación de objetos y representación en forma
 * de texto de objetos de esta clase.
 *
 * @author Fauno Guazina
 */
public class Libro {
	private int id_libro;
	private String titulo;
	private Autor autor;
	private String pais;
	private int paginas;
	private String genero;

	public Libro(int id_libro, String titulo, Autor autor, String pais, int paginas, String genero) {
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.autor = autor;
		this.pais = pais;
		this.paginas = paginas;
		this.genero = genero;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + this.id_libro;
		hash = 97 * hash + Objects.hashCode(this.titulo);
		hash = 97 * hash + Objects.hashCode(this.autor);
		hash = 97 * hash + Objects.hashCode(this.pais);
		hash = 97 * hash + this.paginas;
		hash = 97 * hash + Objects.hashCode(this.genero);
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
		final Libro other = (Libro) obj;
		if (this.id_libro != other.id_libro) {
			return false;
		}
		if (this.paginas != other.paginas) {
			return false;
		}
		if (!Objects.equals(this.titulo, other.titulo)) {
			return false;
		}
		if (!Objects.equals(this.pais, other.pais)) {
			return false;
		}
		if (!Objects.equals(this.genero, other.genero)) {
			return false;
		}
		return Objects.equals(this.autor, other.autor);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Libro{");
		sb.append("id_libro=").append(id_libro);
		sb.append(", titulo=").append(titulo);
		sb.append(", autor=").append(autor.getNombre() + " " + autor.getApellido());
		sb.append(", pais=").append(pais);
		sb.append(", paginas=").append(paginas);
		sb.append(", genero=").append(genero);
		sb.append('}');
		return sb.toString();
	}

}
