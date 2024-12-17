package ru.ksanxxx.abitur.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.UserControllerApi;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;
import ru.ksanxxx.abitur.service.facade.UserFacade;
import ru.ksanxxx.abitur.util.exception.ServerLogicException;
import ru.ksanxxx.abitur.util.exception.ServerLogicExceptionType;


@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController implements UserControllerApi {

    private final UserFacade userFacade;

    @Override
    public String redirectOnIndex() {
        return "redirect:/api/v1/index";
    }

    @Override
    public String getLogin(Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            return "errors/error";
        }
        return "login";
    }

    @Override
    public String getRegistration(Model model) {
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        return "registration";
    }

    @Override
    @Transactional
    public String registration(CreateClientRequest createClientRequest) {
        userFacade.saveUser(createClientRequest);
        return "redirect:/login";
    }

    @Override
    public String startPage(Model model) {
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());
        return "api/v1/index";
    }

    @Override
    public String getUsers(Model model) {
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());
        model.addAttribute("users", userFacade.getUsers());
        model.addAttribute("authId", userFacade.getCurrentUserId());
        return "/api/v1/users";
    }

    @Override
    public String deleteUser(Integer id) {
        Integer currentUserId = userFacade.getCurrentUserId();

        if (currentUserId.equals(id)) {
            throw new ServerLogicException("Нельзя удалить самого себя", ServerLogicExceptionType.CONFLICT);
        }

        userFacade.deleteUser(id);
        return "redirect:/api/v1/users";
    }
}
