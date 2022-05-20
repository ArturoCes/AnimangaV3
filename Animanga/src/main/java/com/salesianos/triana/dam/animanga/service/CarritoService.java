package com.salesianos.triana.dam.animanga.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianos.triana.dam.animanga.model.Carrito;
import com.salesianos.triana.dam.animanga.model.LineaDeVenta;
import com.salesianos.triana.dam.animanga.model.Manga;
import com.salesianos.triana.dam.animanga.repository.ICarritoRepositorio;
import com.salesianos.triana.dam.animanga.repository.IMangaRepositorio;
import com.salesianos.triana.dam.animanga.service.base.BaseService;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService extends BaseService<Carrito, Long, ICarritoRepositorio> {
	@Autowired
	private LineaDeVentaService lineaDeVentaServicio;
	
	@Autowired
	private IMangaRepositorio mangaRepositorio;
	
	private Map<Manga, Integer> mangas = new HashMap<>();

	public Map<Manga, Integer> getProductsCarrito() {
		return Collections.unmodifiableMap(mangas);
	}
	
	
	public void addProducto (Manga m) {
		if (mangas.containsKey(m)) {
			mangas.replace(m, mangas.get(m)+1);
		}else {
			mangas.put(m, 1);
		}
	}

	public void removeManga(Optional<Manga> optional) {// elimina un producto
		if (mangas.containsKey(optional.get())) {// comprueba si existeel producto en el map
			if (mangas.get(optional.get()) > 1)// comprueba si hay más de un productod el mismo tipo
				mangas.replace(optional.get(), mangas.get(optional.get()) - 1);// le resta 1
			else if (mangas.get(optional.get()) == 1) {
				mangas.remove(optional.get());// si no, lo elimina
			}
		}

	}
	public void cerrarTicket() {
		List<LineaDeVenta> listaLineasDeVenta =new ArrayList<LineaDeVenta>();
		Carrito carrito;
		double total=0;
		for (Map.Entry<Manga, Integer> lineaDeVenta : mangas.entrySet()) {//
			
			
			listaLineasDeVenta.add(
					LineaDeVenta.builder()
					.manga(lineaDeVenta.getKey())
					.cantidad(lineaDeVenta.getValue())
					.subtotal(lineaDeVenta.getKey().getPrecio() * lineaDeVenta.getValue())
					.build()
					);
			
			total+=total+(lineaDeVenta.getKey().getPrecio() * lineaDeVenta.getValue());
		}
		//build del carrito
		carrito = Carrito.builder()
		.fecha(LocalDateTime.now())
		.total(total)		
		.build();
		
		if(!listaLineasDeVenta.isEmpty()) {
			this.save(carrito);
			for (LineaDeVenta lineaDeVenta : listaLineasDeVenta) {
				lineaDeVenta.addToTicket(carrito);
				lineaDeVentaServicio.save(lineaDeVenta);
				
			}
			mangaRepositorio.flush();
			mangas.clear();
			
		}
		
		
	}
}