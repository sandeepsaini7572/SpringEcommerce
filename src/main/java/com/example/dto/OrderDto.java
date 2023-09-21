package com.example.dto;

public class OrderDto {
    private String id;
    private String products;
    private String orderStatus;
    private int quantity;
    private double totalPrice;

    public OrderDto() {
        // Default constructor
    }

    public OrderDto(String id,  String products, String orderStatus, int quantity, double totalPrice) {
        this.id = id;
        this.products = products;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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
    

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
    
    // Other getters and setters for additional fields
}

