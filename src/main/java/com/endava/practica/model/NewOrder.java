package com.endava.practica.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewOrder {
    private Integer orderID;
    private Integer ticketCategoryID;
    private int numberOfTickets;

    public NewOrder(Integer orderID, Integer ticketCategoryID, int numberOfTickets) {
        this.orderID = orderID;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
    }
}
