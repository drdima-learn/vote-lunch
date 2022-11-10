package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.User;
import com.rubincomputers.vote_lunch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNotFound;
import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService extends AbstractService<UserRepository, User>{

    public UserService(UserRepository repository) {
        super(repository);
    }

    public User getByEmail(String email) {
        return checkNotFound(repository.getByEmail(email), "email = " + email);
    }
}
