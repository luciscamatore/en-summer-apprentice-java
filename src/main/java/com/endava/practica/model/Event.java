package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EventID")
    private Integer eventID;
    @ManyToOne
    @JoinColumn(name = "VenueID")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "EventTypeID")
    private EventType eventType;

    @Column(name = "EventDescription")
    private String eventDescription;

    @Column(name = "EventName")
    private String eventName;

    @Column(name = "StartDate")
    private LocalDateTime startDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    public Event(Venue venue, EventType eventType, String eventDescription, String eventName, LocalDateTime startDate, LocalDateTime endDate) {
        this.venue = venue;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
