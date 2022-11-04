package com.rubincomputers.vote_lunch.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Dish extends AbstractNamedEntity{
    //name
    private BigDecimal price;
    private Restaurant restaurant;
    private LocalDate date;
}
