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
    private Integer customerID;
    private Integer eventID;
    private String ticketCategoryDescription;
    private int numberOfTickets;

}
