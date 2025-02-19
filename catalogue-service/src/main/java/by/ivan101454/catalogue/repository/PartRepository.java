package by.ivan101454.catalogue.repository;

import by.ivan101454.catalogue.entity.Part;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PartRepository extends CrudRepository<Part, UUID> {

    Optional<Part> findByArticle(int partArticle);

}
