--liquidbase formatted sql
--changeset ivan101454:1
INSERT INTO user_management.authority(authority)
VALUES ('SERVICE'),
       ('ADMIN'),
       ('USER');
--changeset ivan101454:2
INSERT INTO user_management.user(username, password, role)
VALUES ('Ivan', '{noop}12345', 'SERVICE'),
       ('Petr', '{noop}98765', 'ADMIN'),
       ('STAS', '{noop}00000', 'USER');