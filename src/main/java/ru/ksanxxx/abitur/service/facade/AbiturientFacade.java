package ru.ksanxxx.abitur.service.facade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.service.AbiturientService;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AbiturientFacade {

    private final AbiturientService abiturientService;

    public List<Abiturient> getAbiturients(String categoryName, String[] achievements, String sort) {

        List<Abiturient> result = abiturientService.getAllAbiturients();

        if (categoryName != null) {
            result = result.stream()
                    .filter(abiturient -> abiturient.getCategory().getName().equalsIgnoreCase(categoryName))
                    .toList();
        }

        if (achievements != null && achievements.length > 0) {
            List<String> achievementsList = Arrays.asList(achievements);
            result = result.stream()
                    .filter(abiturient -> achievementsList.stream()
                            .anyMatch(achievement ->
                                    abiturient.getAchievement().getName().equalsIgnoreCase(achievement))).toList();
        }

        if (sort != null) {
            result = result.stream()
                    .sorted((o1, o2) -> switch (sort) {
                        case "lastName" -> o1.getLastName().compareToIgnoreCase(o2.getLastName());
                        case "firstName" -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
                        case "birthDate" -> o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                        default -> 0;
                    })
                    .toList();
        }

        return result;
    }

    public Abiturient saveAbiturient(Abiturient abiturient) {
        return abiturientService.save(abiturient);
    }

}
