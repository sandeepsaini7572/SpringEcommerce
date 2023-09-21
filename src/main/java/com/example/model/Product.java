package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private boolean availability;
    
    
	public Product() {
		super();
	}
	public Product(String id, String name, String description, double price, boolean availability) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.availability = availability;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public boolean getAvailability() {
		// TODO Auto-generated method stub
		return false;
	}
    
    

    // Constructors, getters, setters, and other methods
}
