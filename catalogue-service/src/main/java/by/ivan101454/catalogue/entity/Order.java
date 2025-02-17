package by.ivan101454.catalogue.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Order {

    private UUID id;
    private int number;
    private List<Part> orderParts;
    private BigDecimal sumOrder;
}
