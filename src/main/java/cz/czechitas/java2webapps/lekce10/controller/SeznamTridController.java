package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeznamTridController {
    private final SkolaService skolaService;

    @Autowired
    public SeznamTridController(SkolaService skolaService) {
        this.skolaService = skolaService;
    }

    @GetMapping("/")
    public ModelAndView seznamTrid(@PageableDefault(sort = {"nazev"}) Pageable pageable) {
        return new ModelAndView("seznamTrid")
                .addObject("trida", skolaService.findAll());
    }
}
