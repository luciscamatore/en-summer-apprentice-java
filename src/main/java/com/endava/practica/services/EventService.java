package com.endava.practica.services;

import com.endava.practica.DTO.EventDTO;
import com.endava.practica.DTO.TicketCategoryDTO;
import com.endava.practica.model.Event;
import com.endava.practica.model.TicketCategory;
import com.endava.practica.repository.EventRepository;
import com.endava.practica.repository.TicketCategoryRepository;
import com.endava.practica.repository.VenueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    final EventRepository eventRepository;
    final VenueRepository venueRepository;
    final TicketCategoryRepository ticketCategoryRepository;


    public Event getEventByID(Integer EventID){
        return eventRepository.findById(EventID).get();
    }

    public List<Event> getAllEvents(){
        List<Event> event = new ArrayList<>();
        eventRepository.findAll().forEach(ev ->event.add(ev));
        return event;
    }

    public EventDTO getEventByVenueIDandEventType(Integer venueID, String eventType){

        Event event = eventRepository.findEventsByVenue_VenueIDAndEventType_EventTypeName(venueID, eventType);
        List<TicketCategory> ticketCategory = ticketCategoryRepository.findTicketCategoriesByEvent_EventID(venueID);
        List<TicketCategoryDTO> ticketCategoryDTO = new ArrayList<>();
        for (TicketCategory tk: ticketCategory) {
            ticketCategoryDTO.add(new TicketCategoryDTO(tk.getTicketCategoryID(),tk.getDescription(),tk.getPrice()));
        }
        return new EventDTO(event.getEventID(), event.getVenue(),event.getEventType().getEventTypeName(), event.getEventDescription(),event.getEventName(),event.getStartDate(),event.getEndDate(),ticketCategoryDTO);
    }
}
