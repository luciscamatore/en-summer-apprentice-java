package com.endava.practica.controller;

import com.endava.practica.model.Orders;
import com.endava.practica.repository.EventRepository;
import com.endava.practica.repository.OrdersRepository;
import com.endava.practica.services.EventService;
import com.endava.practica.services.OrdersService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping("/orders")
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }
}
