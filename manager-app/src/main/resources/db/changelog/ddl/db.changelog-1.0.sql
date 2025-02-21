--liquidbase formatted sql
--changeset ivan101454:1
CREATE SCHEMA IF NOT EXISTS user_management;
--changeset ivan101454:2
DROP EXTENSION IF EXISTS "uuid-ossp";
--changeset ivan101454:3
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
--changeset ivan101454:4
CREATE TABLE IF NOT EXISTS user_management.user
(
    user_id  uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    username VARCHAR NOT NULL CHECK (username <> '' AND length(trim(username)) > 0) UNIQUE,
    password VARCHAR NOT NULL CHECK (password <> ''),
    role     VARCHAR NOT NULL CHECK (role <> '')
);
--changeset ivan101454:5
CREATE TABLE IF NOT EXISTS user_management.authority
(
    authority_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    authority    VARCHAR NOT NULL CHECK (authority <> '' AND length(trim(authority)) > 0)
);
--changeset ivan101454:6
CREATE TABLE IF NOT EXISTS user_management.user_authority
(
    cross_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    authority_id uuid NOT NULL REFERENCES user_management.user(user_id),
    user_id uuid NOT NULL REFERENCES user_management.authority(authority_id),
    CONSTRAINT uk_user_authority UNIQUE (authority_id, user_id)
)