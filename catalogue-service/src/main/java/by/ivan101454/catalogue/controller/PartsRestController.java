package by.ivan101454.catalogue.controller;

import by.ivan101454.catalogue.dto.PartDto;
import by.ivan101454.catalogue.service.PartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/parts")
public class PartsRestController {

    private final PartService partService;

    private final MessageSource messageSource;

    @GetMapping()
    public List<PartDto> findParts(@RequestParam(required = false) String filter) {
        return partService.findAllParts(filter);
    }

    @PostMapping()
    public ResponseEntity<?> createPart(@Valid @RequestBody PartDto partDto,
                                              BindingResult bindingResult,
                                              UriComponentsBuilder uriComponentsBuilder) throws BindException {
        if (bindingResult.hasErrors()) {
           if (bindingResult instanceof BindException exception) {
               throw exception;
           } else {
               throw new BindException(bindingResult);
           }
        } else {
            PartDto part = partService.createPart(partDto);
            return ResponseEntity
                    .created(uriComponentsBuilder
                            .replacePath("/catalogue-api/parts/{partArticle}")
                    .build(Map.of("partArticle", partDto.article())))
                    .body(part);
        }
    }
}
