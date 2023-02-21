package com.corsojava.pizzeria.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corsojava.pizzeria.model.Pizza;
import com.corsojava.pizzeria.repo.PizzaRepo;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/")
public class PizzaController {

	@Autowired
    PizzaRepo pizzaRepo;

	@GetMapping
	public String index(Model model) {
		List<Pizza> ListaPizze = pizzaRepo.findAll();
		model.addAttribute("listaPizze", ListaPizze);
		return "index";
	}
	
	
	
	
	@GetMapping("/details/{id}")		
	public String details(@PathVariable("id") Integer id, Model model) {
		Pizza pizza=pizzaRepo.getReferenceById(id);
		model.addAttribute("pizza", pizza);
		return "details";
	
	}
	
//	PER FILTRARE LE PIZZE IN BASE AL NOME INSERITO DALL'UTENTE
	@GetMapping("/cerca")
	public String cerca(@RequestParam(name="nomePizza", required = false) String nomePizza, Model model) {
	    List<Pizza> listaPizze;
	    if (nomePizza != null) {
	        listaPizze = pizzaRepo.findByNomeLike("%" + nomePizza + "%");
	    } else {
	        listaPizze = pizzaRepo.findAll();
	    }
	    model.addAttribute("listaPizze", listaPizze);
	    return "index";
	}
	
//	CREATE
	@GetMapping("/create")	
	public String create(Model model) {
		Pizza pizza=new Pizza();
		model.addAttribute("pizza", pizza);
		return "create";
	}
	
	@PostMapping("/create")
	public String store(
		@Valid @ModelAttribute("pizza") Pizza formPizza, 
		BindingResult bindingResult,
		Model model){
		
		if (bindingResult.hasErrors())
			return "/create";
		
		pizzaRepo.save(formPizza);
		return "redirect:/";
		
	}
	
//	EDIT
	@GetMapping("/edit/{id}") 
	public String edit(@PathVariable("id") Integer id,Model model ) {
		
		Pizza p;
		p = pizzaRepo.getReferenceById(id);
		model.addAttribute("pizza", p);
		
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute Pizza formPizza,
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors())
			return "edit";
		
		pizzaRepo.save(formPizza);
		
		return "redirect:/";
		
	}
	
}
