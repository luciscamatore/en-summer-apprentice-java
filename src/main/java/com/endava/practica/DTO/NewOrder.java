package com.endava.practica.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewOrder {

    private Integer orderID;
    private Integer ticketCategoryID;
    private int numberOfTickets;

}
