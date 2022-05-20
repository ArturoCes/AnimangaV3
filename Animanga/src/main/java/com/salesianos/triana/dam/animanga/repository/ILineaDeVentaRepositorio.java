package com.salesianos.triana.dam.animanga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianos.triana.dam.animanga.model.LineaDeVenta;

public interface ILineaDeVentaRepositorio extends JpaRepository<LineaDeVenta, Long>{

	public List<LineaDeVenta> findByTicketId(Long id);
	
}