package com.endava.practica.controller;

import com.endava.practica.model.*;
import com.endava.practica.repository.CutomerRepository;
import com.endava.practica.repository.OrdersRepository;
import com.endava.practica.repository.TicketCategoryRepository;
import com.endava.practica.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class OrdersController {

    Customer customerID;
    @Autowired
    OrdersService ordersService;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    TicketCategoryRepository ticketCategoryRepository;

    @Autowired
    CutomerRepository cutomerRepository;

    @GetMapping("/orderByID")
    public List<Orders> getOrderByID(@RequestParam Integer id){
        return  ordersService.getOrderByID(id);
    }

    @PostMapping("/placeOrder")
    public PrettyOrders postOrder(@RequestBody NewOrder newOrder){
        LocalDateTime dateTime = LocalDateTime.now();

        TicketCategory ticketCategory = ticketCategoryRepository.findById(newOrder.getTicketCategoryID()).get();

        this.customerID = new Customer();
        Customer cust = cutomerRepository.findById(1).get();

        Orders placedOrder = new Orders(cust, ticketCategory, dateTime, newOrder.getNumberOfTickets(), newOrder.getNumberOfTickets()*ticketCategory.getPrice());
        //
        Orders ord = ordersRepository.save(placedOrder);
        return ordersService.getDTO(ord);
    }
}
