package com.endava.practica.services;

import com.endava.practica.DTO.*;
import com.endava.practica.model.Customer;
import com.endava.practica.model.Orders;
import com.endava.practica.model.TicketCategory;
import com.endava.practica.repository.CustomerRepository;
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
    final CustomerRepository cutomerRepository;

    public List<OrderAndroidDTO> getAllOrders(){
        List<Orders> orders = (List<Orders>) ordersRepository.findAll();
        List<OrderAndroidDTO> ordersDTO = new ArrayList<>();
        TicketCategory ticketCategories;
        for(Orders o : orders){
            ticketCategories = ticketCategoryRepository.findTicketCategoryByTicketCategoryID(o.getTicketCategory().getTicketCategoryID());
            TicketCategoryDTO ticketCategoryDTO = new TicketCategoryDTO(ticketCategories.getTicketCategoryID(),ticketCategories.getDescription(),ticketCategories.getPrice());
            ordersDTO.add(new OrderAndroidDTO(o.getOrderID(),ticketCategoryDTO,ticketCategories.getEvent().getEventName(),o.getOrderdAt(),o.getNumberOfTickets(),o.getTotalPrice()));
        }
        return ordersDTO;
    }

    public List<OrderAndroidDTO> getOrderByCustomerID(Integer customerID){  
        List<Orders> orders = new ArrayList<>();
        List<OrderAndroidDTO> ordersDTO = new ArrayList<>();
        ordersRepository.findAllByCustomer_CustomerID(customerID).forEach(o->orders.add(o));
        TicketCategory ticketCategories;
        for(Orders o : orders){
            ticketCategories = ticketCategoryRepository.findTicketCategoryByTicketCategoryID(o.getTicketCategory().getTicketCategoryID());
            TicketCategoryDTO ticketCategoryDTO = new TicketCategoryDTO(ticketCategories.getTicketCategoryID(),ticketCategories.getDescription(),ticketCategories.getPrice());
            ordersDTO.add(new OrderAndroidDTO(o.getOrderID(),ticketCategoryDTO,ticketCategories.getEvent().getEventName(),o.getOrderdAt(),o.getNumberOfTickets(),o.getTotalPrice()));
        }
        return ordersDTO;
    }

    public OrdersDTO placeOrder(NewOrder newOrder){
        Orders existingOrder = ordersRepository.findOrdersByCustomer_CustomerIDAndTicketCategory_Event_EventIDAndTicketCategory_Description(newOrder.getCustomerID(), newOrder.getEventID(), newOrder.getTicketCategoryDescription());
        if(existingOrder != null){
            TicketCategory ticketCategory = ticketCategoryRepository.findTicketCategoryByEvent_EventIDAndDescription(newOrder.getEventID(), newOrder.getTicketCategoryDescription());
            existingOrder.setNumberOfTickets(existingOrder.getNumberOfTickets()+ newOrder.getNumberOfTickets());
            existingOrder.setTotalPrice(existingOrder.getTotalPrice()+ (newOrder.getNumberOfTickets() * ticketCategory.getPrice()));
            ordersRepository.save(existingOrder);
            return new OrdersDTO(existingOrder.getTicketCategory().getEvent().getEventID(), existingOrder.getOrderdAt(), existingOrder.getTicketCategory().getTicketCategoryID(), existingOrder.getNumberOfTickets(), existingOrder.getTotalPrice());
        }

        LocalDateTime dateTime = LocalDateTime.now();
        Customer customer = cutomerRepository.findById(newOrder.getCustomerID()).get();
        TicketCategory ticketCategory = ticketCategoryRepository.findTicketCategoryByEvent_EventIDAndDescription(newOrder.getEventID(), newOrder.getTicketCategoryDescription());
        Orders placedOrder = new Orders(customer, ticketCategory, dateTime, newOrder.getNumberOfTickets(), newOrder.getNumberOfTickets()*ticketCategory.getPrice());
        ordersRepository.save(placedOrder);

        return new OrdersDTO(placedOrder.getTicketCategory().getEvent().getEventID(), placedOrder.getOrderdAt(), placedOrder.getTicketCategory().getTicketCategoryID(), placedOrder.getNumberOfTickets(), placedOrder.getTotalPrice());
    }

    public void deleteOrder(Integer orderID) {
        Orders order = ordersRepository.findOrdersByOrderID(orderID);
        ordersRepository.delete(order);
    }

    public void patchOrder(OrderPatchDTO orderDTO){
        Orders order = ordersRepository.findOrdersByOrderID(orderDTO.getOrderID());
        TicketCategory ticketCategory = ticketCategoryRepository.findTicketCategoryByEvent_EventNameAndDescription(order.getTicketCategory().getEvent().getEventName(),orderDTO.getTicketCategoryDescription());

        order.setNumberOfTickets(orderDTO.getNrTickets());
        order.setTotalPrice(orderDTO.getNrTickets() * ticketCategory.getPrice());
        order.setTicketCategory(ticketCategory);

        ordersRepository.save(order);
    }
}
