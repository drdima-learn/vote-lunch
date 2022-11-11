package com.rubincomputers.vote_lunch.repository.datajpa.user;

import com.rubincomputers.vote_lunch.model.User;
import com.rubincomputers.vote_lunch.repository.UserRepository;
import com.rubincomputers.vote_lunch.repository.datajpa.AbstractDataJpaBaseRepository;
import com.rubincomputers.vote_lunch.repository.datajpa.user.CrudUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository extends AbstractDataJpaBaseRepository<CrudUserRepository, User> implements UserRepository {
    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");

    public DataJpaUserRepository(CrudUserRepository crudUserRepository) {
        super(crudUserRepository);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public User getByEmail(String email) {
        return crudRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }
}
