package com.salesianos.triana.dam.animanga.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.animanga.model.LineaDeVenta;
import com.salesianos.triana.dam.animanga.repository.ILineaDeVentaRepositorio;
import com.salesianos.triana.dam.animanga.service.base.BaseService;

@Service
public class LineaDeVentaService extends BaseService<LineaDeVenta, Long, ILineaDeVentaRepositorio>{

	public List <LineaDeVenta> findByTicket(Long id){
		return this.repositorio.findByTicketId(id);
	}
}