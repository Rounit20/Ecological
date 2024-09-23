package com.example.rounit.ecological.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Bid {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    
	    @NotBlank
	    private String product_name;
	    
	    @NotBlank
	    private String description;
	    
	    @NotNull
	    @Min(0)
	    private int quantity;
	    
	    @NotNull
	    @Min(0)
	    private int price;
	    
	    @NotBlank(message = "Name is mandatory")
	    private String name;
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone_no() {
			return phone_no;
		}

		public void setPhone_no(String phone_no) {
			this.phone_no = phone_no;
		}

		@NotBlank(message = "Phone number is mandatory")
	    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	    private String phone_no;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getProduct_name() {
			return product_name;
		}

		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
	    
	    
	    // Getters and Setters
	}

	
	


