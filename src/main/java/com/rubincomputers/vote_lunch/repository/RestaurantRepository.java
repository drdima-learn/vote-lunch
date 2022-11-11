package com.rubincomputers.vote_lunch.repository;

import com.rubincomputers.vote_lunch.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository extends BaseRepository<Restaurant>{

    List<Restaurant> getAllByDateWithDishes(LocalDate day);
}