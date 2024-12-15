package ru.ksanxxx.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/v1")
public interface SpecialityControllerApi {

    @RequestMapping(
            value = "/specialities",
            method = RequestMethod.GET
    )
    String getSpecialities(Model model);
}
