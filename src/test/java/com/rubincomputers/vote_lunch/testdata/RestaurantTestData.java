package com.rubincomputers.vote_lunch.testdata;

import com.rubincomputers.vote_lunch.MatcherFactory;
import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.model.Role;
import com.rubincomputers.vote_lunch.model.User;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.rubincomputers.vote_lunch.model.AbstractBaseEntity.START_SEQ;
import static com.rubincomputers.vote_lunch.testdata.DishTestData.*;

public class RestaurantTestData {

    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator("dishes");
    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER_WITH_DISHES = MatcherFactory.usingIgnoringFieldsComparator("dishes.restaurant");

    public static final int REST1_ID = START_SEQ + 3;
    public static final int REST2_ID = START_SEQ + 4;
    public static final int REST3_ID = START_SEQ + 5;
    public static final int NOT_FOUND = 20;

    public static final Restaurant rest1 = new Restaurant(REST1_ID, "Restaurant 1");
    public static final Restaurant rest2 = new Restaurant(REST2_ID, "Restaurant 2");
    public static final Restaurant rest3 = new Restaurant(REST3_ID, "Restaurant 3");

    public static Restaurant getNew() {
        return new Restaurant(null, "New Restaurant");
    }

    public static Restaurant getUpdated() {
        Restaurant updated = new Restaurant(rest1);
        updated.setName("Updated Name");
        return updated;
    }

    private static final Restaurant getRestWithDish(Restaurant rest, List<Dish> dishes){
        Restaurant r = new Restaurant(rest);
        r.setDishes(dishes);
        return r;
    }

    public static final Restaurant getRest1WithDishes2022_11_10(){
        return getRestWithDish(rest1, List.of(dish1, dish3));
    }

    public static final Restaurant getRest2WithDishes2022_11_10(){
        return getRestWithDish(rest2, List.of(dish4));
    }

    public static final Restaurant getRest3WithDishes2022_11_10(){
        return getRestWithDish(rest3, List.of(dish6));
    }


}
