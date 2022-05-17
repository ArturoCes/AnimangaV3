package com.salesianos.triana.dam.service;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.model.Categoria;
import com.salesianos.triana.dam.repository.ICategoriaRepositorio;
import com.salesianos.triana.dam.service.base.BaseService;
@Service
public class CategoriaService extends  BaseService<Categoria, Long, ICategoriaRepositorio>{

}
