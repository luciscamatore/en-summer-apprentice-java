package com.endava.practica.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EventID")
    private Integer eventID;
    @ManyToOne
    @JoinColumn(name = "VenueID")
    private Venue VenueID;

    @ManyToOne
    @JoinColumn(name = "EventTypeID")
    private EventType EventTypeID;

    @Column(name = "EventDescription")
    private String EventDescription;

    @Column(name = "EventName")
    private String EventName;

    @Column(name = "StartDate")
    private LocalDateTime StartDate;

    @Column(name = "EndDate")
    private LocalDateTime EndDate;

    public Integer getEventID() {
        return eventID;
    }

    public Venue getVenueID() {
        return VenueID;
    }

    public EventType getEventTypeID() {
        return EventTypeID;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public String getEventName() {
        return EventName;
    }

    public LocalDateTime getStartDate() {
        return StartDate;
    }

    public LocalDateTime getEndDate() {
        return EndDate;
    }

    public void setEventID(Integer eventID) {
        eventID = eventID;
    }

    public void setVenueID(Venue venueID) {
        VenueID = venueID;
    }

    public void setEventTypeID(EventType eventTypeID) {
        EventTypeID = eventTypeID;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public void setStartDate(LocalDateTime startDate) {
        StartDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        EndDate = endDate;
    }

    public Event() {
    }
}
