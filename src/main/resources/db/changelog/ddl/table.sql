--liquibase formatted sql

--changeset fokusmod:create_tables
create table categories
(
    id    serial primary key,
    title text not null
);


create table products
(
    id          serial primary key,
    title       text    not null,
    price       integer not null,
    category_id integer references categories (id)
);

