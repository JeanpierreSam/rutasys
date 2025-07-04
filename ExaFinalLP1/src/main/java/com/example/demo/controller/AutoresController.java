package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Autores;
import com.example.demo.service.AutoresService;

@Controller
public class AutoresController {
	@Autowired
	private AutoresService autoresService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("autores", autoresService.readAll());
		return "index"; // vista: src/main/resources/templates/index.html
	}

	@GetMapping("/add")
	public String addAutor(Model model) {
		model.addAttribute("autor", new Autores());
		return "add"; // vista: src/main/resources/templates/add.html
	}

	@GetMapping("/edit/{id}")
	public String editAutor(@PathVariable("id") int id, Model model) {
		model.addAttribute("autor", autoresService.read(id));
		return "edit";
	}

	@GetMapping("/del/{id}")
	public String deleteAutor(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		autoresService.delete(id);
		redirectAttributes.addFlashAttribute("flashMessage", "Autor eliminado correctamente");
		return "redirect:/";
	}

	@PostMapping("/save")
	public String saveAutor(@Valid Autores autor, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "add";
		}
		autoresService.create(autor);
		return "redirect:/";
	}

	@PostMapping("/update/{id}")
	public String updateAutor(@PathVariable("id") int id, @Valid Autores autor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "edit";
		}
		Autores a = autoresService.read(id);
		a.setNombres(autor.getNombres());
		a.setApellidos(autor.getApellidos());
		a.setPais(autor.getPais());
		a.setEstado(autor.getEstado());
		autoresService.update(a);
		model.addAttribute("autores", autoresService.readAll());
		return "index";
	}
}
