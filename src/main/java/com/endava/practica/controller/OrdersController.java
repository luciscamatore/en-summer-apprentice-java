package com.endava.practica.controller;

import com.endava.practica.DTO.OrdersDTO;
import com.endava.practica.model.*;
import com.endava.practica.repository.CutomerRepository;
import com.endava.practica.repository.OrdersRepository;
import com.endava.practica.repository.TicketCategoryRepository;
import com.endava.practica.services.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class OrdersController {

    final OrdersService ordersService;
    final OrdersRepository ordersRepository;
    final TicketCategoryRepository ticketCategoryRepository;
    final CutomerRepository cutomerRepository;

    public OrdersController(OrdersService ordersService, OrdersRepository ordersRepository, TicketCategoryRepository ticketCategoryRepository, CutomerRepository cutomerRepository) {
        this.ordersService = ordersService;
        this.ordersRepository = ordersRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.cutomerRepository = cutomerRepository;
    }

    @GetMapping("/orderByID")
    public List<OrdersDTO> getOrderByID(@RequestParam Integer id){
        return  ordersService.getOrderByCustomerID(id);
    }

    @PostMapping("/placeOrder")
    public OrdersDTO postOrder(@RequestBody NewOrder newOrder){
        return ordersService.getDTO(newOrder);
    }
}
