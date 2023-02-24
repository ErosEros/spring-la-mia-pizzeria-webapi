package com.corsojava.pizzeria.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Discount {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private LocalDate StartDiscountDate;

	@NotNull
	private LocalDate EndDiscountDate;
	
	private String Titolo;

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalDate getStartDiscountDate() {
		return StartDiscountDate;
	}



	public void setStartDiscountDate(LocalDate startDiscountDate) {
		StartDiscountDate = startDiscountDate;
	}



	public LocalDate getEndDiscountDate() {
		return EndDiscountDate;
	}



	public void setEndDiscountDate(LocalDate endDiscountDate) {
		EndDiscountDate = endDiscountDate;
	}



	public String getTitolo() {
		return Titolo;
	}



	public void setTitolo(String titolo) {
		Titolo = titolo;
	}



	public Pizza getPizza() {
		return pizza;
	}



	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}



	
	@ManyToOne	
	@JsonBackReference							
	private Pizza pizza; 		
}
