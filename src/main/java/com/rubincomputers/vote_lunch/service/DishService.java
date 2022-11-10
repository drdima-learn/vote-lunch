package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.repository.DishRepository;
import com.rubincomputers.vote_lunch.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class DishService extends AbstractService<DishRepository, Dish> {

    public DishService(DishRepository repository) {
        super(repository);
    }

}
