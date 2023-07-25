package com.endava.practica.services;

import com.endava.practica.model.Customer;
import com.endava.practica.model.NewOrder;
import com.endava.practica.model.Orders;
import com.endava.practica.DTO.OrdersDTO;
import com.endava.practica.model.TicketCategory;
import com.endava.practica.repository.CutomerRepository;
import com.endava.practica.repository.OrdersRepository;
import com.endava.practica.repository.TicketCategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    final OrdersRepository ordersRepository;
    final TicketCategoryRepository ticketCategoryRepository;
    final CutomerRepository cutomerRepository;
    public OrdersService(OrdersRepository ordersRepository, TicketCategoryRepository ticketCategoryRepository, CutomerRepository cutomerRepository) {
        this.ordersRepository = ordersRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.cutomerRepository = cutomerRepository;
    }

    public List<OrdersDTO> getOrderByCustomerID(Integer id){
        List<Orders> orders = new ArrayList<>();
        List<OrdersDTO> ordersDTO = new ArrayList<>();
        ordersRepository.findAllByCustomerID_CustomerID(id).forEach(o->orders.add(o));
        for(Orders o : orders){
            ordersDTO.add(new OrdersDTO(o.getTicketCategory().getEventID().getEventID(), o.getOrderdAt(),o.getTicketCategory().getTicketCategoryID(), o.getNumberOfTickets(), o.getTotalPrice()));
        }
        return ordersDTO;
    }

    public OrdersDTO getDTO(NewOrder newOrder){
        LocalDateTime dateTime = LocalDateTime.now();

        TicketCategory ticketCategory = ticketCategoryRepository.findById(newOrder.getTicketCategoryID()).get();

        Customer cust = cutomerRepository.findById(1).get();

        Orders placedOrder = new Orders(cust, ticketCategory, dateTime, newOrder.getNumberOfTickets(), newOrder.getNumberOfTickets()*ticketCategory.getPrice());

        Orders ord = ordersRepository.save(placedOrder);

        return new OrdersDTO(ord.getTicketCategory().getEventID().getEventID(), ord.getOrderdAt(), ord.getTicketCategory().getTicketCategoryID(), ord.getNumberOfTickets(), ord.getTotalPrice());
    }
}
