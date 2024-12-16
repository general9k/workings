package ru.ksanxxx.abitur.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.ListControllerApi;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.model.Specialty;
import ru.ksanxxx.abitur.service.facade.AbiturientFacade;
import ru.ksanxxx.abitur.service.facade.SpecialtyFacade;
import ru.ksanxxx.abitur.service.facade.UserFacade;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ListController implements ListControllerApi {

    private final AbiturientFacade abiturientFacade;
    private final SpecialtyFacade specialtyFacade;
    private final UserFacade userFacade;

    @Override
    public String getList(Model model, String spec) {
        List<Abiturient> abiturients = abiturientFacade.getAbiturients(spec);
        List<Specialty> specialties = specialtyFacade.getAll();

        model.addAttribute("abiturients", abiturients);
        model.addAttribute("specialities", specialties);
        model.addAttribute("currentSpeciality", spec);
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());

        return "/api/v1/lists";
    }
}
