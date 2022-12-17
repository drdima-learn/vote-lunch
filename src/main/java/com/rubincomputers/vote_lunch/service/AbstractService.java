package com.rubincomputers.vote_lunch.service;

import com.rubincomputers.vote_lunch.model.AbstractBaseEntity;
import com.rubincomputers.vote_lunch.repository.BaseRepository;
import org.springframework.util.Assert;

import java.util.List;

import static com.rubincomputers.vote_lunch.util.ValidationUtil.checkNotFoundWithId;

public abstract class AbstractService<ENTITY_REPOSITORY extends BaseRepository<ENTITY>, ENTITY extends AbstractBaseEntity> {


    protected ENTITY_REPOSITORY repository;

    public AbstractService(ENTITY_REPOSITORY repository) {
        this.repository = repository;
    }

    public ENTITY create(ENTITY entity) {
        Assert.notNull(entity, "entity " + entity.getClass().getSimpleName() + " must not be null");
        return repository.save(entity);
    }

    public void update(ENTITY entity) {
        Assert.notNull(entity, "user must not be null");
        checkNotFoundWithId(repository.save(entity), entity.id());
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public ENTITY get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<ENTITY> getAll() {
        return repository.getAll();
    }

}
