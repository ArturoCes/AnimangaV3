package com.salesianos.triana.dam.animanga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mangaka {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMangaka;
	private String nombre;
	private int edad;
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "autor", fetch=FetchType.EAGER)
	private List<Manga> obras = new ArrayList<>();
	private String urlPortada;
	@Column(length=1000)
	private String biografia;
	
	
	public Mangaka(String nombre, int edad, String urlPortada, String biografia) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.urlPortada = urlPortada;
		this.biografia = biografia;
	}
	
	

	
}
