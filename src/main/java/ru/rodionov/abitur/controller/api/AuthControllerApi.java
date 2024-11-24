package ru.rodionov.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.rodionov.abitur.model.request.CreateClientRequest;

@Controller
public interface AuthControllerApi {
    @RequestMapping(
            value = "/login",
            method = RequestMethod.GET)
    ModelAndView getLogin();

    @RequestMapping(
            value = "/registration",
            method = RequestMethod.GET)
    ModelAndView getRegistration();

    @RequestMapping(
            value = "/registration",
            method = RequestMethod.POST
    )
    String registration(CreateClientRequest createClientRequest);

    @RequestMapping(
            method = RequestMethod.GET
    )
    String redirectToStartPage();
}
