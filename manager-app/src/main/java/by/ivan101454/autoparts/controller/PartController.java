package by.ivan101454.autoparts.controller;

import by.ivan101454.autoparts.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalog/parts")
public class PartController {

    private final PartService partService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getPartsList(Model model) {
        model.addAttribute("parts", partService.findAllParts());
        return "catalogue/parts/list";
    }
}
