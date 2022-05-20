package com.salesianos.triana.dam.animanga.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.animanga.model.Categoria;
import com.salesianos.triana.dam.animanga.model.Manga;
import com.salesianos.triana.dam.animanga.model.Mangaka;
import com.salesianos.triana.dam.animanga.repository.IMangakaRepositorio;
import com.salesianos.triana.dam.animanga.service.CategoriaService;
import com.salesianos.triana.dam.animanga.service.MangaService;
import com.salesianos.triana.dam.animanga.service.MangakaService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Arturo Céspedes Pedrazas
 *
 */
@Controller
@RequiredArgsConstructor

public class MangaController {
	private final MangaService mangaService;
	private final CategoriaService categoriaService;
	private final IMangakaRepositorio mangakaRepository;
	@Autowired
	private MangakaService mangakaService;

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

		return "index";

	}

	@GetMapping("/manga/{id}")
	public String mangaporId(@PathVariable("id") Long mangaId, Model model) {
		Optional<Manga> m = mangaService.findById(mangaId);
		if (m.isPresent()) {
			model.addAttribute("manga", m.get());
		}

		return "manga";
	}

	@GetMapping("/manga/categoria/{id}")
	public String mangaPorCat(Model model, @PathVariable("id") Long catId) {

		Optional<Categoria> c = categoriaService.findById(catId);
		if (c.isPresent()) {
			List<Manga> mangas = new ArrayList<>();
			for (Manga manga : mangaService.findByCategoria(catId)) {
				mangas.add(manga);

			}
			model.addAttribute("mangas", mangas);
			model.addAttribute("categoria", c.get());
		}
		return "categorias";
	}

	@ModelAttribute("categorias")
	public List<Categoria> categorias() {
		return categoriaService.findAll();
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long mangaId, Model model) {
		Optional<Manga> m = mangaService.findById(mangaId);
		if (m.isPresent()) {
			mangaService.deleteById(mangaId);
		}

		return "redirect:/";
	}

	@PostMapping({ "/submit", "/submit/{id}" })
	public String procesaFormulario(@ModelAttribute("manga") Manga manga) {

		mangaService.save(manga);
		return "redirect:/lista";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long mangaId, Model model) {
		Optional<Manga> m = mangaService.findById(mangaId);
		if (m.isPresent()) {
			model.addAttribute(m.get());
		}

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

	@ModelAttribute("mangakas")
	public List<Mangaka> mangakas() {
		return mangakaService.findAll();
	}
	@GetMapping("/destacados" )
	public String destacados(Model model) {

		List<Manga> mangas = mangaService.buscarDestacados();
		

		model.addAttribute("mangas", mangas);

		return "index";

	}

}
