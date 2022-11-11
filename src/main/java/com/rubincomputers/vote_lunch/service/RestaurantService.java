package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService extends AbstractService<RestaurantRepository, Restaurant> {
    public RestaurantService(RestaurantRepository repository) {
        super(repository);
    }

    public List<Restaurant> getByDateWithDishes() {
        return repository.getByDateWithDishes();
    }

}
