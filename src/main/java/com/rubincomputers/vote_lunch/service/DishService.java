package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.repository.DishRepository;
import com.rubincomputers.vote_lunch.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DishService extends AbstractService<DishRepository, Dish> {

    public DishService(DishRepository repository) {
        super(repository);
    }


    @Override
    public Dish create(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public List<Dish> getAll() {
        throw new UnsupportedOperationException("Use getAll(LocalDate)");
    }


    public List<Dish> getAll(LocalDate day) {
        return repository.getAll(day);
    }
}
