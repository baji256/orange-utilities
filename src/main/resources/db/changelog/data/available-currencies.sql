--liquibase formatted sql

--changeset liquibase-utilities:orange256
INSERT INTO available_currencies(currency_code, currency_name, currency_description)
VALUES ('978', 'EUR', 'Евро'),
       ('643', 'RUB', 'Российский рубль'),
       ('980', 'UAH', 'Украинская гривна'),
       ('840', 'USD', 'Американский доллар'),
       ('981', 'GEL', 'Грузинский лари');
