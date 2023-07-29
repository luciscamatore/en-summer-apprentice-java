package com.endava.practica.controller;

import com.endava.practica.DTO.VenueDTO;
import com.endava.practica.model.Venue;
import com.endava.practica.services.VenueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class VenueController {

    final VenueService venueService;

    @PostMapping("/addVenue")
    public Venue addVenue(@RequestBody VenueDTO venueDTO){
        return venueService.addVenue(venueDTO);
    }

    @DeleteMapping("/deleteVenue")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteVenue(@RequestParam String venueLocation)
    {
        venueService.deleteVenue(venueLocation);
    }
}
