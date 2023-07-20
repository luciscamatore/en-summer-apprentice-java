package com.endava.practica.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer CustomerID;

    @ManyToOne
    @JoinColumn(name = "TicketCategoryID")
    private TicketCategory TicketCategoryID;

    @Column(name = "OrderedAt")
    private LocalDateTime OrderdAt;

    @Column(name = "NumberOfTickets")
    private long NumberOfTickets;

    @Column(name = "TotalPrice")
    private long TotalPrice;

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public Customer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Customer customerID) {
        CustomerID = customerID;
    }

    public TicketCategory getTicketCategoryID() {
        return TicketCategoryID;
    }

    public void setTicketCategoryID(TicketCategory ticketCategoryID) {
        TicketCategoryID = ticketCategoryID;
    }

    public LocalDateTime getOrderdAt() {
        return OrderdAt;
    }

    public void setOrderdAt(LocalDateTime orderdAt) {
        OrderdAt = orderdAt;
    }

    public long getNumberOfTickets() {
        return NumberOfTickets;
    }

    public void setNumberOfTickets(long numberOfTickets) {
        NumberOfTickets = numberOfTickets;
    }

    public long getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        TotalPrice = totalPrice;
    }

    public Orders() {
    }
}
