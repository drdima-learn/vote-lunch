package com.rubincomputers.vote_lunch.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "dish")
public class Dish extends AbstractNamedEntity{
    //id
    //name

    private BigDecimal price;

    private LocalDate created;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;



    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
