package com.endava.practica.services;

import com.endava.practica.model.Event;
import com.endava.practica.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public Event getEventByID(Integer EventID){
        return eventRepository.findEventByEventID(EventID).getBody();
    }
}
