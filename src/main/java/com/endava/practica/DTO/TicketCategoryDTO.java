package com.endava.practica.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketCategoryDTO {

    Integer ticketCategoryID;
    String description;
    long price;

    public TicketCategoryDTO(String description, long price) {
        this.description = description;
        this.price = price;
    }
}
