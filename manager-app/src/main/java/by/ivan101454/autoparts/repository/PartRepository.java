package by.ivan101454.autoparts.repository;

import by.ivan101454.autoparts.entity.Part;

import java.util.List;

public interface PartRepository {
    List<Part> findAll();
}
