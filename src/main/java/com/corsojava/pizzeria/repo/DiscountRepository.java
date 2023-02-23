package com.corsojava.pizzeria.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corsojava.pizzeria.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount , Integer>{

}
