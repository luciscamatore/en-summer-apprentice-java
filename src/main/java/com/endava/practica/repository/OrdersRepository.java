package com.endava.practica.repository;

import com.endava.practica.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    List<Orders> findAllByCustomerID_CustomerID(Integer id);
}
