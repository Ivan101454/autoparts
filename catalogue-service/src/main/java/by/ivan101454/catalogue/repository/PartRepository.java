package by.ivan101454.catalogue.repository;

import by.ivan101454.catalogue.entity.Part;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartRepository extends CrudRepository<Part, UUID> {
    List<Part> findAll();

    Part save(Part part);

    Optional<Part> findByArticle(int partArticle);

    void delete(int article);
}
