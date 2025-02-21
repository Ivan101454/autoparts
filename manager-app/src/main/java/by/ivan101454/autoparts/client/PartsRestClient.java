package by.ivan101454.autoparts.client;

import by.ivan101454.autoparts.dto.PartDto;

import java.util.List;
import java.util.Optional;

public interface PartsRestClient {

    List<PartDto> findAllParts(String filter);
    PartDto createPart(PartDto newPart);
    Optional<PartDto> findPart(int partArticle);
    void updatePart(PartDto updatePart);
    void deletePart(int partArticle);



}
