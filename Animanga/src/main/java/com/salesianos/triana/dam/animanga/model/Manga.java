package com.salesianos.triana.dam.animanga.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Arturo Céspedes Pedrazas Esta clase es una entidad que representa a
 *         un manga(comic).
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manga {
	/**
	 * Atributos
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String urlPortada;
	private double precio;
	private String nombre;
	@Column(length = 10000)
	private String descripcion;
	private String editorial;
	private int numPags;
	private String textoAlternativo;

	private String isbn10;
	private double pesoProducto;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude

	@ManyToOne

	private Categoria categoria;

	@ManyToOne
	private Mangaka autor;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	/**
	 * 
	 * @param urlPortada   es la imagen que se ve como portada de cada manga.
	 * @param nombre       es el nombre del manga.
	 * @param descripcion  es la descripción del manga
	 * @param editorial    Editorial a la que pertenece el manga.
	 * @param numPags      El número de páginas que tiene el manga
	 * @param isbn10       codigo del manga.
	 * @param pesoProducto es el peso del producto.
	 * @param autor        el creador del manga.
	 * @param categoria    categoria a la que pertenece un manga.
	 */

	public Manga(String urlPortada, String nombre, String descripcion, String editorial, int numPags, String isbn10,
			double pesoProducto, Mangaka autor, Categoria categoria) {
		super();
		this.urlPortada = urlPortada;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.editorial = editorial;
		this.numPags = numPags;
		this.isbn10 = isbn10;
		this.pesoProducto = pesoProducto;
		this.autor = autor;
		this.categoria = categoria;
	}

	/**
	 * 
	 * @param m es el parametro que le pasamos para poder borrar el mangaka que este
	 *          asignado a un manga.
	 */
	public void removeMangaka(Mangaka m) {
		m.getObras().remove(this);
		this.autor = null;
	}

	/**
	 * 
	 * @param c es el parametro que le pasamos para poder añadir una categoria a un
	 *          manga.
	 */
	public void addCategoria(Categoria c) {
		this.categoria = c;
		c.getListaMangas().add(this);

	}

	/**
	 * 
	 * @param c es el parametro que le pasamos para poder borrar la categoria que
	 *          este asignada a un manga.
	 */
	public void removeCategoria(Categoria c) {
		c.getListaMangas().remove(this);
		this.categoria = null;
	}

}
