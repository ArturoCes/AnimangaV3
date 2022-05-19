package com.salesianos.triana.dam.animanga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianos.triana.dam.animanga.model.Categoria;
import com.salesianos.triana.dam.animanga.model.Manga;
import com.salesianos.triana.dam.animanga.repository.ICategoriaRepositorio;
import com.salesianos.triana.dam.animanga.service.CategoriaService;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private ICategoriaRepositorio categoriaRepository;
	@Autowired
	private CategoriaService categoriaService;
		
	@GetMapping("/form")
	public String muestraFormulario(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "formularioCategoria";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long catId, Model model) {
		Categoria c = categoriaService.findById(catId);
		categoriaService.delete(c);
		return "redirect:/";
	}

	@PostMapping({ "/submit", "/submit/{id}" })
	public String procesaFormulario(@ModelAttribute("categoria") Categoria categoria) {
		
		categoriaService.save(categoria);
		return "redirect:/";
	}
	
	@GetMapping("/gestionCategoria")
	public String lista(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());
		return "listaCategorias";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long categoriaId, Model model) {
		Categoria c = categoriaService.findById(categoriaId);
		model.addAttribute(c);

		return "formularioCategoria";
	}
		
		
}	
