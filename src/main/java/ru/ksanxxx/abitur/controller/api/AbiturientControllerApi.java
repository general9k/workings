package ru.ksanxxx.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ksanxxx.abitur.model.Abiturient;

@Controller
@RequestMapping("/api/v1")
public interface AbiturientControllerApi {

    @RequestMapping(
            value = "abiturients",
            method = RequestMethod.GET)
    String getAbiturients(Model model,
                          @RequestParam(required = false) String categoryName,
                          @RequestParam(required = false) String[] achievements,
                          @RequestParam(required = false) String sort,
                          @RequestParam(required = false) String direction);

    @RequestMapping(
            value = "abiturients/{id}",
            method = RequestMethod.GET)
    String getAbiturient(@PathVariable Integer id, Model model);

    @RequestMapping(
            value = "abiturients",
            method = RequestMethod.POST)
    String createAbiturient(@RequestBody Abiturient abiturient);

    @RequestMapping(
            value = "abiturients/{id}",
            method = RequestMethod.DELETE)
    String deleteAbiturient(@PathVariable Integer id);
}
