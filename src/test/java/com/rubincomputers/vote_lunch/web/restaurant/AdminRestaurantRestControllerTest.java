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

import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.REST1_ID;
import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.RESTAURANT_MATCHER;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AdminRestaurantRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = AdminRestaurantRestController.REST_URL + '/';

    @Autowired
    private RestaurantService service;

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + REST1_ID))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> service.get(REST1_ID));
    }

    @Test
    void createWithLocation() throws Exception {
        Restaurant newRestaurant = RestaurantTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(AdminRestaurantRestController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newRestaurant)))
                .andExpect(status().isCreated());

        Restaurant created = RESTAURANT_MATCHER.readFromJson(action);
        int newId = created.id();
        newRestaurant.setId(newId);
        RESTAURANT_MATCHER.assertMatch(created, newRestaurant);
        RESTAURANT_MATCHER.assertMatch(service.get(newId), newRestaurant);
    }

    @Test
    void update() throws Exception {
        Restaurant updated = RestaurantTestData.getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL + REST1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        RESTAURANT_MATCHER.assertMatch(service.get(REST1_ID), updated);
    }
}