package com.endava.practica.services;

import com.endava.practica.model.Customer;
import com.endava.practica.DTO.NewOrder;
import com.endava.practica.model.Orders;
import com.endava.practica.DTO.OrdersDTO;
import com.endava.practica.model.TicketCategory;
import com.endava.practica.repository.CutomerRepository;
import com.endava.practica.repository.OrdersRepository;
import com.endava.practica.repository.TicketCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdersService {

    final OrdersRepository ordersRepository;
    final TicketCategoryRepository ticketCategoryRepository;
    final CutomerRepository cutomerRepository;

    public List<OrdersDTO> getOrderByCustomerID(Integer customerID){
        List<Orders> orders = new ArrayList<>();
        List<OrdersDTO> ordersDTO = new ArrayList<>();
        ordersRepository.findAllByCustomer_CustomerID(customerID).forEach(o->orders.add(o));
        for(Orders o : orders){
            ordersDTO.add(new OrdersDTO(o.getTicketCategory().getEvent().getEventID(), o.getOrderdAt(),o.getTicketCategory().getTicketCategoryID(), o.getNumberOfTickets(), o.getTotalPrice()));
        }
        return ordersDTO;
    }

    public OrdersDTO placeOrder(NewOrder newOrder){
        LocalDateTime dateTime = LocalDateTime.now();
        Customer customer = cutomerRepository.findById(1).get();

        TicketCategory ticketCategory = ticketCategoryRepository.findById(newOrder.getTicketCategoryID()).get();

        Orders placedOrder = new Orders(customer, ticketCategory, dateTime, newOrder.getNumberOfTickets(), newOrder.getNumberOfTickets()*ticketCategory.getPrice());

        ordersRepository.save(placedOrder);

        return new OrdersDTO(placedOrder.getTicketCategory().getEvent().getEventID(), placedOrder.getOrderdAt(), placedOrder.getTicketCategory().getTicketCategoryID(), placedOrder.getNumberOfTickets(), placedOrder.getTotalPrice());
    }
}
