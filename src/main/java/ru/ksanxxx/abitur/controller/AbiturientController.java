package ru.ksanxxx.abitur.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.AbiturientControllerApi;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.service.facade.UserFacade;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AbiturientController implements AbiturientControllerApi {
    private final UserFacade facade;

    @Override
    public String getAbiturients(Model model) {
        List<Abiturient> abiturients = facade.getAbiturients();
        model.addAttribute("abiturients", abiturients);
        return "abiturients";
    }

    @Override
    public String getAbiturient(Integer id, Model model) {
        Abiturient abiturient = facade.getAbiturient(id);
        model.addAttribute("abiturient", abiturient);
        return "abiturient";
    }

    @Override
    public String createAbiturient(Abiturient abiturient) {
        facade.saveAbiturient(abiturient);
        return "redirect:/abiturients";
    }

    @Override
    public String deleteAbiturient(Integer id) {
        facade.deleteAbiturient(id);
        return "redirect:/abiturients";
    }
}
