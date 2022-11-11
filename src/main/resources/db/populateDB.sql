
DELETE FROM user_roles;
DELETE FROM users;

DELETE FROM dishes;
DELETE FROM restaurants;


ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO restaurants (name)
VALUES ('Restaurant 1'),
       ('Restaurant 2'),
       ('Restaurant 3');

INSERT INTO dishes (name, price, created, restaurant_id)
VALUES ('Dish 1 , Restaurant 1', 10.00, '2022-11-10 10:00:00', 100003),
       ('Dish 2 , Restaurant 1', 20.00, '2022-11-11 10:10:00', 100003),
       ('Dish 3 , Restaurant 1', 30.00, '2022-11-10 10:20:00', 100003),
       ('Dish 4 , Restaurant 2', 40.00, '2022-11-10 10:30:00', 100004),
       ('Dish 5 , Restaurant 2', 30.00, '2022-11-11 10:40:00', 100004),
       ('Dish 6 , Restaurant 3', 30.00, '2022-11-10 10:50:00', 100005);

