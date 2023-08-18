package com.endava.practica.DTO;

import com.endava.practica.model.Venue;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDTO {
    Integer eventID;
    Venue venue;
    String eventType;
    String eventDescription;
    String eventName;
    LocalDateTime startDate;
    LocalDateTime endDate;
    List<TicketCategoryDTO> ticketCategory;
    String image;
}
