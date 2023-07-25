package com.endava.practica.DTO;

public class TicketCategoryDTO {

    Integer ticketCategoryID;
    String description;
    long price;

    public Integer getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Integer ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public TicketCategoryDTO(Integer ticketCategoryID, String description, long price) {
        this.ticketCategoryID = ticketCategoryID;
        this.description = description;
        this.price = price;
    }
}
