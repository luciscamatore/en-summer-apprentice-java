package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @Column(name = "EventImage")
    private String image;

    public Event(Venue venue, EventType eventType, String eventDescription, String eventName, LocalDateTime startDate, LocalDateTime endDate, String image) {
        this.venue = venue;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
    }
}
