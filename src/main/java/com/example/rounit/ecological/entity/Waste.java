package com.example.rounit.ecological.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Waste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;   
    
	@NotNull
	@Min(0)
    private int metal;
    
	@NotNull
	@Min(0)
    private int glass;    
   
	@NotNull
	@Min(0)
    private int paper;

	@NotNull
	@Min(0)
    private int plastic;

	@NotBlank
    private String name;

	@NotBlank
	@Email
    private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getGlass() {
		return glass;
	}

	public void setGlass(int glass) {
		this.glass = glass;
	}

	public int getPaper() {
		return paper;
	}

	public void setPaper(int paper) {
		this.paper = paper;
	}

	public int getPlastic() {
		return plastic;
	}

	public void setPlastic(int plastic) {
		this.plastic = plastic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	}
