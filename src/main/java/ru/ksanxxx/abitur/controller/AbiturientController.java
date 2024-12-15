package ru.ksanxxx.abitur.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.AbiturientControllerApi;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.model.request.CreateAbiturientRequest;
import ru.ksanxxx.abitur.service.facade.AbiturientFacade;
import ru.ksanxxx.abitur.service.facade.AchievementFacade;
import ru.ksanxxx.abitur.service.facade.AddressFacade;
import ru.ksanxxx.abitur.service.facade.CategoryFacade;
import ru.ksanxxx.abitur.service.facade.EducationFacade;
import ru.ksanxxx.abitur.service.facade.SpecialtyFacade;
import ru.ksanxxx.abitur.service.facade.UserFacade;

import java.time.ZoneOffset;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AbiturientController implements AbiturientControllerApi {

    private final UserFacade userFacade;

    private final AbiturientFacade abiturientFacade;

    private final EducationFacade educationFacade;

    private final SpecialtyFacade specialtyFacade;

    private final AchievementFacade achievementFacade;

    private final CategoryFacade categoryFacade;

    private final AddressFacade addressFacade;

    @Override
    public String getAbiturients(Model model, String categoryName, String[] achievements, String sort) {
        List<Abiturient> abiturients = abiturientFacade.getAbiturients(categoryName, achievements, sort);

        model.addAttribute("abiturients", abiturients);
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());
        model.addAttribute("currentCategory", categoryName);
        model.addAttribute("currentSort", sort);
        return "api/v1/abiturients";
    }

    @Override // GET
    public String createAbiturient(Model model) {
        model.addAttribute("educations", educationFacade.getAll());
        model.addAttribute("specialties", specialtyFacade.getAll());
        model.addAttribute("achievements", achievementFacade.getAll());
        model.addAttribute("categories", categoryFacade.getAll());

        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        return "/api/v1/abiturients/create";
    }

    @Override // POST
    public String createAbiturient(Model model, CreateAbiturientRequest request) {

        Abiturient abiturient = Abiturient.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .patronymic(request.getPatronymic())
                .dateOfBirth(request.getDateOfBirth().atStartOfDay(ZoneOffset.UTC).toOffsetDateTime())
                .dateOfEnd(request.getDateOfEnd().atStartOfDay(ZoneOffset.UTC).toOffsetDateTime())
                .phoneNumber(request.getPhoneNumber())
                .education(educationFacade.getById(request.getEducation()))
                .address(addressFacade.saveAddress(request.getAddress()))
                .achievement(achievementFacade.getById(request.getAchievement()))
                .speciality(specialtyFacade.getById(request.getSpecialty()))
                .category(categoryFacade.getById(request.getCategory()))
                .build();

        abiturientFacade.saveAbiturient(abiturient);

        return "redirect:/api/v1/abiturients";
    }

    @Override
    public String getAbiturient(Integer id, Model model) {
        Abiturient abiturient = userFacade.getAbiturient(id);
        model.addAttribute("abiturient", abiturient);
        return "abiturient";
    }

    @Override
    public String createAbiturient(Abiturient abiturient) {
        userFacade.saveAbiturient(abiturient);
        return "redirect:/abiturients";
    }

    @Override
    public String deleteAbiturient(Integer id) {
        userFacade.deleteAbiturient(id);
        return "redirect:/abiturients";
    }
}
