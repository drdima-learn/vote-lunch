package com.rubincomputers.vote_lunch.repository;

import com.rubincomputers.vote_lunch.model.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User> {
    // null if not found
    User getByEmail(String email);

}