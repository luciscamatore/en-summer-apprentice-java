package com.endava.practica.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customerID;

    @ManyToOne
    @JoinColumn(name = "TicketCategoryID")
    private TicketCategory ticketCategory;

    @Column(name = "OrderdAt")
    private LocalDateTime orderdAt;

    @Column(name = "NumberOfTickets")
    private long numberOfTickets;

    @Column(name = "TotalPrice")
    private long totalPrice;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        orderID = orderID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(TicketCategory ticketCategoryID) {
        this.ticketCategory = ticketCategoryID;
    }

    public LocalDateTime getOrderdAt() {
        return orderdAt;
    }

    public void setOrderdAt(LocalDateTime orderdAt) {
        this.orderdAt = orderdAt;
    }

    public long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(long numberOfTickets){ this.numberOfTickets = numberOfTickets;}

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Orders() {
    }

    public Orders(Customer customerID, TicketCategory ticketCategoryID, LocalDateTime orderdAt, long numberOfTickets, long totalPrice) {

        this.customerID = customerID;
        this.ticketCategory = ticketCategoryID;
        this.orderdAt = orderdAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public Orders(Integer orderID, Customer customerID, TicketCategory ticketCategoryID, LocalDateTime orderdAt, long numberOfTickets, long totalPrice) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.ticketCategory = ticketCategoryID;
        this.orderdAt = orderdAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }
}
