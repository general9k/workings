package ru.ksanxxx.abitur.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.SpecialityControllerApi;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SpecialityController implements SpecialityControllerApi {
    @Override
    public String getSpecialities(Model model) {
        return "/api/v1/specialities";
    }
}
