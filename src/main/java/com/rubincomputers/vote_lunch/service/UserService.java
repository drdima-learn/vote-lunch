package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.User;
import com.rubincomputers.vote_lunch.repository.UserRepository;
import org.springframework.stereotype.Service;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNotFound;

@Service
public class UserService extends AbstractService<UserRepository, User> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    public User getByEmail(String email) {
        return checkNotFound(repository.getByEmail(email), "email = " + email);
    }
}
