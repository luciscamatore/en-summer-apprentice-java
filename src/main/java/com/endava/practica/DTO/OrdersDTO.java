package com.endava.practica.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class OrdersDTO {

    Integer eventID;
    LocalDateTime orderedAt;
    Integer ticketCategoryID;
    long numberOfTickets;
    long totalPrice;

    public OrdersDTO(Integer eventID, LocalDateTime orderedAt, Integer ticketCategoryID, long numberOfTickets, long totalPrice) {
        this.eventID = eventID;
        this.orderedAt = orderedAt;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }
}
