package ru.ksanxxx.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/v1")
public interface ListControllerApi {

    @RequestMapping(
            value = "/lists",
            method = RequestMethod.GET
    )
    String getList(Model model, @RequestParam(required = false) String spec);
}
