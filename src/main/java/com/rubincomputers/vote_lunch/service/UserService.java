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

//    @Autowired
//    private UserRepository repository;
//
//
//
//    public User create(User user) {
//        Assert.notNull(user, "user must not be null");
//        return repository.save(user);
//    }


    public UserService(UserRepository repository) {
        super(repository);
    }

//    public void update(User user) {
//        Assert.notNull(user, "user must not be null");
//        checkNotFoundWithId(repository.save(user), user.id());
//    }

//    public void delete(int id) {
//        checkNotFoundWithId(repository.delete(id), id);
//    }

//    public User get(int id) {
//        return checkNotFoundWithId(repository.get(id), id);
//    }

//    public List<User> getAll() {
//        return repository.getAll();
//    }




    public User getByEmail(String email) {
        return checkNotFound(repository.getByEmail(email), "email = " + email);
    }
}
