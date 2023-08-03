package com.endava.practica.DTO;

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
@AllArgsConstructor
public class EventDTO {
    Integer eventID;
    Venue venue;
    String eventType;
    String eventDescription;
    String eventName;
    LocalDateTime startDate;
    LocalDateTime endDate;
    List<TicketCategoryDTO> ticketCategory;
}
