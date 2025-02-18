package by.ivan101454.autoparts.controller;

import by.ivan101454.autoparts.client.BadRequestException;
import by.ivan101454.autoparts.client.PartsRestClient;
import by.ivan101454.autoparts.dto.PartDto;
import by.ivan101454.autoparts.enums.Country;
import by.ivan101454.autoparts.enums.Direction;
import by.ivan101454.autoparts.enums.Side;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/parts/{partArticle:\\d+}")
public class PartController {

    private final PartsRestClient partService;
    private final MessageSource messageSource;

    @ModelAttribute("part")
    public PartDto part(@PathVariable("partArticle") int partArticle, Model model) {
        model.addAttribute("countries", Country.values());
        model.addAttribute("directions", Direction.values());
        model.addAttribute("sides", Side.values());
        return partService.findPart(partArticle).orElseThrow(() -> new NoSuchElementException("catalogue.errors.product.not_found"));
    }

    @GetMapping()
    public String getPart() {
        return "catalogue/parts/part";
    }

    @GetMapping("edit")
    public String getPartEditPage(Model model) {

        return "catalogue/parts/edit";
    }

    @PostMapping("edit")
    public String updatePart(@Valid @ModelAttribute("partUpdate") PartDto part, Model model) {
        try {
            partService.updatePart(part);
            return "redirect:/catalogue/parts/%d".formatted(part.article());
        } catch (BadRequestException exception) {
            model.addAttribute("partUpdate", part);
            model.addAttribute("errors", exception.getErrors());
            return "catalogue/parts/edit";
        }
    }

    @PostMapping("delete")
    public String delete(@ModelAttribute("part") PartDto part) {
        partService.deletePart(part.article());
        return "redirect:/catalogue/parts/list";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(NoSuchElementException e, Model model, HttpServletResponse response, Locale locale) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        model.addAttribute("error", messageSource.getMessage(e.getMessage(), new Object[]{}, locale));
        return "errors/404";
    }
}
