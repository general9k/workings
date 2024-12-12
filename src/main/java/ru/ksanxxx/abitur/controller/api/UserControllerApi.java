package ru.ksanxxx.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;

@Controller
public interface UserControllerApi {
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
            value = "/index",
            method = RequestMethod.GET
    )
    String redirectToStartPage();
}
