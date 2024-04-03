package com.java.restau.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer restaurantId;
    @Column(name="restaurantName")
    private String restaurantName;
    @Column(name="Location")
    private String location;
    @Column(name="Owner")
    private String owner;
    @Column(name="Type")
    private String type;
    @Column(name="rating")
    private double rating;

    public Restaurant(Integer restaurantId, String restaurantName, String location, String owner, String type, double rating) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
        this.owner = owner;
        this.type = type;
        this.rating = rating;
    }

}
