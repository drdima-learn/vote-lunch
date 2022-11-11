package com.rubincomputers.vote_lunch.repository;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface DishRepository extends BaseRepository<Dish>{


    List<Dish> getAll(LocalDate day);
}