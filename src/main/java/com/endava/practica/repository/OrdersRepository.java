package com.endava.practica.repository;

import com.endava.practica.model.Orders;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    @Query(value = "SELECT * FROM Orders o, Customer c WHERE o.CustomerID = c.CustomerID", nativeQuery = true)
    List<Orders> findAll();
}
