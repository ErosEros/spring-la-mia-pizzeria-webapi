package com.corsojava.pizzeria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corsojava.pizzeria.model.Pizza;

public interface PizzaRepo extends JpaRepository<Pizza, Integer> {

}
