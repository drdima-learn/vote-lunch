package com.rubincomputers.vote_lunch.repository;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface DishRepository{


    List<Dish> getAll(LocalDate day);

    Dish save(Dish dish, int restaurantId);

    // null if meal does not belong to userId
    Dish get(int id, int restaurantId);
}