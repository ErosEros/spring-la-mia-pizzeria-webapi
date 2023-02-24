package com.corsojava.pizzeria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corsojava.pizzeria.model.Pizza;
import com.corsojava.pizzeria.repo.PizzaRepo;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiPizzeriaController {

	@Autowired
	PizzaRepo pizzaRepo;
	
	
	@GetMapping
	public List<Pizza> index(){
		return pizzaRepo.findAll();
	}
	
	@GetMapping("{id}")		//dettaglio
	public ResponseEntity<Pizza> detail(@PathVariable("id") Integer id) {
		Optional<Pizza> res=pizzaRepo.findById(id);
		if (res.isPresent()) 
			return new ResponseEntity<Pizza>(res.get(), HttpStatus.OK);
	    else
	    	return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create")
	public Pizza create(@RequestBody Pizza pizza) {
		return pizzaRepo.save(pizza);
	}
	
	@DeleteMapping("{id}")
	public void delete(
			@PathVariable("id") Integer id) {
		pizzaRepo.deleteById(id);
	}
	@PutMapping("{id}")	
	public Pizza update(@RequestBody Pizza Pizza,
			@PathVariable("id") Integer id) {
		Pizza p=pizzaRepo.getReferenceById(id);
		p.setNome(Pizza.getNome());
		return pizzaRepo.save(p);
	}
}
