--liquidbase formatted sql
--changeset ivan101454:1
CREATE SCHEMA IF NOT EXISTS catalogue;
--changeset ivan101454:2
DROP EXTENSION IF EXISTS "uuid-ossp";
--changeset ivan101454:3
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
--changeset ivan101454:4
CREATE TABLE IF NOT EXISTS catalogue.car(
car_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
car_brand VARCHAR NOT NULL CHECK (car_brand <> ''),
car_model VARCHAR NOT NULL CHECK (car_model <> ''),
country VARCHAR NOT NULL CHECK (country <> ''),
number_of_car VARCHAR NOT NULL CHECK (number_of_car <> ''),
color VARCHAR NOT NULL CHECK (color <> ''),
age_issue INT NOT NULL CHECK (age_issue > 2000)
);
--changeset ivan101454:5
CREATE TABLE IF NOT EXISTS catalogue.part(
part_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
name VARCHAR NOT NULL CHECK (name <> ''),
price DECIMAL(18, 2) NOT NULL CHECK (price >= 0),
car_id uuid,
article INT NOT NULL CHECK (article BETWEEN 100000 AND 999999),
direction VARCHAR NOT NULL CHECK (direction <> ''),
side VARCHAR NOT NULL CHECK (side <> '')
);
--changeset ivan101454:6
ALTER TABLE IF EXISTS catalogue.part
add foreign key (car_id)
references catalogue.car;