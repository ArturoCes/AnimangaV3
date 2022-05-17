package com.salesianos.triana.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianos.triana.dam.model.Manga;

public interface IMangaRepositorio extends JpaRepository<Manga, Long> {

	public List<Manga> findByCategoriaIdCategoria(Long id);
	
	@Query("Select m from Manga m WHERE lower(m.nombre) LIKE lower(concat('%', :nombre,'%')) ")
	public List<Manga> findByNombreIgnoreCaseContainsOrderByNombreAsc(String nombre);
}
