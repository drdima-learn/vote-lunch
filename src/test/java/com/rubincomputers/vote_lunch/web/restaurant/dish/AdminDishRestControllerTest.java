package com.rubincomputers.vote_lunch.web.restaurant.dish;

import com.rubincomputers.vote_lunch.model.Dish;
import com.rubincomputers.vote_lunch.model.Restaurant;
import com.rubincomputers.vote_lunch.service.DishService;
import com.rubincomputers.vote_lunch.testdata.DishTestData;
import com.rubincomputers.vote_lunch.testdata.RestaurantTestData;
import com.rubincomputers.vote_lunch.web.AbstractControllerTest;
import com.rubincomputers.vote_lunch.web.json.JsonUtil;
import com.rubincomputers.vote_lunch.web.restaurant.AdminRestaurantRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.rubincomputers.vote_lunch.testdata.DishTestData.*;
import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.REST1_ID;
import static com.rubincomputers.vote_lunch.testdata.RestaurantTestData.RESTAURANT_MATCHER;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AdminDishRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = AdminDishRestController.REST_URL + '/';

    @Autowired
    private DishService service;

    private static String getRestUrlWithRestaurantId(int restaurantId) {
        return REST_URL.replace("{restaurantId}", String.valueOf(restaurantId));
    }


    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(getRestUrlWithRestaurantId(REST1_ID) + DISH1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentJson(dish1));
    }

    @Test
    void createWithLocation() throws Exception {
        Dish newDish = DishTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(getRestUrlWithRestaurantId(REST1_ID))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDish)))
                .andExpect(status().isCreated());

        Dish created = DISH_MATCHER.readFromJson(action);
        int newId = created.id();
        newDish.setId(newId);
        DISH_MATCHER.assertMatch(created, newDish);
        DISH_MATCHER.assertMatch(service.get(newId, REST1_ID), newDish);
    }

    @Test
    void update() throws Exception {
        Dish updated = DishTestData.getUpdated();
        perform(MockMvcRequestBuilders.put(getRestUrlWithRestaurantId(REST1_ID) + DISH1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        DISH_MATCHER.assertMatch(service.get(DISH1_ID, REST1_ID), updated);
    }
}