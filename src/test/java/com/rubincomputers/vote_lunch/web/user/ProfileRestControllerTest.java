package com.rubincomputers.vote_lunch.web.user;

import com.rubincomputers.vote_lunch.service.UserService;
import com.rubincomputers.vote_lunch.web.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.rubincomputers.vote_lunch.testdata.UserTestData.USER_MATCHER;
import static com.rubincomputers.vote_lunch.testdata.UserTestData.userUser;
import static com.rubincomputers.vote_lunch.web.user.ProfileRestController.REST_URL;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProfileRestControllerTest extends AbstractControllerTest {

    @Autowired
    private UserService userService;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(USER_MATCHER.contentJson(userUser));
    }
}