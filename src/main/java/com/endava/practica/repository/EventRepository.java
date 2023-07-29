package com.endava.practica.repository;

import java.util.List;
import com.endava.practica.model.Event;
import com.endava.practica.model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    Event findEventsByVenue_VenueIDAndEventType_EventTypeName(Integer id, String eventName);

    Event findEventByEventName(String eventName);
}
