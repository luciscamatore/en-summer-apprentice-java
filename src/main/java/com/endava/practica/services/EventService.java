package com.endava.practica.services;

import com.endava.practica.model.Event;
import com.endava.practica.model.Venue;
import com.endava.practica.repository.EventRepository;
import com.endava.practica.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    VenueRepository venueRepository;

    public Event getEventByID(Integer EventID){
        return eventRepository.findById(EventID).get();
    }

    public List<Event> getAllEvents(){
        List<Event> ev = new ArrayList<>();
        eventRepository.findAll().forEach(ev1 ->ev.add(ev1));
        return ev;
    }

//    public List<String> getEventByVenueIDandEventType(Integer VenueID, String EventType){
//        List<Event> events = new ArrayList<>();
//
//    }
}
