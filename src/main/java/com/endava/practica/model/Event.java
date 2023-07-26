package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "Event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EventID")
    private Integer eventID;
    @ManyToOne
    @JoinColumn(name = "VenueID")
    private Venue venueID;

    @ManyToOne
    @JoinColumn(name = "EventTypeID")
    private EventType eventTypeID;

    @Column(name = "EventDescription")
    private String eventDescription;

    @Column(name = "EventName")
    private String eventName;

    @Column(name = "StartDate")
    private LocalDateTime startDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    public Event() {
    }
}
