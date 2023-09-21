package com.example.response;

import com.example.dto.OrderDto;

public class UpdateOrderResponse {
    private String message;
    private OrderDto updatedOrder;

    public UpdateOrderResponse(String message, OrderDto updatedOrder) {
        this.message = message;
        this.updatedOrder = updatedOrder;
        
        
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OrderDto getUpdatedOrder() {
		return updatedOrder;
	}

	public void setUpdatedOrder(OrderDto updatedOrder) {
		this.updatedOrder = updatedOrder;
	}

    // Getters and setters for message and updatedOrder
}
