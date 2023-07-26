package com.endava.practica.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketCategoryDTO {

    Integer ticketCategoryID;
    String description;
    long price;

    public TicketCategoryDTO(Integer ticketCategoryID, String description, long price) {
        this.ticketCategoryID = ticketCategoryID;
        this.description = description;
        this.price = price;
    }
}
