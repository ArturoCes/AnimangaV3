package com.salesianos.triana.dam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.model.Categoria;
import com.salesianos.triana.dam.model.Manga;
import com.salesianos.triana.dam.model.Mangaka;
import com.salesianos.triana.dam.repository.IMangakaRepositorio;
import com.salesianos.triana.dam.service.CategoriaService;
import com.salesianos.triana.dam.service.MangaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class MangaController {
	private final MangaService mangaService;
	private final CategoriaService categoriaService;
	private final IMangakaRepositorio mangakaRepository;

	@GetMapping({ "/", "/manga" })
	public String index(Model model, @RequestParam("q") Optional<String> consulta) {

		List<Manga> mangas = new ArrayList<>();
		if (consulta.isEmpty()) {
			for (Manga manga : mangaService.findAll()) {
				mangas.add(manga);

			}
			model.addAttribute("mangas", mangas);
			
		} else {
			mangas = mangaService.findByNombre(consulta.get());
		}
	
		model.addAttribute("mangas", mangas);		

		return"index";

}

	@GetMapping("/manga/{id}")
	public String mangaporId(@PathVariable("id") Long mangaId, Model model) {
		Manga m = mangaService.findById(mangaId);
		model.addAttribute("manga", m);

		return "manga";
	}
	

	@GetMapping("/manga/categoria/{id}")
	public String mangaPorCat(Model model, @PathVariable("id") Long catId) {
		
		Categoria c = categoriaService.findById(catId);
		
		List<Manga> mangas = new ArrayList<>();
		for (Manga manga : mangaService.findByCategoria(catId)) {
			mangas.add(manga);

		}
		model.addAttribute("mangas", mangas);
		model.addAttribute("categoria",c);

		return "categorias";
	}

	@ModelAttribute("categorias")
	public List<Categoria> categorias() {
		return categoriaService.findAll();
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long mangaId, Model model) {
		Manga m = mangaService.findById(mangaId);
		mangaService.delete(m);
		return "redirect:/";
	}

	@PostMapping({ "/submit", "/submit/{id}" })
	public String procesaFormulario(@ModelAttribute("manga") Manga manga) {
		mangakaRepository.save(manga.getAutor());
		mangaService.save(manga);
		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long mangaId, Model model) {
		Manga m = mangaService.findById(mangaId);
		model.addAttribute(m);

		return "formulario";
	}

	@GetMapping("/categorias/{id}")
	public String categorias(Model model, @PathVariable("id") Long catId) {

		List<Manga> mangas = new ArrayList<>();
		for (Manga manga : mangaService.findByCategoria(catId)) {
			mangas.add(manga);

		}
		model.addAttribute("mangas", mangas);

		return "categorias";
	}

	@GetMapping("/form")
	public String muestraFormulario(Model model) {
		model.addAttribute("manga", new Manga());
		return "formulario";
	}

	@GetMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("mangas", mangaService.findAll());
		return "lista";
	}

}
