package com.endava.practica.services;

import com.endava.practica.DTO.EventAddDTO;
import com.endava.practica.DTO.EventDTO;
import com.endava.practica.DTO.TicketCategoryDTO;
import com.endava.practica.model.Event;
import com.endava.practica.model.EventType;
import com.endava.practica.model.TicketCategory;
import com.endava.practica.model.Venue;
import com.endava.practica.repository.EventRepository;
import com.endava.practica.repository.EventTypeRepository;
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
    final EventTypeRepository eventTypeRepository;


    public List<EventDTO> getEventBatch(int batchNumber){
        List<Event> allEvents = (List<Event>) eventRepository.findAll();
        int numberOfBatches = allEvents.size() / 10;
        List<EventDTO> eventDTOS = new ArrayList<>();
        for( Event ev : allEvents){
            List<TicketCategory> ticketCategory = ticketCategoryRepository.findTicketCategoriesByEvent_EventID(ev.getEventID());
            List<TicketCategoryDTO> ticketCategoryDTO = new ArrayList<>();
            for (TicketCategory tk : ticketCategory) {
                ticketCategoryDTO.add(new TicketCategoryDTO(tk.getTicketCategoryID(), tk.getDescription(), tk.getPrice()));
            }
            eventDTOS.add(new EventDTO(ev.getEventID(), ev.getVenue(), ev.getEventType().getEventTypeName(), ev.getEventDescription(), ev.getEventName(), ev.getStartDate(), ev.getEndDate(), ticketCategoryDTO, ev.getImage()));
        }
        List<EventDTO> eventBatch = new ArrayList<>();
        for(int i=(batchNumber*10)-10;i<batchNumber*10;i++){
            if(eventDTOS.size() > i)
                eventBatch.add(eventDTOS.get(i));
        }
        return eventBatch;
    }

    public List<EventDTO> getEventsByFilter(String location, String  type){
        List<EventDTO> eventDTOS = new ArrayList<>();
        List<Event> events;
        if(location.equals("location"))
            events = eventRepository.findEventsByEventType_EventTypeName(type);
        else if(type.equals("type"))
            events = eventRepository.findEventsByVenue_Location(location);
        else
            events = eventRepository.findEventsByVenue_LocationAndEventType_EventTypeName(location, type);
        for( Event ev : events){
            List<TicketCategory> ticketCategory = ticketCategoryRepository.findTicketCategoriesByEvent_EventID(ev.getEventID());
            List<TicketCategoryDTO> ticketCategoryDTO = new ArrayList<>();
            for (TicketCategory tk : ticketCategory) {
                ticketCategoryDTO.add(new TicketCategoryDTO(tk.getTicketCategoryID(), tk.getDescription(), tk.getPrice()));
            }
            eventDTOS.add(new EventDTO(ev.getEventID(), ev.getVenue(), ev.getEventType().getEventTypeName(), ev.getEventDescription(), ev.getEventName(), ev.getStartDate(), ev.getEndDate(), ticketCategoryDTO, ev.getImage()));
        }
        return eventDTOS;
    }

    public List<EventDTO> getAllEvents(){
        List<EventDTO> eventDTO = new ArrayList<>();
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(ev ->events.add(ev));

        for(Event ev : events) {
            List<TicketCategory> ticketCategory = ticketCategoryRepository.findTicketCategoriesByEvent_EventID(ev.getEventID());
            List<TicketCategoryDTO> ticketCategoryDTO = new ArrayList<>();
            for (TicketCategory tk : ticketCategory) {
                ticketCategoryDTO.add(new TicketCategoryDTO(tk.getTicketCategoryID(), tk.getDescription(), tk.getPrice()));
            }
            eventDTO.add(new EventDTO(ev.getEventID(), ev.getVenue(), ev.getEventType().getEventTypeName(), ev.getEventDescription(), ev.getEventName(), ev.getStartDate(), ev.getEndDate(), ticketCategoryDTO, ev.getImage()));
        }
        return eventDTO;
    }

    public EventDTO getEventByVenueIDandEventType(Integer venueID, String eventType){

        Event event = eventRepository.findEventsByVenue_VenueIDAndEventType_EventTypeName(venueID, eventType);
        List<TicketCategory> ticketCategory = ticketCategoryRepository.findTicketCategoriesByEvent_EventID(venueID);
        List<TicketCategoryDTO> ticketCategoryDTO = new ArrayList<>();
        for (TicketCategory tk: ticketCategory) {
            ticketCategoryDTO.add(new TicketCategoryDTO(tk.getTicketCategoryID(),tk.getDescription(),tk.getPrice()));
        }
        return new EventDTO(event.getEventID(), event.getVenue(),event.getEventType().getEventTypeName(), event.getEventDescription(),event.getEventName(),event.getStartDate(),event.getEndDate(),ticketCategoryDTO, event.getImage());
    }

    public EventDTO postEvents(EventAddDTO eventAddDTO){
        Venue venue = venueRepository.findVenueByLocation(eventAddDTO.venueLocation);
        EventType eventType = eventTypeRepository.findEventTypeByEventTypeID(eventAddDTO.eventTypeID);

        Event createdEvent = new Event(venue, eventType, eventAddDTO.eventDescription, eventAddDTO.eventName, eventAddDTO.startDate, eventAddDTO.endDate, eventAddDTO.image);

        List<TicketCategory> ticketCategory = ticketCategoryRepository.findTicketCategoriesByEvent_EventID(createdEvent.getEventID());
        List<TicketCategoryDTO> ticketCategoryDTO = new ArrayList<>();
        for (TicketCategory tk: ticketCategory) {
            ticketCategoryDTO.add(new TicketCategoryDTO(tk.getTicketCategoryID(),tk.getDescription(),tk.getPrice()));
        }
        eventRepository.save(createdEvent);
        return new EventDTO(createdEvent.getEventID(), createdEvent.getVenue(), createdEvent.getEventType().getEventTypeName(), createdEvent.getEventDescription(), createdEvent.getEventName(),createdEvent.getStartDate(),createdEvent.getEndDate(), ticketCategoryDTO, createdEvent.getImage());
    }

    public void deleteEvent(String eventName){
        Event event = eventRepository.findEventByEventName(eventName);
        eventRepository.delete(event);
    }

    public List<EventDTO> convertToDTO(List<Event> eventList){
        List<EventDTO> eventDTOS = new ArrayList<>();
        for(Event event : eventList) {
            List<TicketCategory> ticketCategory = ticketCategoryRepository.findTicketCategoriesByEvent_EventID(event.getEventID());
            List<TicketCategoryDTO> ticketCategoryDTO = new ArrayList<>();
            for (TicketCategory tk : ticketCategory) {
                ticketCategoryDTO.add(new TicketCategoryDTO(tk.getTicketCategoryID(), tk.getDescription(), tk.getPrice()));
            }
            eventDTOS.add(new EventDTO(event.getEventID(), event.getVenue(),event.getEventType().getEventTypeName(), event.getEventDescription(),event.getEventName(),event.getStartDate(),event.getEndDate(),ticketCategoryDTO, event.getImage()));
        }
        return eventDTOS;
    }
}
