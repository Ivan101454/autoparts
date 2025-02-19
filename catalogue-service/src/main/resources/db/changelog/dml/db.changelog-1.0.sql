--liquidbase formatted sql
--changeset ivan101454:1
INSERT INTO catalogue.car(car_brand, car_model, country, number_of_car, colour, age_issue) VALUES
('Audi', 'A6C6', 'ENGLAND', 'T4152', 'SILVER', 2005),
('VW', 'PASSAT B5', 'GERMANY', '64153', 'BLACK', 2002),
('BMW', 'E60', 'AUSTRALIA', 'A4154', 'BLUE', 2006);
--changeset ivan101454:2
INSERT INTO catalogue.part(name, price, article, car, direction, side) VALUES
('Wing', 50, 903456, (SELECT id from catalogue.car where number_of_car = 'T4152'), 'FRONT', 'LINKS'),
('Hood', 100, 987654, (SELECT id from catalogue.car where number_of_car = '64153'), 'NONE', 'NONE'),
('Headlight', 40, 978123, (SELECT id from catalogue.car where number_of_car = 'A4154'), 'FRONT', 'RIGHTS');