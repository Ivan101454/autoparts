package by.ivan101454.autoparts.repository;

import by.ivan101454.autoparts.entity.AutopartsUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AutopartsUserRepository extends CrudRepository<AutopartsUser, UUID> {

    Optional<AutopartsUser> findByUsername(String username);
}
