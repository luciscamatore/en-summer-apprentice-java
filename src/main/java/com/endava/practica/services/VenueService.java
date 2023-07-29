package com.endava.practica.services;

import com.endava.practica.DTO.VenueDTO;
import com.endava.practica.model.Venue;
import com.endava.practica.repository.VenueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VenueService {

    final VenueRepository venueRepository;
    public Venue addVenue(VenueDTO venueDTO){
        return  venueRepository.save(new Venue(venueDTO.getLocation(), venueDTO.getType(),venueDTO.getCapacity()));
    }

    public void deleteVenue(String venueLocaion){
        Venue venue = venueRepository.findVenueByLocation(venueLocaion);

        venueRepository.delete(venue);
    }
}
