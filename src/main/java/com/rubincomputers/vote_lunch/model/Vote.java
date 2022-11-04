package com.rubincomputers.vote_lunch.model;

import java.time.LocalDate;

public class Vote extends AbstractBaseEntity{
    private User user;
    private Restaurant restaurant;
    LocalDate date;

}
