package com.endava.practica.DTO;

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
    String eventName;
    long nrTickets;
    long price;
}
