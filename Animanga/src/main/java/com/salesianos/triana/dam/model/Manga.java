package com.salesianos.triana.dam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manga {
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String urlPortada;
	private double precio;
	private String nombre;
	@Column(length=10000)
	private String descripcion;
	private String editorial;
	private int numPags;
	private String isbn10;
	private double pesoProducto;
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Mangaka autor;
	//Constructor

	public Manga(String urlPortada, String nombre, String descripcion, String editorial, int numPags, String isbn10,
			double pesoProducto, Mangaka autor,Categoria categoria) {
		super();
		this.urlPortada = urlPortada;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.editorial = editorial;
		this.numPags = numPags;
		this.isbn10 = isbn10;
		this.pesoProducto = pesoProducto;
		this.autor = autor;
		this.categoria=categoria;
	}
	
	
	//Getters & Setters
	
	
	
	
}
