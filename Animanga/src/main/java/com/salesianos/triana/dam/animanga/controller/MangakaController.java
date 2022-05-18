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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.animanga.model.Categoria;
import com.salesianos.triana.dam.animanga.model.Manga;
import com.salesianos.triana.dam.animanga.model.Mangaka;
import com.salesianos.triana.dam.animanga.service.CategoriaService;
import com.salesianos.triana.dam.animanga.service.MangakaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/mangaka")
public class MangakaController {
	
	@Autowired
	private  MangakaService mangakaService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/mangakas")
	public String index(Model model, @RequestParam("q") Optional<String> consulta) {

		List<Mangaka> mangakas = new ArrayList<>();
		if (consulta.isEmpty()) {
			for (Mangaka mangaka : mangakaService.findAll()) {
				mangakas.add(mangaka);

			}
			model.addAttribute("mangakas", mangakas);

		}
		return "mangakas";
	}
	@ModelAttribute("categorias")
	public List<Categoria> categorias() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/mangaka/{id}")
	public String mangaporId(@PathVariable("id") Long mangakaId, Model model) {
		Mangaka m = mangakaService.findById(mangakaId);
		model.addAttribute("mangaka", m);

		return "mangaka";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long mangakaId, Model model) {
		Mangaka m = mangakaService.findById(mangakaId);
		mangakaService.delete(m);
		return "redirect:/";
	}

	@PostMapping({ "/submit", "/submit/{id}" })
	public String procesaFormulario(@ModelAttribute("manga") Mangaka mangaka) {
		
		mangakaService.save(mangaka);
		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long mangakaId, Model model) {
		Mangaka m = mangakaService.findById(mangakaId);
		model.addAttribute(m);

		return "formulario";
	}

	@GetMapping("/form")
	public String muestraFormulario(Model model) {
		model.addAttribute("mangaka", new Mangaka());
		return "formularioMangaka";
	}
	
}
