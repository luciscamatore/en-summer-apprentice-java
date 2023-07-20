package com.endava.practica.controller;

import com.endava.practica.model.Event;
import com.endava.practica.repository.EventRepository;
import com.endava.practica.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    EventService eventService;

//    @GetMapping("/event")
//    public List<String> getEventByVenueIDandEventType(Integer VenueID, String EventType){
//        return eventService.getEventByVenueIDandEventType(VenueID, EventType);
//    }
    @GetMapping("/allev")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
}
