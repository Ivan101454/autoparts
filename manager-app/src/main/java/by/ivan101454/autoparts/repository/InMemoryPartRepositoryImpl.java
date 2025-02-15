package by.ivan101454.autoparts.repository;

import by.ivan101454.autoparts.entity.Car;
import by.ivan101454.autoparts.entity.Part;
import by.ivan101454.autoparts.enums.Colour;
import by.ivan101454.autoparts.enums.Country;
import by.ivan101454.autoparts.enums.Direction;
import by.ivan101454.autoparts.enums.Side;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Repository
public class InMemoryPartRepositoryImpl implements PartRepository {

    private final List<Part> parts = Collections.synchronizedList(new LinkedList<>());

    public InMemoryPartRepositoryImpl() {
        parts.add(new Part(UUID.randomUUID(), "Wing", new BigDecimal(50),
                new Car(UUID.randomUUID(), "Audi", "A6C6", Country.ENGLAND, 4152, Colour.SILVER, 2005),
                903456, Direction.FRONT, Side.LINKS));
        parts.add(new Part(UUID.randomUUID(), "Hood", new BigDecimal(100),
                new Car(UUID.randomUUID(), "VW", "PASSAT B5", Country.GERMANY, 4153, Colour.BLACK, 2002),
                987654, Direction.NONE, Side.NONE));
        parts.add(new Part(UUID.randomUUID(), "Headlight", new BigDecimal(40),
                new Car(UUID.randomUUID(), "BMW", "E60", Country.ENGLAND, 4154, Colour.BLUE, 2006),
                978123, Direction.FRONT, Side.RIGHTS));
    }

    @Override
    public List<Part> findAll() {
        return Collections.unmodifiableList(parts);
    }
}
