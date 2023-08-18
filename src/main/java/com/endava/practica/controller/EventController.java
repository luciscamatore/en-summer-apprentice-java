package com.endava.practica.controller;

import com.endava.practica.DTO.EventAddDTO;
import com.endava.practica.DTO.EventDTO;
import com.endava.practica.model.Event;
import com.endava.practica.repository.EventRepository;
import com.endava.practica.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EventController {

    final EventService eventService;
    final EventRepository eventRepository;

    private Map<String, Object> convertToResponse(final Page<Event> pageEvent){
        Map<String, Object> response = new HashMap<>();

        response.put("events", eventService.convertToDTO(pageEvent.getContent()));
        response.put("currentPage", pageEvent.getNumber());
        response.put("totalItems", pageEvent.getTotalElements());
        response.put("totalPages", pageEvent.getTotalPages());
        return response;
    }
    @GetMapping("/getEventBatch/{pageNumber}")
    public ResponseEntity<?> getEventBatch(@PathVariable int pageNumber){
        return ResponseEntity.ok(convertToResponse(eventRepository.findAll(PageRequest.of(pageNumber, 5))));
    }
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
