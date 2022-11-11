package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService extends AbstractService<RestaurantRepository, Restaurant> {
    public RestaurantService(RestaurantRepository repository) {
        super(repository);
    }

    public List<Restaurant> getAllByDateWithDishes(LocalDate day) {
        return repository.getAllByDateWithDishes(day);
    }

}
