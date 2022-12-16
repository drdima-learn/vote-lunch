package com.rubincomputers.vote_lunch.repository.datajpa.dish;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.repository.DishRepository;
import com.rubincomputers.vote_lunch.repository.RestaurantRepository;
import com.rubincomputers.vote_lunch.repository.datajpa.AbstractDataJpaBaseRepository;
import com.rubincomputers.vote_lunch.repository.datajpa.restaurant.CrudRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class DataJpaDishRepository implements DishRepository {

    @Autowired
    private CrudDishRepository crudDishRepository;

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;



    @Override
    public List<Dish> getAll(LocalDate day) {
        return crudDishRepository.findByCreatedBetween(
                LocalDateTime.of(day, LocalTime.MIN),
                LocalDateTime.of(day, LocalTime.MAX)
        );
    }

    @Override
    @Transactional
    public Dish save(Dish dish, int restaurantId) {
        if (!dish.isNew() && get(dish.id(), restaurantId) == null) {
            return null;
        }
        dish.setRestaurant(crudRestaurantRepository.getReferenceById(restaurantId));
        return crudDishRepository.save(dish);
    }

    @Override
    public Dish get(int id, int restaurantId) {
        return crudDishRepository.findById(id)
                .filter(restaurant -> restaurant.getRestaurant().getId() == restaurantId)
                .orElse(null);
    }


}
