package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.exception.NotFoundException;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.testdata.DishTestData;
import com.rubincomputers.vote_lunch.testdata.RestaurantTestData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.*;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.NOT_FOUND;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    private RestaurantService service;

    @Test
    public void create() {
        Restaurant created = service.create(RestaurantTestData.getNew());
        int newId = created.id();
        Restaurant newRestaurant = RestaurantTestData.getNew();
        newRestaurant.setId(newId);
        RESTAURANT_MATCHER.assertMatch(created, newRestaurant);
        RESTAURANT_MATCHER.assertMatch(service.get(newId), newRestaurant);
    }

    @Test
    public void update() {
        Restaurant updated = RestaurantTestData.getUpdated();
        service.update(updated);
        RESTAURANT_MATCHER.assertMatch(service.get(REST1_ID), RestaurantTestData.getUpdated());
    }

    @Test
    public void delete() {
        service.delete(REST1_ID);
        assertThrows(NotFoundException.class, () -> service.get(REST1_ID));
    }

    @Test
    public void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(RestaurantTestData.NOT_FOUND));
    }

    @Test
    public void get() {
        Restaurant restaurant = service.get(REST1_ID);
        RESTAURANT_MATCHER.assertMatch(restaurant, rest1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void getAll() {
        List<Restaurant> all = service.getAll();
        RESTAURANT_MATCHER.assertMatch(all, rest1, rest2, rest3);
    }

    @Test
    public void getByDateWithDishes() {
        List<Restaurant> all = service.getAllByDateWithDishes(DishTestData.dish1.getCreated().toLocalDate());
        RESTAURANT_MATCHER_WITH_DISHES.assertMatch(all, getRest1WithDishes2022_11_10(), getRest2WithDishes2022_11_10(), getRest3WithDishes2022_11_10());
    }
}