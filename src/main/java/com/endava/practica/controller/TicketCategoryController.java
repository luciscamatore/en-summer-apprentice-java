package com.endava.practica.controller;

import com.endava.practica.DTO.TicketCategoryAddDTO;
import com.endava.practica.model.TicketCategory;
import com.endava.practica.services.TicketCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TicketCategoryController {

    final TicketCategoryService ticketCategoryService;

    @PostMapping("/addTicketCategory")
    public TicketCategory addTicketCategory(@RequestBody TicketCategoryAddDTO ticketCategoryAddDTO){
        return ticketCategoryService.addTicketCategory(ticketCategoryAddDTO);
    }

    @DeleteMapping("/deleteTicketCategory")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTicketCategory(@RequestParam String eventName, @RequestParam String description){
        ticketCategoryService.deleteTicketCategory(eventName,description);
    }
}
