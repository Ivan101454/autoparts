package by.ivan101454.catalogue.repository;

import by.ivan101454.catalogue.entity.Car;
import by.ivan101454.catalogue.entity.Part;
import by.ivan101454.catalogue.enums.Colour;
import by.ivan101454.catalogue.enums.Country;
import by.ivan101454.catalogue.enums.Direction;
import by.ivan101454.catalogue.enums.Side;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryPartRepositoryImpl implements PartRepository {

    private final List<Part> parts = Collections.synchronizedList(new LinkedList<>());
    private final Map<String, Car> cars = Collections.synchronizedMap(new HashMap<>());

    public InMemoryPartRepositoryImpl() {
        cars.put("T4152", new Car(UUID.randomUUID(), "Audi", "A6C6", Country.ENGLAND, 4152, Colour.SILVER, 2005, new ArrayList<>()));
        cars.put("64153", new Car(UUID.randomUUID(), "VW", "PASSAT B5", Country.GERMANY, 4153, Colour.BLACK, 2002, new ArrayList<>()));
        cars.put("A4154", new Car(UUID.randomUUID(), "BMW", "E60", Country.AUSTRALIA, 4154, Colour.BLUE, 2006, new ArrayList<>()));
        parts.add(new Part(UUID.randomUUID(), "Wing", new BigDecimal(50), cars.get("T4152"),
                903456, Direction.FRONT, Side.LINKS));
        parts.add(new Part(UUID.randomUUID(), "Hood", new BigDecimal(100), cars.get("64153"),
                987654, Direction.NONE, Side.NONE));
        parts.add(new Part(UUID.randomUUID(), "Headlight", new BigDecimal(40), cars.get("A4154"),
                978123, Direction.FRONT, Side.RIGHTS));
    }

    @Override
    public List<Part> findAll() {
        return Collections.unmodifiableList(parts);
    }

    @Override
    public Part save(Part part) {
        part.setId(UUID.randomUUID());
        parts.add(part);
//        Integer max = cars.entrySet().stream().filter(x -> x.getValue().getCountry() == part.getCar().getCountry())
//                .max(Comparator.comparingInt(c -> c.getValue().getNumberOfCar())).map(x -> x.getValue().getNumberOfCar()).orElse(0);
        return part;
    }

    @Override
    public Optional<Part> findByArticle(int partArticle) {
        return parts.stream().filter(x -> x.getArticle() == partArticle).findFirst();
    }

    @Override
    public void delete(int article) {
        parts.removeIf(part -> part.getArticle() == article);
    }
}
