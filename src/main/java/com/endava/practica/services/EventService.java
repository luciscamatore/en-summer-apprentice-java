package com.endava.practica.services;

import com.endava.practica.DTO.EventDTO;
import com.endava.practica.DTO.TicketCategoryDTO;
import com.endava.practica.model.Event;
import com.endava.practica.model.TicketCategory;
import com.endava.practica.repository.EventRepository;
import com.endava.practica.repository.TicketCategoryRepository;
import com.endava.practica.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    final EventRepository eventRepository;
    final VenueRepository venueRepository;
    final TicketCategoryRepository ticketCategoryRepository;
    public EventService(EventRepository eventRepository, VenueRepository venueRepository, TicketCategoryRepository ticketCategoryRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
    }

    public Event getEventByID(Integer EventID){
        return eventRepository.findById(EventID).get();
    }

    public List<Event> getAllEvents(){
        List<Event> ev = new ArrayList<>();
        eventRepository.findAll().forEach(ev1 ->ev.add(ev1));
        return ev;
    }

    public EventDTO getEventByVenueIDandEventType(Integer id, String eventType){
        Event ev = eventRepository.findEventsByVenueID_VenueIDAndEventTypeID_EventTypeName(id, eventType);
        List<TicketCategory> tk = ticketCategoryRepository.findTicketCategoriesByEventID_EventID(id);
        List<TicketCategoryDTO> tkdto = new ArrayList<>();
        for (TicketCategory i: tk) {
            tkdto.add(new TicketCategoryDTO(i.getTicketCategoryID(),i.getDescription(),i.getPrice()));
        }
        return new EventDTO(ev.getEventID(), ev.getVenueID(),ev.getEventTypeID().getEventTypeName(), ev.getEventDescription(),ev.getEventName(),ev.getStartDate(),ev.getEndDate(),tkdto);
    }
}
