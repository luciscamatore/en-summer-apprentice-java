package com.endava.practica.services;

import com.endava.practica.model.Orders;
import com.endava.practica.model.PrettyOrders;
import com.endava.practica.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

//    public List<Orders> getAllOrders(){
//        return ordersRepository.findAll();
//    }

    public List<Orders> getOrderByID(Integer id){
        return ordersRepository.findAllByCustomerID_CustomerID(id);
    }

//    public Orders placeOrder(Orders newOrder){
//        ordersRepository.save(newOrder);
//    }
    public static PrettyOrders getDTO(Orders order){
        return new PrettyOrders(order.getTicketCategory().getEventID().getEventID(), order.getOrderdAt(), order.getTicketCategory().getTicketCategoryID(), order.getNumberOfTickets(), order.getTotalPrice());
    }
}
