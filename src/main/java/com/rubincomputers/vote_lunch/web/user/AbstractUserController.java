package com.rubincomputers.vote_lunch.web.user;

import com.rubincomputers.vote_lunch.model.User;
import com.rubincomputers.vote_lunch.service.UserService;
import com.rubincomputers.vote_lunch.web.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.assureIdConsistent;

public abstract class AbstractUserController extends AbstractController {


    @Autowired
    protected UserService service;

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }
}
