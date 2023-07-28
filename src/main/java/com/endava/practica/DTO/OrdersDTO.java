package com.endava.practica.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {

    Integer eventID;
    LocalDateTime orderedAt;
    Integer ticketCategoryID;
    long numberOfTickets;
    long totalPrice;
}
