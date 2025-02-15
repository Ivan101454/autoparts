package by.ivan101454.autoparts.controller;

import by.ivan101454.autoparts.dto.PartDto;
import by.ivan101454.autoparts.entity.Part;
import by.ivan101454.autoparts.enums.Country;
import by.ivan101454.autoparts.enums.Direction;
import by.ivan101454.autoparts.enums.Side;
import by.ivan101454.autoparts.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/parts")
public class PartController {

    private final PartService partService;

    @GetMapping("list")
    public String getPartsList(Model model) {
        model.addAttribute("parts", partService.findAllParts());
        return "catalogue/parts/list";
    }

    @GetMapping("create")
    public String getNewPartPage(Model model) {
        model.addAttribute("countries", Country.values());
        model.addAttribute("directions", Direction.values());
        model.addAttribute("sides", Side.values());
        return "catalogue/parts/new_part";
    }

    @PostMapping("create")
    public String createPart(@ModelAttribute PartDto partDto) {
        PartDto part = partService.createPart(partDto);
        return "redirect:/catalogue/parts/list";
    }
}
