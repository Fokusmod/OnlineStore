--liquibase formatted sql

--changeset fokusmod:insert_test_product

insert into categories (title) values
('fruit'),
('all');

insert into products (title, price, category_id) values
('banana',100,1),
('apple',90,1),
('beer',100,2);
