package com.endava.practica.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Venue")
public class Venue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer VenueID;

    @Column(name = "Location")
    private String Location;

    @Column(name = "Type")
    private String Type;

    @Column(name = "Capacity")
    private int Capacity;

//    @OneToMany(mappedBy = "VenueID")
//    private List<Event> venues;

    public Integer getVenueID() {
        return VenueID;
    }

    public void setVenueID(Integer venueID) {
        VenueID = venueID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public Venue() {
    }
}
