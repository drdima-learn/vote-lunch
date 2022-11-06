package com.rubincomputers.vote_lunch.repository.jpa;

import com.rubincomputers.vote_lunch.model.Role;
import com.rubincomputers.vote_lunch.model.User;
import com.rubincomputers.vote_lunch.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import java.util.List;
import java.util.Set;

@Repository
@Transactional(readOnly = true)
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()){
            em.persist(user);
            return user;
        } else {
            if (em.createNamedQuery(User.UPDATE)
                    .setParameter("id", user.getId())
                    .setParameter("name", user.getName())
                    .setParameter("email", user.getEmail())
                    .setParameter("password", user.getPassword())
                    .setParameter("enabled", user.isEnabled())
                    .setParameter("registered", user.getRegistered())
                   // .setParameter("roles", user.getRoles())
                    .executeUpdate() ==1){
                return user;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
       return em.createNamedQuery(User.DELETE)
               .setParameter("id", id)
               .executeUpdate() != 0;
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        return em.createNamedQuery(User.BY_EMAIL, User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_SORTED, User.class)
                .getResultList();
    }
}
