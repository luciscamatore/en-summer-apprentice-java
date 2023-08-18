package com.endava.practica.controller;

import com.endava.practica.DTO.CustomerPostDTO;
import com.endava.practica.model.Customer;
import com.endava.practica.repository.CustomerRepository;
import com.endava.practica.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerController {
    final CustomerService customerService;

    @GetMapping("/getCustomer/{email}")
    public Customer getCustomerByEmail(@PathVariable String email){
        return customerService.getCustomerByEmail(email);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/registerCustomer")
    public void registerCustomer(@RequestBody CustomerPostDTO newCustomer){
        customerService.registerCustomer(newCustomer);
    }
}
