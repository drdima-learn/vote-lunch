package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.exception.NotFoundException;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.model.User;
import com.rubincomputers.vote_lunch.testdata.RestaurantTestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.*;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.*;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.NOT_FOUND;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.userUser;
import static org.junit.Assert.assertThrows;

public class RestaurantServiceTest extends AbstractTest {

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
}