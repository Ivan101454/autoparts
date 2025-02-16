package by.ivan101454.autoparts.service;

import by.ivan101454.autoparts.dto.PartDto;
import by.ivan101454.autoparts.entity.Part;

import java.util.List;
import java.util.Optional;

public interface PartService {

    List<PartDto> findAllParts();

    PartDto createPart(PartDto partDto);

    Optional<PartDto> findPart(int partArticle);

    void updatePart(PartDto partDto);

    void delete(int article);
}
