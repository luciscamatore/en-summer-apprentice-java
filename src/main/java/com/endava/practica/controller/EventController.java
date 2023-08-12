package com.endava.practica.controller;

import com.endava.practica.DTO.EventAddDTO;
import com.endava.practica.DTO.EventDTO;
import com.endava.practica.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EventController {

    final EventService eventService;

    @GetMapping("/eventById")
    public EventDTO getEventByVenueIDandEventType(@RequestParam Integer venueID, @RequestParam String eventType){
        return eventService.getEventByVenueIDandEventType(venueID, eventType);
    }
    @GetMapping("/getAllEvents")
    public List<EventDTO> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("/getEventsByFilter/{location}/{type}")
    public List<EventDTO> getEventsByFilter(@PathVariable String location, @PathVariable String type){
        return eventService.getEventsByFilter(location, type);
    }
    @PostMapping("/postEvent")
    public EventDTO postEvent(@RequestBody EventAddDTO eventAddDTO){
        return eventService.postEvents(eventAddDTO);
    }
    @DeleteMapping("/deleteEvent")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEvent(@RequestParam String eventName) {
        eventService.deleteEvent(eventName);
    }
}
