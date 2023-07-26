package com.endava.practica.DTO;

import com.endava.practica.DTO.TicketCategoryDTO;
import com.endava.practica.model.Venue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EventDTO {
    Integer eventID;
    Venue venue;
    String type;
    String description;
    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    List<TicketCategoryDTO> ticketCategory;

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
