package ru.ksanxxx.abitur.controller.api;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ksanxxx.abitur.model.Education;

@Controller
@RequestMapping("/api/v1")
public interface EducationApi {

    @RequestMapping(
            value = "educations",
            method = RequestMethod.GET
    )
    String getEducations(Model model);


    @RequestMapping(
            value = "educations",
            method = RequestMethod.DELETE
    )
    String deleteEducation(Model model, @RequestParam Integer id);

    @RequestMapping(
            value = "educations/create",
            method = RequestMethod.GET
    )
    String createEducation(Model model);

    @RequestMapping(
            value = "educations/create",
            method = RequestMethod.POST
    )
    String createEducation(Education education);
}
