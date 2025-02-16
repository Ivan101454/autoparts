package by.ivan101454.autoparts.repository;

import by.ivan101454.autoparts.entity.Part;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface PartRepository {
    List<Part> findAll();

    Part save(Part part);

    Optional<Part> findByArticle(int partArticle);

    void delete(int article);
}
