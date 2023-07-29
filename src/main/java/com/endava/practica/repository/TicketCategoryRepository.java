package com.endava.practica.repository;

import com.endava.practica.model.TicketCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketCategoryRepository extends CrudRepository<TicketCategory, Integer> {

    List<TicketCategory> findTicketCategoriesByEvent_EventID(Integer id);

    TicketCategory findTicketCategoryByEvent_EventNameAndDescription(String eventName, String description);
}
