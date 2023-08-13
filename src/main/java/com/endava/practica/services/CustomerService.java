package com.endava.practica.services;

import com.endava.practica.model.Customer;
import com.endava.practica.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public Customer getCustomerByEmail(String email){
        Customer customer = customerRepository.findCustomerByEmail(email);
        if(customer != null)
            return customer;
        return new Customer();
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
}
