package by.ivan101454.catalogue.entity;

import by.ivan101454.catalogue.enums.Direction;
import by.ivan101454.catalogue.enums.Side;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "part", schema = "catalogue")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "car")
    @ManyToOne
    @JoinColumn(name = "id")
    private Car car;
    @Column(name = "article")
    private int article;
    @Column(name = "direction")
    private Direction direction;
    @Column(name = "side")
    private Side side;
}
