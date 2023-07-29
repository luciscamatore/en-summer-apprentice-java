package com.endava.practica.repository;

import com.endava.practica.model.Venue;
import org.springframework.data.repository.CrudRepository;

public interface VenueRepository extends CrudRepository<Venue, Integer> {
    Venue findByVenueID(Integer venueID);
    Venue findVenueByLocation(String venueLocation);
}
