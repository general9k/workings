package ru.ksanxxx.abitur.service.facade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ksanxxx.abitur.model.Specialty;
import ru.ksanxxx.abitur.model.Subject;
import ru.ksanxxx.abitur.service.SpecialtyService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SpecialtyFacade {

    private final SpecialtyService specialtyService;

    @Transactional(readOnly = true)
    public List<Specialty> getAll() {
        return specialtyService.getAllSpecialties();
    }

    @Transactional(readOnly = true)
    public Specialty getById(Integer id) {
        return specialtyService.getById(id);
    }

    @Transactional
    public Specialty save(String name, List<Subject> subjects) {
        return specialtyService.save(Specialty.builder()
                .name(name)
                .subjects(subjects)
                .build());
    }

    @Transactional
    public void delete(Integer id) {
        specialtyService.delete(id);
    }
}
