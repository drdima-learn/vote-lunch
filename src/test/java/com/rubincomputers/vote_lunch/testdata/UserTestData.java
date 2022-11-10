package com.rubincomputers.vote_lunch.testdata;

import com.rubincomputers.vote_lunch.MatcherFactory;
import com.rubincomputers.vote_lunch.model.Role;
import com.rubincomputers.vote_lunch.model.User;

import java.time.Month;
import java.util.Collections;
import java.util.Date;

import static com.rubincomputers.vote_lunch.model.AbstractBaseEntity.START_SEQ;
import static java.time.LocalDateTime.of;

public class UserTestData {

    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoringFieldsComparator("registered", "roles");

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int GUEST_ID = START_SEQ + 2;
    public static final int NOT_FOUND = 10;

    public static final User userUser = new User(USER_ID, "User", "user@yandex.ru", "password", Role.USER);
    public static final User userAdmin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ADMIN);
    public static final User userGuest = new User(GUEST_ID, "Guest", "guest@gmail.com", "guest");

    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", false, new Date(), Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        User updated = new User(userUser);
        updated.setEmail("update@gmail.com");
        updated.setName("UpdatedName");
        updated.setPassword("newPass");
        updated.setEnabled(false);
        updated.setRoles(Collections.singletonList(Role.ADMIN));
        return updated;
    }

    public static User getUpdatedNotFound() {
        User updated = getUpdated();
        updated.setId(NOT_FOUND);
        return updated;
    }


}
