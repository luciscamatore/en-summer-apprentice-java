package com.endava.practica.DTO;

import com.endava.practica.DTO.TicketCategoryDTO;
import com.endava.practica.model.Venue;

import java.time.LocalDateTime;
import java.util.List;

public class EventDTO {
    Integer eventID;
    Venue venue;
    String type;
    String description;
    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    List<TicketCategoryDTO> ticketCategory;

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<TicketCategoryDTO> getTicketCategory() {
        return ticketCategory;
    }

    public EventDTO(Integer eventID, Venue venue, String type, String description, String name, LocalDateTime startDate, LocalDateTime endDate, List<TicketCategoryDTO> ticketCategory) {
        this.eventID = eventID;
        this.venue = venue;
        this.type = type;
        this.description = description;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketCategory = (List<TicketCategoryDTO>) ticketCategory;
    }
}
