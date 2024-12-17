package ru.ksanxxx.abitur.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.EducationApi;
import ru.ksanxxx.abitur.service.facade.EducationFacade;
import ru.ksanxxx.abitur.service.facade.UserFacade;

@Slf4j
@Controller
@RequiredArgsConstructor
public class EducationController implements EducationApi {

    private final UserFacade userFacade;

    private final EducationFacade educationFacade;

    @Override
    public String getEducations(Model model) {

        model.addAttribute("educations", educationFacade.getAll());
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());
        model.addAttribute("isEditor", userFacade.isEditor());

        return "api/v1/educations";
    }
}
