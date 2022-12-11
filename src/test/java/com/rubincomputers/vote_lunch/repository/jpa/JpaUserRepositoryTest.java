package com.rubincomputers.vote_lunch.repository.jpa;

import com.rubincomputers.vote_lunch.model.User;
import com.rubincomputers.vote_lunch.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.rubincomputers.vote_lunch.testdata.UserTestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitWebConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Transactional
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
//@Ignore
public class JpaUserRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(JpaUserRepositoryTest.class);

    @Autowired
    private UserRepository repository;

    @Test
    public void get() {
        User user = repository.get(USER_ID);
        USER_MATCHER.assertMatch(user, userUser);
    }

    @Test
    public void getNotFound() {
        User user = repository.get(NOT_FOUND);
        USER_MATCHER.assertMatch(user, null);
    }


    @Test
    public void getAll() {
        List<User> users = repository.getAll();
        log.info("users = {}", users);
        USER_MATCHER.assertMatch(users, userAdmin, userGuest, userUser);
    }

    @Test
    public void getByEmail() {
        User user = repository.getByEmail(userUser.getEmail());
        log.info("user = {}", user);
        USER_MATCHER.assertMatch(user, userUser);
    }

    @Test
    public void delete() {
        boolean result = repository.delete(USER_ID);
        log.info("result = {}", result);
        assertTrue(result);
    }

    @Test
    public void deleteNotFound() {
        boolean result = repository.delete(NOT_FOUND);
        log.info("result = {}", result);
        assertFalse(result);
    }

    @Test
    public void save() {
        User created = repository.save(getNew());
        User newUser = getNew();
        newUser.setId(created.getId());
        USER_MATCHER.assertMatch(created, newUser);

        User user = repository.get(created.getId());
        USER_MATCHER.assertMatch(user, newUser);
    }

    @Test
    public void update() {
        User updated = repository.save(getUpdated());
        USER_MATCHER.assertMatch(updated, getUpdated());

        User user = repository.get(getUpdated().getId());
        USER_MATCHER.assertMatch(user, getUpdated());
    }

    @Test
    public void updateNotFound() {
        User updated = repository.save(getUpdatedNotFound());
        USER_MATCHER.assertMatch(updated, null);

        User user = repository.get(getUpdatedNotFound().getId());
        USER_MATCHER.assertMatch(user, null);
    }
}