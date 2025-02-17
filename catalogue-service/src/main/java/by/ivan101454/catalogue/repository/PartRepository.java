package by.ivan101454.catalogue.repository;

import by.ivan101454.catalogue.entity.Part;

import java.util.List;
import java.util.Optional;

public interface PartRepository {
    List<Part> findAll();

    Part save(Part part);

    Optional<Part> findByArticle(int partArticle);

    void delete(int article);
}
