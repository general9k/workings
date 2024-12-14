package ru.ksanxxx.abitur.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.AbiturientControllerApi;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.service.facade.AbiturientFacade;
import ru.ksanxxx.abitur.service.facade.UserFacade;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AbiturientController implements AbiturientControllerApi {

    private final UserFacade userFacade;
    private final AbiturientFacade abiturientFacade;

    @Override
    public String getAbiturients(Model model, String categoryName, String[] achievements, String sort, String direction) {
        List<Abiturient> abiturients = abiturientFacade.getAbiturients(categoryName, achievements, sort, direction);
        model.addAttribute("abiturients", abiturients);
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("currentCategory", categoryName);
        model.addAttribute("currentSort", sort);
        model.addAttribute("currentDirection", direction);
        return "api/v1/abiturients";
    }

    @Override
    public String getAbiturient(Integer id, Model model) {
        Abiturient abiturient = userFacade.getAbiturient(id);
        model.addAttribute("abiturient", abiturient);
        return "abiturient";
    }

    @Override
    public String createAbiturient(Abiturient abiturient) {
        userFacade.saveAbiturient(abiturient);
        return "redirect:/abiturients";
    }

    @Override
    public String deleteAbiturient(Integer id) {
        userFacade.deleteAbiturient(id);
        return "redirect:/abiturients";
    }
}
