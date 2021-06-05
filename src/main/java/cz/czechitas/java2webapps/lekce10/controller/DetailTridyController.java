package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailTridyController {

    private final SkolaService skolaService;

    @Autowired
    public DetailTridyController(SkolaService skolaService) {
        this.skolaService = skolaService;
    }

    @GetMapping("/trida/{nazev}")
    public ModelAndView detailTridy(@PathVariable String nazev, @PageableDefault(sort = {"prijmeni", "jmeno"}) Pageable pageble) {
        return new ModelAndView("detailTridy")
                .addObject("trida", skolaService.jednaTrida(nazev))
                .addObject("student",skolaService.vyhledejStudentyTridy(nazev, pageble))
                .addObject("ucitel",skolaService.ucitelTridy(nazev));
    }
}
