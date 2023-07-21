package com.endava.practica.repository;

import com.endava.practica.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CutomerRepository extends CrudRepository<Customer, Integer> {
}
