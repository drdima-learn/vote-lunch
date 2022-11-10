package com.rubincomputers.vote_lunch.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity{



    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    List<Dish> dishes;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Restaurant(Restaurant r){
        this(r.getId(), r.getName());
    }
}
