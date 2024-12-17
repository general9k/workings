package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ksanxxx.abitur.model.Education;
import ru.ksanxxx.abitur.repository.EducationRepository;
import ru.ksanxxx.abitur.service.EducationService;
import ru.ksanxxx.abitur.util.exception.ServerLogicException;
import ru.ksanxxx.abitur.util.exception.ServerLogicExceptionType;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Education getEducationById(Integer id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new ServerLogicException("Учебное заведение не найдено", ServerLogicExceptionType.NOT_FOUND));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        educationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Education education) {
        educationRepository.save(education);
    }
}
