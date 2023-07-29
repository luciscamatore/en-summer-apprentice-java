package com.endava.practica.services;

import com.endava.practica.DTO.TicketCategoryAddDTO;
import com.endava.practica.model.Event;
import com.endava.practica.model.TicketCategory;
import com.endava.practica.repository.EventRepository;
import com.endava.practica.repository.TicketCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketCategoryService {

    final TicketCategoryRepository ticketCategoryRepository;
    final EventRepository eventRepository;

    public TicketCategory addTicketCategory(TicketCategoryAddDTO ticketCategoryAddDTO){
        Event event = eventRepository.findEventByEventName(ticketCategoryAddDTO.getEventName());

        return ticketCategoryRepository.save(new TicketCategory(event,ticketCategoryAddDTO.getPrice(),ticketCategoryAddDTO.getDescription()));
    }

    public void deleteTicketCategory(String eventName, String description){
        TicketCategory ticketCategory = ticketCategoryRepository.findTicketCategoryByEvent_EventNameAndDescription(eventName,description);

        ticketCategoryRepository.delete(ticketCategory);
    }
}
