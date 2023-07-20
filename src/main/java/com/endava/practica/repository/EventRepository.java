package com.endava.practica.repository;

import java.util.List;
import com.endava.practica.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findAllByEventID(Integer EventID);
    ResponseEntity<Event> findEventByEventID(Integer EventID);
}
