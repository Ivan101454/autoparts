package by.ivan101454.catalogue.entity;

import by.ivan101454.catalogue.enums.Direction;
import by.ivan101454.catalogue.enums.Side;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Part {

    private UUID id;
    private String name;
    private BigDecimal price;
    private Car car;
    private int article;
    private Direction direction;
    private Side side;
}
