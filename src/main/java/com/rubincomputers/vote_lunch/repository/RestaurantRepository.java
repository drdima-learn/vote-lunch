package com.rubincomputers.vote_lunch.repository;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.model.User;

import java.util.List;

public interface RestaurantRepository extends BaseRepository<Restaurant>{

    List<Restaurant> getByDateWithDishes();
}