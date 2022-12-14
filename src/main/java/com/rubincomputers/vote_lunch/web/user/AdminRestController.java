package com.rubincomputers.vote_lunch.web.user;

import com.rubincomputers.vote_lunch.model.User;
import com.rubincomputers.vote_lunch.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }
}
