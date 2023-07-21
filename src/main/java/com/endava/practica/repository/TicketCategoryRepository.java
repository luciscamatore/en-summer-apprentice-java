package com.endava.practica.repository;

import com.endava.practica.model.TicketCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TicketCategoryRepository extends CrudRepository<TicketCategory, Integer> {
}
