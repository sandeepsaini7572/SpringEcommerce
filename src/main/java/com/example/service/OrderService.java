package com.example.service;

import com.example.dto.OrderDto;
import com.example.response.UpdateOrderResponse;

import java.util.List;


import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<OrderDto> placeOrder(OrderDto orderDTO);
    ResponseEntity<List<OrderDto>> getAllOrders();
    ResponseEntity<OrderDto> getOrderById(String id);
    ResponseEntity<UpdateOrderResponse> updateOrder(String id, OrderDto orderDto);
}

