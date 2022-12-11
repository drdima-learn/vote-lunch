package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.exception.NotFoundException;
import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.testdata.DishTestData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.rubincomputers.vote_lunch.testdata.DishTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    private DishService service;

    @Test
    public void create() {
        Dish created = service.create(DishTestData.getNew());
        int newId = created.id();
        Dish newDish = DishTestData.getNew();
        newDish.setId(newId);
        DISH_MATCHER.assertMatch(created, newDish);
        DISH_MATCHER.assertMatch(service.get(newId), newDish);
    }

    @Test
    public void update() {
        Dish updated = DishTestData.getUpdated();
        service.update(updated);
        DISH_MATCHER.assertMatch(service.get(DISH1_ID), DishTestData.getUpdated());
    }

    @Test
    public void delete() {
        service.delete(DISH1_ID);
        assertThrows(NotFoundException.class, () -> service.get(DISH1_ID));
    }

    @Test
    public void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(DishTestData.NOT_FOUND));
    }

    @Test
    public void get() {
        Dish dish = service.get(DISH1_ID);
        DISH_MATCHER.assertMatch(dish, dish1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(DishTestData.NOT_FOUND));
    }


    @Test
    public void getAll() {
        List<Dish> all = service.getAll((dish1.getCreated().toLocalDate()));
        DISH_MATCHER.assertMatch(all, dish1, dish3, dish4, dish6);
    }


}