package com.endava.practica.repository;

import com.endava.practica.model.Orders;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    List<Orders> findAllByCustomer_CustomerID(Integer customerID);
    Orders findOrdersByOrderID(Integer orderID);
}
