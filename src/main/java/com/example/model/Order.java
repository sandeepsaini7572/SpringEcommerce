package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")

public class Order {
	
	@Id
	private String id;
	private String products;
	private int quantity;
	private double totalPrice;

	private String orderStatus;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String id, String products, int quantity, double totalPrice, String orderStatus) {
		super();
		this.id = id;
		this.products = products;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
