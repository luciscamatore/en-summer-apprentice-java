package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "EventType")
public class EventType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventTypeID;

    @Column(name = "EventTypeName")
    private String eventTypeName;

    public EventType() {
    }
}
