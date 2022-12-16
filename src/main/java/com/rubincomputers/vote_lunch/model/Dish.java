package com.rubincomputers.vote_lunch.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity {
    //id
    //name

    private BigDecimal price;

    @Column(name = "created", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Restaurant restaurant;


    public Dish(Integer id, String name, BigDecimal price, LocalDateTime created, Restaurant restaurant) {
        super(id, name);
        this.price = price;
        this.created = created;
        this.restaurant = restaurant;
    }

    public Dish(Dish d) {
        this(d.id, d.name, d.price, d.created, d.restaurant);
    }

    public Dish() {

    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", created=" + created +
                '}';
    }
}
