package by.ivan101454.catalogue.service;

import by.ivan101454.catalogue.dto.PartDto;
import by.ivan101454.catalogue.entity.Part;

import java.util.List;
import java.util.Optional;

public interface PartService {

    List<PartDto> findAllParts();

    PartDto createPart(PartDto partDto);

    Optional<PartDto> findPart(int partArticle);

    void updatePart(PartDto partDto);

    void delete(int article);

    List<PartDto> findAllParts(String filter);
}
