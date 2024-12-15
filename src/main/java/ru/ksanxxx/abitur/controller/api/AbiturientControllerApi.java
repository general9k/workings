package ru.ksanxxx.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.model.request.CreateAbiturientRequest;

@Controller
@RequestMapping("/api/v1")
public interface AbiturientControllerApi {

    @RequestMapping(
            value = "abiturients",
            method = RequestMethod.GET)
    String getAbiturients(Model model,
                          @RequestParam(required = false) String categoryName,
                          @RequestParam(required = false) Boolean isAchievement,
                          @RequestParam(required = false) String sort);

    @RequestMapping(
            value = "abiturients/{id}",
            method = RequestMethod.GET)
    String getAbiturient(@PathVariable Integer id, Model model);

    @RequestMapping(
            value = "abiturients/create",
            method = RequestMethod.GET
    )
    String createAbiturient(Model model);

    @RequestMapping(
            value = "abiturients/create",
            method = RequestMethod.POST)
    String createAbiturient(Model model, CreateAbiturientRequest request);

    @RequestMapping(
            value = "abiturients",
            method = RequestMethod.POST)
    String createAbiturient(@RequestBody Abiturient abiturient);

    @RequestMapping(
            value = "abiturients/{id}",
            method = RequestMethod.DELETE)
    String deleteAbiturient(@PathVariable Integer id);
}
