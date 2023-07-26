package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TicketCategory")
public class TicketCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketCategoryID;

    @ManyToOne
    @JoinColumn(name = "EventID")
    private Event eventID;

    @Column(name = "Price")
    private long price;

    @Column(name = "Description")
    private String description;

    public TicketCategory() {
    }
}
