package com.salesianos.triana.dam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.model.Manga;
import com.salesianos.triana.dam.repository.IMangaRepositorio;
import com.salesianos.triana.dam.service.base.BaseService;

@Service
public class MangaService extends BaseService<Manga, Long, IMangaRepositorio> {
	public List <Manga>findByCategoria(Long id){
		return this.repositorio.findByCategoriaIdCategoria(id);
		
		
	}
	public List<Manga> findByNombre(String nombre) {
		return this.repositorio.findByNombreIgnoreCaseContainsOrderByNombreAsc(nombre);
	}
}
