package com.endava.practica.controller;

import com.endava.practica.DTO.EventDTO;
import com.endava.practica.model.Event;
import com.endava.practica.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EventController {

    final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/eventById")
    public EventDTO getEventByVenueIDandEventType(@RequestParam Integer venueID, @RequestParam String eventType){
        return eventService.getEventByVenueIDandEventType(venueID, eventType);
    }
    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
}
