package com.endava.practica.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TicketCategory")
public class TicketCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TicketCategoryID;

    @ManyToOne
    @MapsId("EventID")
    private Event EventID;

    @Column(name = "Price")
    private long Price;

    @Column(name = "Description")
    private String Description;

//    @OneToMany(mappedBy = "TicketCategoryID")
//    private List<TicketCategory> TicketCategories;

    public Integer getTicketCategoryID() {
        return TicketCategoryID;
    }

    public void setTicketCategoryID(Integer ticketCategoryID) {
        TicketCategoryID = ticketCategoryID;
    }

    public Event getEventID() {
        return EventID;
    }

    public void setEventID(Event eventID) {
        EventID = eventID;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public TicketCategory() {
    }
}
