package com.corsojava.pizzeria.model;


import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizze")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Devi inserire un nome!!")
    @NotEmpty(message = "Il campo non può essere vuoto")
    @Size(min = 3, max = 20, message = "Il nome della pizza deve essere compreso tra {min} e {max} caratteri")
    private String nome;

    @NotNull(message = "Devi inserire una descrizone!!")
    @NotEmpty(message = "Il campo non può essere vuoto")
    @Size(min = 2, max = 255, message = "La descrizione della pizza deve essere compreso tra {min} e {max} caratteri")
    private String descrizione;
    
    
    private String foto;
    
    @NotNull(message = "Devi inserire un prezzo!!")
    @DecimalMin(value = "0.01", message = "Il prezzo deve essere maggiore di zero")
    private BigDecimal prezzo;
    
    @OneToMany (mappedBy = "pizza") // si riferisce al ManytoOne di pizzeria presente in Discount
	private List<Discount> Discounts;

//  GETTERS E SETTERS

	public Integer getId() {
		return id;
	}


	public List<Discount> getDiscounts() {
		return Discounts;
	}


	public void setDiscounts(List<Discount> discounts) {
		Discounts = discounts;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public BigDecimal getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}



    
    
    
}
