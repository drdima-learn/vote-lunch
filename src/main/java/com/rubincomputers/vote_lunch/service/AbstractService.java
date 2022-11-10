package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public abstract class AbstractService<T> {

    protected T repository;

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

}
