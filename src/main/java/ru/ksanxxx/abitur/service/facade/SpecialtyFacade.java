package ru.ksanxxx.abitur.service.facade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Specialty;
import ru.ksanxxx.abitur.service.SpecialtyService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SpecialtyFacade {

    private final SpecialtyService specialtyService;

    public List<Specialty> getAll() {
        return specialtyService.getAllSpecialties();
    }

    public Specialty getById(Integer id) {
        return specialtyService.getById(id);
    }
}
