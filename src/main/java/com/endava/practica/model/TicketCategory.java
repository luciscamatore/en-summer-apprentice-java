package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TicketCategory")
public class TicketCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketCategoryID;

    @ManyToOne
    @JoinColumn(name = "EventID")
    private Event event;

    @Column(name = "Price")
    private long price;

    @Column(name = "Description")
    private String description;

    public TicketCategory(Event event, long price, String description) {
        this.event = event;
        this.price = price;
        this.description = description;
    }
}
