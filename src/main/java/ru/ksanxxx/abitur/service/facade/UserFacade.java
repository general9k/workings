package ru.ksanxxx.abitur.service.facade;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;
import ru.ksanxxx.abitur.service.AbiturientService;
import ru.ksanxxx.abitur.service.AuthService;
import ru.ksanxxx.abitur.service.impl.CsvFileGenerationService;
import ru.ksanxxx.abitur.service.impl.XmlFileGenerationService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserFacade {

    private final AuthService authService;
    private final AbiturientService abiturientService;
    private final CsvFileGenerationService<Abiturient> csvFileGenerationService;
    private final XmlFileGenerationService<Abiturient> xmlFileGenerationService;

    @Transactional(readOnly = true)
    public List<Abiturient> getAbiturients() {
        return abiturientService.getAllAbiturients();
    }

    @Transactional
    public void saveUser(CreateClientRequest createClientRequest) {
        authService.save(createClientRequest);
    }

    @Transactional(readOnly = true)
    public Abiturient getAbiturient(Integer id) {
        return abiturientService.getAbiturientById(id);
    }

    @Transactional
    public void saveAbiturient(Abiturient abiturient) {
        abiturientService.save(abiturient);
    }

    @Transactional
    public void deleteAbiturient(Integer id) {
        Abiturient abiturient = abiturientService.getAbiturientById(id);
        abiturientService.delete(abiturient);
    }

    @Transactional(readOnly = true)
    public void generateCsvFileAbiturients() {
        csvFileGenerationService.generateFile(abiturientService.getAllAbiturients(), "output.csv");
    }

    @Transactional(readOnly = true)
    public void generateXmlFileAbiturients() {
        xmlFileGenerationService.generateFile(abiturientService.getAllAbiturients(), "output.csv");
    }
}
