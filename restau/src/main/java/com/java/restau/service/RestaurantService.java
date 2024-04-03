package com.java.restau.service;

import com.java.restau.model.Restaurant;
import com.java.restau.repository.RestaurantRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public Restaurant createRestaurant(@NonNull Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant getRestaurantById(@NonNull Integer id) {
        return restaurantRepo.findById(id).orElse(null);
    }

    public boolean updateRestaurant(int id, Restaurant restaurant) {
        if (getRestaurantById(id) == null) {
            return false;
        }
        try {
            restaurantRepo.save(restaurant);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteRestaurant(int id) {
        if (getRestaurantById(id) == null) {
            return false;
        }
        restaurantRepo.deleteById(id);
        return true;
    }
}
