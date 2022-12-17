package com.rubincomputers.vote_lunch.testdata;

import com.rubincomputers.vote_lunch.MatcherFactory;
import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Vote;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static com.rubincomputers.vote_lunch.model.AbstractBaseEntity.START_SEQ;
import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.*;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.userAdmin;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.userUser;

public class VoteTestData {

    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(
            Vote.class, "restaurant.dishes", "user.registered");

    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER_FLAT = MatcherFactory.usingOnlyFieldsComparator(
            Vote.class, "id", "date", "restaurant.id", "user.id");

    public static final int VOTE1_ID = START_SEQ + 12;
    public static final int VOTE2_ID = START_SEQ + 13;
    public static final int VOTE3_ID = START_SEQ + 14;
    public static final int NOT_FOUND = 40;

    public static final Vote vote1 = new Vote(VOTE1_ID, userUser,  rest1, LocalDate.of(2022,11,10));
    public static final Vote vote2 = new Vote(VOTE2_ID, userUser,  rest2, LocalDate.of(2022,11,11));
    public static final Vote vote3 = new Vote(VOTE3_ID, userAdmin,  rest1, LocalDate.of(2022,11,10));



    public static Vote getNew() {
        return new Vote(null, userAdmin, rest2, LocalDate.of(2022, 11, 11));
    }

    public static Vote getUpdated() {
        Vote updated = new Vote(vote1);
        updated.setRestaurant(rest2);
        return updated;
    }

}
