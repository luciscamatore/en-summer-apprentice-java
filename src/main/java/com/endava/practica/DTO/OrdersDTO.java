package com.endava.practica.DTO;


import java.time.LocalDateTime;

public class OrdersDTO {

    Integer eventID;
    LocalDateTime orderedAt;

    Integer ticketCategoryID;

    long numberOfTickets;

    long totalPrice;

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Integer getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Integer ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrdersDTO(Integer eventID, LocalDateTime orderedAt, Integer ticketCategoryID, long numberOfTickets, long totalPrice) {
        this.eventID = eventID;
        this.orderedAt = orderedAt;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }
}
