package com.rubincomputers.vote_lunch.repository.datajpa.restaurant;

import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.repository.RestaurantRepository;
import com.rubincomputers.vote_lunch.repository.datajpa.AbstractDataJpaBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository extends AbstractDataJpaBaseRepository<CrudRestaurantRepository, Restaurant> implements RestaurantRepository {

    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    public DataJpaRestaurantRepository(CrudRestaurantRepository crudRestaurantRepository) {
        super(crudRestaurantRepository);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) !=0;
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRepository.findAll(SORT_NAME);
    }

    public List<Restaurant> getByDateWithDishes() {
        return crudRepository.getByDateWithDishes();
    }
}
