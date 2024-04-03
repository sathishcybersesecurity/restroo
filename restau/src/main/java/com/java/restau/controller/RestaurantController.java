package com.java.restau.controller;

import com.java.restau.model.Restaurant;
import com.java.restau.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurantService.createRestaurant(restaurant);
        if (newRestaurant != null) {
            return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        if (!restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PutMapping("/restaurant/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable int restaurantId, @RequestBody Restaurant restaurant) {
        boolean updated = restaurantService.updateRestaurant(restaurantId, restaurant);
        if (updated) {
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public ResponseEntity<Boolean> deleteRestaurant(@PathVariable int restaurantId) {
        boolean deleted = restaurantService.deleteRestaurant(restaurantId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
