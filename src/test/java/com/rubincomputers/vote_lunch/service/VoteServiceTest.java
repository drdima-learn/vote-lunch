package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Vote;
import com.rubincomputers.vote_lunch.testdata.DishTestData;
import com.rubincomputers.vote_lunch.testdata.VoteTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.rubincomputers.vote_lunch.testdata.DishTestData.DISH_MATCHER;
import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.REST2_ID;
import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.REST3_ID;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.*;
import static com.rubincomputers.vote_lunch.testdata.VoteTestData.*;

public class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    private VoteService service;


    @Test
    public void get() {
        Vote vote = service.get(VOTE1_ID);
        VOTE_MATCHER.assertMatch(vote, vote1);
    }

    @Test
    public void create() {

        Vote created = service.create(VoteTestData.getNew(), ADMIN_ID, REST2_ID);
        int newId = created.id();
        Vote newVote = VoteTestData.getNew();
        newVote.setId(newId);
        VOTE_MATCHER_FLAT.assertMatch(created, newVote);
        VOTE_MATCHER_FLAT.assertMatch(service.get(newId), newVote);
    }


}