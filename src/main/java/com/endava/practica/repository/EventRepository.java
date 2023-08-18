package com.endava.practica.repository;

import java.util.List;

import com.endava.practica.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findEventsByVenue_VenueIDAndEventType_EventTypeName(Integer id, String eventName);

    Event findEventByEventName(String eventName);

    List<Event> findEventsByVenue_LocationAndEventType_EventTypeName(String location, String type);
    List<Event> findEventsByVenue_Location(String location);
    List<Event> findEventsByEventType_EventTypeName(String type);

}
