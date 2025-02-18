package by.ivan101454.autoparts.controller;

import by.ivan101454.autoparts.client.BadRequestException;
import by.ivan101454.autoparts.client.PartsRestClient;
import by.ivan101454.autoparts.dto.PartDto;
import by.ivan101454.autoparts.enums.Country;
import by.ivan101454.autoparts.enums.Direction;
import by.ivan101454.autoparts.enums.Side;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/parts")
public class PartsController {

    private final PartsRestClient partService;

    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("countries", Country.values());
        model.addAttribute("directions", Direction.values());
        model.addAttribute("sides", Side.values());
    }

    @GetMapping("list")
    public String getPartsList(Model model) {
        model.addAttribute("parts", partService.findAllParts());
        return "catalogue/parts/list";
    }

    @GetMapping("create")
    public String getNewPartPage(Model model) {
        return "catalogue/parts/new_part";
    }

    @PostMapping("create")
    public String createPart(@Valid PartDto partDto, Model model) {
        try {
            PartDto part = partService.createPart(partDto);
            return "redirect:/catalogue/parts/%d".formatted(part.article());
        } catch (BadRequestException exception) {
            model.addAttribute("partDto", partDto);
            model.addAttribute("errors", exception.getErrors());
            return "catalogue/parts/new_part";
        }
    }
}
