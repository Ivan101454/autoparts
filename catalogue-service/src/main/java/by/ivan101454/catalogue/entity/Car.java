package by.ivan101454.catalogue.entity;

import by.ivan101454.catalogue.enums.Colour;
import by.ivan101454.catalogue.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private UUID id;
    private String carBrand;
    private String carModel;
    private Country country;
    private int numberOfCar;
    private Colour colour;
    private int ageIssue;
//    private List<Part> parts;
}
