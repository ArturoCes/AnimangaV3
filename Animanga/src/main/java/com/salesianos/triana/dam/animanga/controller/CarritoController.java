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
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.animanga.model.Categoria;
import com.salesianos.triana.dam.animanga.model.Manga;
import com.salesianos.triana.dam.animanga.service.CarritoService;
import com.salesianos.triana.dam.animanga.service.CategoriaService;
import com.salesianos.triana.dam.animanga.service.MangaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	private CarritoService carritoService;
	@Autowired
	private MangaService mangaService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/mostrarCarrito") 
	public String showCarrito(Model model) {

		List<Categoria> categorias = categoriaService.findAll();

		model.addAttribute("categorias", categorias);

		model.addAttribute("products", carritoService.getProductsCarrito());

		return "cart";
	}

	@GetMapping("/productoACarrito/{id}") 
	public String productoACarrito(@PathVariable("id") long id, Model model) {

		Optional<Manga> comprobar = mangaService.findById(id);

		if (comprobar.isPresent()) {
			carritoService.addProducto(comprobar.get());
			return "redirect:/carrito/mostrarCarrito";
		} else {

			return "redirect:/";
		}
	}

	@GetMapping("/borrarProducto/{id}")
	public String removeProductFromCart(@PathVariable("id") Long id) {

		carritoService.removeManga(mangaService.findById(id));
		return "redirect:/carrito/mostrarCarrito";
	}

	@GetMapping("/checkout")
	public String checkout() {

		carritoService.cerrarTicket();
		return "redirect:/manga";

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
