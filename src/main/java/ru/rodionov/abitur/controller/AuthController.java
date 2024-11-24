package ru.rodionov.abitur.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import ru.rodionov.abitur.controller.api.AuthControllerApi;
import ru.rodionov.abitur.model.request.CreateClientRequest;
import ru.rodionov.abitur.service.AuthService;


@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController implements AuthControllerApi {

    private final AuthService authService;

    @Override
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }

    @Override
    public ModelAndView getRegistration() {
        return new ModelAndView("registration");
    }

    @Override
    @Transactional
    public String registration(CreateClientRequest createClientRequest) {
        authService.save(createClientRequest);
        return "redirect:/login";
    }

    @Override
    public String redirectToStartPage() {
        return "redirect:/api/v1/index";
    }

}
