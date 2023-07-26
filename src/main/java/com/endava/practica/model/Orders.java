package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
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
