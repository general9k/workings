package ru.ksanxxx.abitur.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.EducationApi;
import ru.ksanxxx.abitur.model.Education;
import ru.ksanxxx.abitur.service.facade.EducationFacade;
import ru.ksanxxx.abitur.service.facade.UserFacade;
import ru.ksanxxx.abitur.util.exception.ServerLogicException;
import ru.ksanxxx.abitur.util.exception.ServerLogicExceptionType;

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

    @Override
    public String deleteEducation(Model model, Integer id) {
        try {
            educationFacade.delete(id);

        } catch (Exception e) {
            throw new ServerLogicException("Невозможно удалить учебное заведение. На него имеется связь", ServerLogicExceptionType.DELETE_ERROR);
        }
        return "redirect:/api/v1/educations";
    }

    @Override
    public String createEducation(Model model) {

        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());
        model.addAttribute("isEditor", userFacade.isEditor());

        return "/api/v1/educations/create";
    }

    @Override
    public String createEducation(Education education) {
        educationFacade.create(education);
        return "redirect:/api/v1/educations";
    }
}
