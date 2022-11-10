package com.rubincomputers.vote_lunch.repository;

import com.rubincomputers.vote_lunch.model.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User> {

    // null if not found, when updated
    //User save(User user);

    // false if not found
    //boolean delete(int id);

    // null if not found
    //User get(int id);

    // null if not found
    User getByEmail(String email);


//    List<User> getAll();
}