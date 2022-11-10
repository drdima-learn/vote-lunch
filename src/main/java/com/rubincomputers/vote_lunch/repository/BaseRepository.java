package com.rubincomputers.vote_lunch.repository;

import java.util.List;

public interface BaseRepository<ENTITY> {
    // null if not found, when updated
    ENTITY save(ENTITY entity);


    // false if not found
    boolean delete(int id);

    // null if not found
    ENTITY get(int id);

    List<ENTITY> getAll();
}
