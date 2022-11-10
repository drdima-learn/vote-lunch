package com.rubincomputers.vote_lunch.repository.datajpa.restaurant;

import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    @Autowired
    private CrudRestaurantRepository crudRepository;


    @Override
    public Restaurant save(Restaurant restaurant) {
        return crudRepository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {

        return crudRepository.delete(id) !=0;
    }

    @Override
    public Restaurant get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRepository.findAll(SORT_NAME);
    }
}
