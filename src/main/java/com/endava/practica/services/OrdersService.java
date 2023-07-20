package com.endava.practica.services;

import com.endava.practica.model.Orders;
import com.endava.practica.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }
}
