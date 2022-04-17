--liquibase formatted sql

--changeset liquibase-demo-service:add-user-name-constraint
CREATE TABLE messages(
    key int,
    content varchar(255)
);

ALTER TABLE messages ADD CONSTRAINT message_unique_key UNIQUE (key);