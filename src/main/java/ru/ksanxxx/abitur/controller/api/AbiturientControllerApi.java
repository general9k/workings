package ru.ksanxxx.abitur.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ksanxxx.abitur.model.Abiturient;

@Controller
public interface AbiturientControllerApi {

    @RequestMapping(
            value = "/api/v1/abiturients",
            method = RequestMethod.GET)
    String getAbiturients(Model model);

    @RequestMapping(
            value = "/api/v1/abiturients/{id}",
            method = RequestMethod.GET)
    String getAbiturient(@PathVariable Integer id, Model model);

    @RequestMapping(
            value = "/api/v1/abiturients",
            method = RequestMethod.POST)
    String createAbiturient(@RequestBody Abiturient abiturient);

    @RequestMapping(
            value = "/api/v1/abiturients/{id}",
            method = RequestMethod.DELETE)
    String deleteAbiturient(@PathVariable Integer id);

    @RequestMapping(
            value = "/api/v1/abiturients/xml",
            method = RequestMethod.GET)
    void createXML();

    @RequestMapping(
            value = "/api/v1/abiturients/csv",
            method = RequestMethod.GET)
    void createCSV();
}
