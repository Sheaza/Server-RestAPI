package com.pracownia.springapp.services;

import com.pracownia.springapp.entities.Order;
import com.pracownia.springapp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Order getOrder(int id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
