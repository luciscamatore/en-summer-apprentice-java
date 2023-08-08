package com.endava.practica.DTO;

import com.endava.practica.model.TicketCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAndroidDTO {
    Integer orderID;
    TicketCategoryDTO ticketCategoryDTO;
    String eventName;
    long nrTickets;
    long price;
}
