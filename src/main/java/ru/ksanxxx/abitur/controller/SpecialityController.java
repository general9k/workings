package ru.ksanxxx.abitur.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.SpecialityControllerApi;
import ru.ksanxxx.abitur.model.Specialty;
import ru.ksanxxx.abitur.model.Subject;
import ru.ksanxxx.abitur.model.request.CreateSpecialityRequest;
import ru.ksanxxx.abitur.service.facade.SpecialtyFacade;
import ru.ksanxxx.abitur.service.facade.SubjectFacade;
import ru.ksanxxx.abitur.service.facade.UserFacade;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SpecialityController implements SpecialityControllerApi {

    private final UserFacade userFacade;

    private final SpecialtyFacade specialtyFacade;

    private final SubjectFacade subjectFacade;

    @Override
    public String getSpecialities(Model model) {
        List<Specialty> specialties = specialtyFacade.getAll();

        model.addAttribute("specialties", specialties);
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());

        return "/api/v1/specialities";
    }

    @Override
    public String createSpeciality(Model model) {

        model.addAttribute("subjects", subjectFacade.getAll());
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());
        return "/api/v1/specialities/create";
    }

    @Override
    public String createSpeciality(Model model, CreateSpecialityRequest request) {

        List<Subject> subjects = subjectFacade.getSubjectsByListInteger(request.getSubjects());

        specialtyFacade.save(request.getName(), subjects);

        return "redirect:/api/v1/specialities";
    }

    @Override
    public String deleteSpeciality(Model model, Integer id) {
        specialtyFacade.delete(id);
        return "redirect:/api/v1/specialities";
    }
}
