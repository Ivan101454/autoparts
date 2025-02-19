package by.ivan101454.catalogue.entity;

import by.ivan101454.catalogue.enums.Colour;
import by.ivan101454.catalogue.enums.Country;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "country")
    private Country country;
    @Column(name = "number_of_")
    private int numberOfCar;
    @Column(name = "color")
    private Colour colour;
    @Column(name = "age_issue")
    private int ageIssue;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Part> parts;

    public void addPart(Part part) {
        part.setCar(this);
        parts.add(part);
    }

    public void deletePart(Part part) {
        parts.remove(part);
    }
}
