package ru.ksanxxx.abitur.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.UserControllerApi;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;
import ru.ksanxxx.abitur.service.facade.UserFacade;


@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController implements UserControllerApi {

    private final UserFacade facade;

    @Override
    public String getLogin(Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            return "errors/error";
        }
        return "login";
    }

    @Override
    public String getRegistration() {
        return "registration";
    }

    @Override
    @Transactional
    public String registration(CreateClientRequest createClientRequest) {
        facade.saveUser(createClientRequest);
        return "redirect:/login";
    }

    @Override
    public String startPage(Model model) {
        model.addAttribute("isAuthenticated", facade.isAuthenticated());
        model.addAttribute("isAdmin", facade.isAdmin());
        return "api/v1/index";
    }

    @Override
    public String getUsers(Model model) {
        return "";
    }
}
