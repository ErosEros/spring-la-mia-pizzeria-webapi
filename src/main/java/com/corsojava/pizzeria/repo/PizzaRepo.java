package com.corsojava.pizzeria.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corsojava.pizzeria.model.Pizza;

public interface PizzaRepo extends JpaRepository<Pizza, Integer> {

	 List<Pizza> findByNomeLike(String nome);

}
