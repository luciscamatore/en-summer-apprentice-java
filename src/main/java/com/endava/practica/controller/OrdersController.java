package com.endava.practica.controller;

import com.endava.practica.DTO.NewOrder;
import com.endava.practica.DTO.OrderAndroidDTO;
import com.endava.practica.DTO.OrderPatchDTO;
import com.endava.practica.DTO.OrdersDTO;
import com.endava.practica.repository.CutomerRepository;
import com.endava.practica.repository.OrdersRepository;
import com.endava.practica.repository.TicketCategoryRepository;
import com.endava.practica.services.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class OrdersController {

    final OrdersService ordersService;
    final OrdersRepository ordersRepository;
    final TicketCategoryRepository ticketCategoryRepository;
    final CutomerRepository cutomerRepository;

    @GetMapping("/getAllOrders")
    public List<OrderAndroidDTO> getAllOrders(){
        return ordersService.getAllOrders();
    }
    @GetMapping("/orderByID")
    public List<OrdersDTO> getOrderByID(@RequestParam Integer customerID){
        return  ordersService.getOrderByCustomerID(customerID);
    }

    @PostMapping("/placeOrder")
    public OrdersDTO postOrder(@RequestBody NewOrder newOrder){
        return ordersService.placeOrder(newOrder);
    }

    @DeleteMapping("/deleteOrder/{orderID}")
    public void deleteOrder(@PathVariable Integer orderID){
        ordersService.deleteOrder(orderID);
    }

    @PatchMapping("/patchOrder")
    public void patchOrder(@RequestBody OrderPatchDTO orderDTO) {
        ordersService.patchOrder(orderDTO);
    }
}
