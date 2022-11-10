package com.rubincomputers.vote_lunch.repository.datajpa;

import com.rubincomputers.vote_lunch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractDataJpaBaseRepository<CRUD_REPOSITORY extends JpaRepository<ENTITY, Integer>, ENTITY>  {


    protected CRUD_REPOSITORY crudRepository;

    public AbstractDataJpaBaseRepository(CRUD_REPOSITORY crudRepository) {
        this.crudRepository = crudRepository;
    }

    public ENTITY save(ENTITY entity) {
        return crudRepository.save(entity);
    }

    public ENTITY get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    public List<ENTITY> getAll() {
        return crudRepository.findAll();
    }


}
