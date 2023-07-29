package com.endava.practica.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventAddDTO {
    public String venueLocation;
    public Integer eventTypeID;
    public String eventName;
    public String eventDescription;
    public LocalDateTime startDate;
    public LocalDateTime endDate;


}
