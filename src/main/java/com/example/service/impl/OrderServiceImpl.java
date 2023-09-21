package com.example.service.impl;

import com.example.dto.OrderDto;
import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.example.response.UpdateOrderResponse;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<OrderDto> placeOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setProducts(orderDto.getProducts()); // Set products
        order.setOrderStatus(orderDto.getOrderStatus()); // Set OrderStatus
        order.setQuantity(orderDto.getQuantity()); // Set quantity
        order.setTotalPrice(orderDto.getTotalPrice()); // Set total price
        repository.save(order);
        orderDto.setId(order.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }



    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<Order> orders = repository.findAll();
        List<OrderDto> orderDtos = orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderDtos);
    }

    @Override
    public ResponseEntity<OrderDto> getOrderById(String id) {
        Optional<Order> order = repository.findById(id);
        if (order.isPresent()) {
            OrderDto orderDto = convertToDto(order.get());
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<UpdateOrderResponse> updateOrder(String id, OrderDto orderDto) {
        Optional<Order> existingOrder = repository.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setOrderStatus(orderDto.getOrderStatus());
            
            // Update other fields as needed
            order.setProducts(orderDto.getProducts());
            order.setQuantity(orderDto.getQuantity());
            order.setTotalPrice(orderDto.getTotalPrice());

            repository.save(order);

            // Convert the updated order to OrderDto
            OrderDto updatedOrderDto = convertToDto(order);

            // Create a custom response object with the message and updated order details
            String message = "Order is updated.";
            UpdateOrderResponse response = new UpdateOrderResponse(message, updatedOrderDto);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    private OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrderStatus(order.getOrderStatus());
        orderDto.setProducts(order.getProducts()); 
        orderDto.setQuantity(order.getQuantity()); 
        orderDto.setTotalPrice(order.getTotalPrice()); 
        return orderDto;
    }

}
