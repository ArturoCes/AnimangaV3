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
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianos.triana.dam.animanga.model.Categoria;
import com.salesianos.triana.dam.animanga.model.Mangaka;
import com.salesianos.triana.dam.animanga.service.CategoriaService;
import com.salesianos.triana.dam.animanga.service.MangakaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MangakaController {
	
	private final MangakaService mangakaService;
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
}
