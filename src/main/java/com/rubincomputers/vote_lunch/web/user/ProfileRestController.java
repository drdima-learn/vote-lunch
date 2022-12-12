package com.rubincomputers.vote_lunch.web.user;

import com.rubincomputers.vote_lunch.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.rubincomputers.vote_lunch.web.SecurityUtil.authUserId;

@RestController
@RequestMapping(value = ProfileRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileRestController extends AbstractUserController {
    static final String REST_URL = "/rest/profile";


    @GetMapping
    public User get() {
        return super.get(authUserId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user) {
        super.update(user, authUserId());
    }
}
