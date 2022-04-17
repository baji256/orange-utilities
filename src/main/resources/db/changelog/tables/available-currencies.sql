--liquibase formatted sql

--changeset liquibase-utilities:orange256
CREATE TABLE available_currencies
(
    currency_code        int PRIMARY KEY,
    currency_name        varchar(3),
    currency_description varchar(50)
);

ALTER TABLE available_currencies
    ADD CONSTRAINT currency_code_constraint UNIQUE (currency_code);