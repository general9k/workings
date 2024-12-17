package ru.ksanxxx.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;

@Controller
public interface UserControllerApi {
    @RequestMapping(
            value = "/login",
            method = RequestMethod.GET)
    String getLogin(@RequestParam(required = false) Boolean error);

    @RequestMapping(
            value = "/registration",
            method = RequestMethod.GET)
    String getRegistration();

    @RequestMapping(
            value = "/registration",
            method = RequestMethod.POST
    )
    String registration(CreateClientRequest createClientRequest);

    @RequestMapping(
            value = "/api/v1/index",
            method = RequestMethod.GET
    )
    String startPage(Model model);

    @RequestMapping(
            value = "/api/v1/users",
            method = RequestMethod.GET
    )
    String getUsers(Model model);

}
