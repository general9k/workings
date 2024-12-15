package ru.ksanxxx.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ksanxxx.abitur.model.request.CreateSpecialityRequest;

@Controller
@RequestMapping("/api/v1")
public interface SpecialityControllerApi {

    @RequestMapping(
            value = "/specialities",
            method = RequestMethod.GET
    )
    String getSpecialities(Model model);

    @RequestMapping(
            value = "/specialities/create",
            method = RequestMethod.GET
    )
    String createSpeciality(Model model);

    @RequestMapping(
            value = "/specialities/create",
            method = RequestMethod.POST
    )
    String createSpeciality(Model model, CreateSpecialityRequest request);

    @RequestMapping(
            value = "/specialities",
            method = RequestMethod.DELETE
    )
    String deleteSpeciality(Model model, Integer id);
}
