package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {

    @Autowired
    private DishRepository repository;


    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "meal must not be null");
        return repository.save(dish, restaurantId);
    }




    public List<Dish> getAll(LocalDate day) {
        return repository.getAll(day);
    }

    public Dish get(int id, int restaurantId) {
        return checkNotFoundWithId(repository.get(id, restaurantId), id);
    }

    public void update(Dish dish, int restaurantId) {
        Assert.notNull(dish, "meal must not be null");
        checkNotFoundWithId(repository.save(dish, restaurantId), dish.id());
    }
}
