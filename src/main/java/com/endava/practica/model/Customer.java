package com.endava.practica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    public Customer(String customerName, String email, String password) {
        this.customerName = customerName;
        this.email = email;
        this.password = password;
    }
}
