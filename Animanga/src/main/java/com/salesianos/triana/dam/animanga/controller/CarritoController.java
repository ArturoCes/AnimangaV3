package com.salesianos.triana.dam.animanga.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianos.triana.dam.animanga.model.Categoria;
import com.salesianos.triana.dam.animanga.model.Manga;
import com.salesianos.triana.dam.animanga.service.CarritoService;
import com.salesianos.triana.dam.animanga.service.CategoriaService;
import com.salesianos.triana.dam.animanga.service.MangaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CarritoController {

	@Autowired
	private CarritoService carritoService;
	@Autowired
	private MangaService mangaService;

	
	@Autowired
	private CategoriaService categoriaService;


	@GetMapping("private/mostrarTicket") // Se encarga de mostrar todo lo que esté añadido al carrito, en mi caso será
											// igual
	public String showCarrito(Model model) {
	
	List<Categoria> categorias = new ArrayList<Categoria>();

	for (Categoria cat : categoriaService.findAll()) {

		categorias.add(cat);
	}

	model.addAttribute("categorias", categorias);
	

	model.addAttribute("products", carritoService.getProductsCarrito());

	return "/private/Ticket";
}	
		

	@GetMapping("private/productoACarrito/{id}") // añade un producto al carrito
	public String productoACarrito(@PathVariable("id") long id, Model model) {

		Optional<Manga> comprobar = mangaService.findById(id);

		if (comprobar.isPresent()) {
			carritoService.addProducto(comprobar.get());// se hará igual
			return "redirect:/private/mostrarTicket";
		} else {
			// No existe ningún categoria con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/";
		}
	}

	@GetMapping("/private/borrarProducto/{id}")
	public String removeProductFromCart(@PathVariable("id") Long id) {

		carritoService.removeManga(mangaService.findById(id));
		return "redirect:/private/mostrarTicket";
	}
	
	
	@GetMapping("/private/cerrarTicket")
	public String checkout() {		
		
			carritoService.cerrarTicket();
			return "redirect:/private/categorias";
		
	}

	@ModelAttribute("total_carrito")
	public Double totalCarrito() {

		Map<Manga, Integer> carrito = carritoService.getProductsCarrito();
		double total = 0.0;
		if (carrito != null) {
			for (Manga m : carrito.keySet()) {
				total += m.getPrecio() * carrito.get(m);
			}
			return total;
		}

		return 0.0;
	}
}
	