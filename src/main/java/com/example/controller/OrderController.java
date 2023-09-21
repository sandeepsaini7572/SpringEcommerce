package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.OrderDto;
import com.example.response.UpdateOrderResponse;
import com.example.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<String> saveOrder(@RequestBody OrderDto orderDto) {
        ResponseEntity<OrderDto> savedOrderResponse = orderService.placeOrder(orderDto);

        if (savedOrderResponse.getStatusCode() == HttpStatus.CREATED) {
            OrderDto savedOrder = savedOrderResponse.getBody();
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Added products with ID: " + savedOrder.getId());
        } else {
            // Handle the error condition appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create the order.");
        }
    }

    @GetMapping("/findAllOrders")
    public ResponseEntity<List<OrderDto>> getOrders() {
        return orderService.getAllOrders();
    }


    @GetMapping("/findOrder/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable String id) {
        ResponseEntity<OrderDto> orderResponse = orderService.getOrderById(id);

        if (orderResponse.getStatusCode() == HttpStatus.OK) {
            OrderDto order = orderResponse.getBody();
            return ResponseEntity.ok(order);
        } else if (orderResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Order not found with ID: " + id);
        } else {
            // Handle other error conditions appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch the order.");
        }
    }

    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<Object> modifyProduct(@PathVariable String id, @RequestBody OrderDto orderDto) {
        ResponseEntity<UpdateOrderResponse> resultResponse = orderService.updateOrder(id, orderDto);

        if (resultResponse.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(resultResponse.getBody());
        } else if (resultResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(resultResponse.getBody());
        } else {
            // Handle other error conditions appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(resultResponse.getBody());
        }
    }
}
