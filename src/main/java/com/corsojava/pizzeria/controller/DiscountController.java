package com.corsojava.pizzeria.controller;

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

import com.corsojava.pizzeria.model.Discount;
import com.corsojava.pizzeria.model.Pizza;
import com.corsojava.pizzeria.repo.DiscountRepository;
import com.corsojava.pizzeria.repo.PizzaRepo;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/discount")
public class DiscountController {


	@Autowired
	PizzaRepo pizzaRepo;

	@Autowired
	DiscountRepository discountRepo;


	@GetMapping("/create")		
	public String create(
		@RequestParam(name="id", required = true) Integer id,
		Model model) throws Exception {

		Discount discount =new Discount();	//non esiste ancora sul DB


		Pizza pizza = pizzaRepo.getReferenceById(id);
		discount.setPizza(pizza);

		model.addAttribute("discount", discount);

		return "/createD";
	}

	@PostMapping("/create")  	//gestirà le richieste di tipo POST di tipo /create
	public String store(
		@Valid @ModelAttribute("discount") Discount formDiscount, 
		BindingResult bindingResult,
		Model model){

		if (bindingResult.hasErrors())
			return "createD";


		discountRepo.save(formDiscount);

		return "redirect:/"; //genera un altro get

	}

	
	@GetMapping("/edit/{id}") //GESTISCE LE RICHIESTEDEL TIPO /discount/EDIT/ID
	public String edit(@PathVariable("id") Integer id,Model model ) {

		Discount discount;
		discount = discountRepo.getReferenceById(id);
		model.addAttribute("discount", discount);

		return "editD";
	}

	@PostMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute Discount formPizzeria,
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors())
			return "editD";

		discountRepo.save(formPizzeria);

		return "redirect:/";

	}	
}