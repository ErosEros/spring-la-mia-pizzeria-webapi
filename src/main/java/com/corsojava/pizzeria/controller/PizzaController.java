package com.corsojava.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corsojava.pizzeria.model.Pizza;
import com.corsojava.pizzeria.repo.PizzaRepo;



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
}
