package by.ivan101454.autoparts.dto;

import by.ivan101454.autoparts.enums.Direction;
import by.ivan101454.autoparts.enums.Side;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PartDto(
        @NotEmpty(message = "{catalogue.create.create.errors.title_name_is_invalid}")
        String name,
        @NotNull(message = "{catalogue.create.create.errors.price_is_invalid}")
        BigDecimal price,
        @NotBlank(message = "{catalogue.create.create.errors.title_code_car_is_invalid}")
        String codeCarCountry,
        @NotEmpty(message = "{catalogue.create.create.errors.title_number_car_is_invalid}")
        String numberCar,
        @Min(value = 100000, message = "{catalogue.create.create.errors.title_size_is_invalid}")
        @Max(value = 999999, message = "{catalogue.create.create.errors.title_size_is_invalid}")
        int article,
        @NotNull(message = "{catalogue.create.create.errors.direct_part_invalid}")
        Direction direction,
        @NotNull(message = "{catalogue.create.create.errors.side_part_is_invalid}")
        Side side) {
}
