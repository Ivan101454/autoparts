package by.ivan101454.autoparts.client;

import by.ivan101454.autoparts.dto.PartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
public class RestClientPartsRestClient implements PartsRestClient {

    private final static ParameterizedTypeReference<List<PartDto>> PARTS_TYPE_REFERENCE =
            new ParameterizedTypeReference<>() {
            };

    private final RestClient restClient;

    @Override
    public List<PartDto> findAllParts() {
        return restClient
                .get()
                .uri("/catalogue-api/parts")
                .retrieve()
                .body(PARTS_TYPE_REFERENCE);
    }

    @Override
    public PartDto createPart(PartDto newPart) {
        try {
            return restClient
                    .post()
                    .uri("/catalogue-api/parts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(newPart)
                    .retrieve()
                    .body(PartDto.class);
        } catch (HttpClientErrorException.BadRequest exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }

    }

    @Override
    public Optional<PartDto> findPart(int partArticle) {
        try {
            return Optional.of(restClient.get()
                    .uri("/catalogue-api/parts/{partArticle}", partArticle)
                    .retrieve()
                    .body(PartDto.class));
        } catch (HttpClientErrorException.NotFound exception) {
            return Optional.empty();
        }

    }

    @Override
    public void updatePart(PartDto updatePart) {
        try {
            restClient
                    .patch()
                    .uri("/catalogue-api/parts/{partArticle}", updatePart.article())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(updatePart)
                    .retrieve()
                    .toBodilessEntity();
        } catch (HttpClientErrorException.BadRequest exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public void deletePart(int partArticle) {
        try {
            Optional.of(restClient.delete()
                    .uri("/catalogue-api/parts/{partArticle}", partArticle)
                    .retrieve()
                    .toBodilessEntity());
        } catch (HttpClientErrorException.NotFound exception) {
            throw new NoSuchElementException();
        }

    }
}
