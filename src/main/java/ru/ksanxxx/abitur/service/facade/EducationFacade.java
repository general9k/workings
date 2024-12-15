package ru.ksanxxx.abitur.service.facade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Education;
import ru.ksanxxx.abitur.service.EducationService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EducationFacade {

    private final EducationService educationService;

    public List<Education> getAll() {
        return educationService.getAllEducations();
    }

    public Education getById(Integer id) {return educationService.getEducationById(id);}
}
