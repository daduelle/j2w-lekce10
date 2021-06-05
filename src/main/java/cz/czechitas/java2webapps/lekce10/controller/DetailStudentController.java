package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DetailStudentController {

    private final SkolaService skolaService;

    @Autowired
    public DetailStudentController(SkolaService skolaService) {
        this.skolaService = skolaService;
    }

    @GetMapping("/student/{id}")
    public ModelAndView detailStudent(@PathVariable Integer id) {
        return new ModelAndView("detailStudent")
                .addObject("vybranyStudent", skolaService.jedenStudent(id).get())
                .addObject("rodic", skolaService.rodiceStudenta(id));
    }
}
