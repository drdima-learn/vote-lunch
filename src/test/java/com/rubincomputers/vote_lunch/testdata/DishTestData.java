package com.rubincomputers.vote_lunch.testdata;

import com.rubincomputers.vote_lunch.MatcherFactory;
import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import static com.rubincomputers.vote_lunch.model.AbstractBaseEntity.START_SEQ;
import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.*;

public class DishTestData {

    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingIgnoringFieldsComparator("restaurant");

    public static final int DISH1_ID = START_SEQ + 6;
    public static final int DISH2_ID = START_SEQ + 7;
    public static final int DISH3_ID = START_SEQ + 8;
    public static final int DISH4_ID = START_SEQ + 9;
    public static final int DISH5_ID = START_SEQ + 10;
    public static final int DISH6_ID = START_SEQ + 11;
    public static final int NOT_FOUND = 30;

    public static final Dish dish1 = new Dish(DISH1_ID, "Dish 1 , Restaurant 1", new BigDecimal("10.00"), LocalDateTime.of(2022, Month.NOVEMBER, 10, 10, 00), rest1);
    public static final Dish dish2 = new Dish(DISH2_ID, "Dish 2 , Restaurant 1", new BigDecimal("20.00"), LocalDateTime.of(2022, Month.NOVEMBER, 10, 10, 10), rest1);
    public static final Dish dish3 = new Dish(DISH3_ID, "Dish 3 , Restaurant 1", new BigDecimal("30.00"), LocalDateTime.of(2022, Month.NOVEMBER, 10, 10, 20), rest1);
    public static final Dish dish4 = new Dish(DISH4_ID, "Dish 4 , Restaurant 2", new BigDecimal("40.00"), LocalDateTime.of(2022, Month.NOVEMBER, 10, 10, 30), rest2);
    public static final Dish dish5 = new Dish(DISH5_ID, "Dish 5 , Restaurant 2", new BigDecimal("30.00"), LocalDateTime.of(2022, Month.NOVEMBER, 10, 10, 40), rest2);
    public static final Dish dish6 = new Dish(DISH6_ID, "Dish 6 , Restaurant 3", new BigDecimal("30.00"), LocalDateTime.of(2022, Month.NOVEMBER, 10, 10, 50), rest3);


    public static Dish getNew() {
        return new Dish(null, "New Dish", BigDecimal.valueOf(101.01), LocalDateTime.of(2022, Month.NOVEMBER, 12, 12, 30), rest3);
    }

    public static Dish getUpdated() {
        Dish updated = new Dish(dish1);
        updated.setName("Dish name Updated");
        updated.setPrice(BigDecimal.valueOf(1000.12));
        return updated;
    }

}
