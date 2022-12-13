package com.rubincomputers.vote_lunch.web.restaurant;

import com.rubincomputers.vote_lunch.exception.NotFoundException;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.service.RestaurantService;
import com.rubincomputers.vote_lunch.testdata.RestaurantTestData;
import com.rubincomputers.vote_lunch.web.AbstractControllerTest;
import com.rubincomputers.vote_lunch.web.json.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.*;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.*;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.userUser;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RestaurantRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantRestController.REST_URL + '/';

    @Autowired
    private RestaurantService service;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + REST1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER.contentJson(rest1));
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER.contentJson(rest1, rest2, rest3));
    }

    @Test
    void getAllByDateWithDishes() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER_WITH_DISHES.contentJson(rest1, rest2, rest3));
    }






}