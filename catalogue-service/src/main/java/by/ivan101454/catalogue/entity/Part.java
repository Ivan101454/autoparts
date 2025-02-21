package by.ivan101454.catalogue.entity;

import by.ivan101454.catalogue.enums.Direction;
import by.ivan101454.catalogue.enums.Side;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "part", schema = "catalogue")
@NamedNativeQueries(
        @NamedNativeQuery(name = "Part.byName", query = "select * from catalogue.part p where p.name ilike ?", resultClass = Part.class)
)
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID partId;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "article")
    private int article;
    @Column(name = "direction")
    @Enumerated(EnumType.STRING)
    private Direction direction;
    @Enumerated(EnumType.STRING)
    @Column(name = "side")
    private Side side;
}
