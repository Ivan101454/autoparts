package by.ivan101454.autoparts.entity;

import by.ivan101454.autoparts.enums.Direction;
import by.ivan101454.autoparts.enums.Side;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record Part(
        String name,
        BigDecimal price,
        String codeCarCountry,
        String numberCar,
        int article,
        Direction direction,
        Side side) {
}