--liquibase formatted sql

--changeset fokusmod:insert_data

insert into categories (title)
values ('Products'),
       ('Beverages'),
       ('Vegetables'),
       ('Fruit');

insert into products (title, price, category_id)
values ('Apple', 150, 4),
       ('Banana', 100, 4),
       ('Orange', 120, 4),
       ('Papaya', 120, 4),
       ('Milk', 140, 2),
       ('Cheese', 270, 1),
       ('Cheeps', 100, 1),
       ('Potato', 70, 3),
       ('Chicken egg', 120, 1),
       ('Meat', 300, 1),
       ('Chocolate', 130, 1),
       ('Kiwi', 140, 4),
       ('Tomato', 120, 3),
       ('Pineapple', 200, 4),
       ('Bread', 300, 1),
       ('Tea', 250, 1),
       ('Coffee', 300, 1),
       ('Cacao', 150, 1),
       ('Bear', 210, 2),
       ('Fish', 300, 1);



insert into roles (name)
values ('ROLE_ADMIN'),
       ('ROLE_USER'),
       ('ROLE_GUEST');

insert into users (username, password, email)
values ('admin', '$2a$12$lHRYfWz9V0YNefV0iH/2he7bbljUqw9uDgbDIIlzheNvgTbcnPSaK', 'admin@mail.com'),
       ('user', '$2a$12$Y8YFr5L3jmQRK7qjnbuTfOrTraiwHlbO3BFAvgpn0X816hDloCE.2', 'user@mail.com'),
       ('guest', '$2a$12$/IIkzoPiFpBI4IZmOX5a3ey4wuU1t.nSHo/Ix9NLsksNmP8J7CvQy', 'guest@mail.com');

insert into users_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

insert into privileges (name)
values ('read'),
       ('write'),
       ('update'),
       ('delete');

insert into privileges_for_roles (role_id, privilege_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 2),
       (3, 1);

