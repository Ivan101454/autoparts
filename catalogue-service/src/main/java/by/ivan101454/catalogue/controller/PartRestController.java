package by.ivan101454.catalogue.controller;

import by.ivan101454.catalogue.dto.PartDto;
import by.ivan101454.catalogue.service.PartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/parts/{partArticle:\\d+}")
public class PartRestController {

    private final PartService partService;

    private final MessageSource messageSource;

    @ModelAttribute("part")
    private PartDto getProduct(@PathVariable("partArticle") int partArticle) {
        return partService.findPart(partArticle).orElseThrow(() -> new NoSuchElementException("catalogue.errors.product.not_found"));
    }

    @GetMapping
    public PartDto findPart(@ModelAttribute("part") PartDto partDto) {
        return partDto;
    }

    @PatchMapping
    private ResponseEntity<Void> updatePart(@Valid @RequestBody PartDto partDto,
                                            BindingResult bindingResult, Locale locale) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            partService.updatePart(partDto);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePart(@ModelAttribute("part") PartDto part) {
        partService.delete(part.article());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ProblemDetail> handleNoSuchElementException(NoSuchElementException exception, Locale locale) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, messageSource.getMessage(exception.getMessage(), new Object[0],
                exception.getMessage(), locale)));
    }

}
