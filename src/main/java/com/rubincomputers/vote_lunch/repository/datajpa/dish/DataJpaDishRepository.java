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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class DataJpaDishRepository extends AbstractDataJpaBaseRepository<CrudDishRepository, Dish> implements DishRepository {

    public DataJpaDishRepository(CrudDishRepository crudDishRepository) {
        super(crudDishRepository);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) !=0;
    }

    @Override
    public List<Dish> getAll(LocalDate day) {
        return crudRepository.findByCreatedBetween(
                LocalDateTime.of(day, LocalTime.MIN),
                LocalDateTime.of(day, LocalTime.MAX)
        );
    }
}
