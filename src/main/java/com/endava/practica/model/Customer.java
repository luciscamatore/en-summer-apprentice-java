package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "Email")
    private String email;

    public Customer() {
    }

    public Customer(Integer customerID) {
        this.customerID = customerID;
    }
}
