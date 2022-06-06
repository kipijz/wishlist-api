-- liquibase formatted sql

-- changeset kristaps:1

CREATE TABLE wish
(
    id      serial primary key,
    wish    varchar(255) not null
)