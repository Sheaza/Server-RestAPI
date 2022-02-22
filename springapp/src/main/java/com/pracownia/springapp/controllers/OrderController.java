package com.pracownia.springapp.controllers;

import com.pracownia.springapp.entities.Order;
import com.pracownia.springapp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> findAllOrders(){return orderService.getOrders();}

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }



}
