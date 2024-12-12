package ru.ksanxxx.abitur.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import ru.ksanxxx.abitur.controller.api.UserControllerApi;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;
import ru.ksanxxx.abitur.service.facade.UserFacade;


@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController implements UserControllerApi {

    private final UserFacade facade;

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
        facade.saveUser(createClientRequest);
        return "redirect:/login";
    }

    @Override
    public String redirectToStartPage() {
        return "redirect:/api/v1/index";
    }

}
