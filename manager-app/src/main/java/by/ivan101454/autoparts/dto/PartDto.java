package by.ivan101454.autoparts.dto;

import by.ivan101454.autoparts.enums.Direction;
import by.ivan101454.autoparts.enums.Side;

import java.math.BigDecimal;

public record PartDto(String name, BigDecimal price, String codeCarCountry, String numberCar, int article, Direction direction, Side side) {
}
