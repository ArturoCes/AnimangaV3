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
import com.salesianos.triana.dam.animanga.service.MangaService;

/**
 * 
 * @author Arturo Céspedes Pedrazas Este controlador se utiliza para gestionar
 *         las categorías Crear, editar y eliminar estas mismas.
 */

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaRepositorio categoriaRepository;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private MangaService mangaService;

	/**
	 * 
	 * @param model lo usaremos para crear una categoría
	 * 
	 * @return nos devuelve un formulario, para la creación de una categoría nueva.
	 */
	@GetMapping("/form")
	public String muestraFormulario(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "formularioCategoria";
	}

	/**
	 * 
	 * @param catId Es el nombre que se le da a la variable que representa el id de
	 *              la categoría.
	 * @param model es el parametro que se le da para poder añadir el objeto para
	 *              poder guardarlo a la lista de una categoría,
	 * @return nos redirecciona a la misma página al terminar el proceso de
	 *         eliminar.
	 */

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long catId, Model model) {
		Categoria c = categoriaService.findById(catId);
		Categoria c2 = categoriaService.findById(4L);
		for (Manga m : c.getListaMangas()) {

			m.addCategoria(c2);

			mangaService.save(m);
		}

		categoriaService.delete(c);
		return "redirect:/";
	}

	/**
	 * 
	 * @param categoria Le pasamos este parámetro para que nos guarde los datos
	 *                  modificados con el .save.
	 * @return nos redirecciona a la página de inicio
	 */
	@PostMapping({ "/submit", "/submit/{id}" })
	public String procesaFormulario(@ModelAttribute("categoria") Categoria categoria) {

		categoriaService.save(categoria);
		return "redirect:/categoria/gestionCategoria";
	}

	/**
	 * 
	 * @param model es el parametro que le para poder añadir el objeto encontrado
	 *              para hacer cosas con el.
	 * @return nos devuelve un html de un listado de las categorías.
	 */
	@GetMapping("/gestionCategoria")
	public String lista(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());
		return "listaCategorias";
	}

	/**
	 * 
	 * @param categoriaId Es el id de la categoria y en este método se utiliza para
	 *                    editar las características de la misma.
	 * @param model       es el parametro que le para poder añadir el objeto
	 *                    encontrado para poder modificarlo
	 * @return nos devuelve el formulario de la categoria.
	 */

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long categoriaId, Model model) {
		Categoria c = categoriaService.findById(categoriaId);
		model.addAttribute(c);

		return "formularioCategoria";
	}
	
}
