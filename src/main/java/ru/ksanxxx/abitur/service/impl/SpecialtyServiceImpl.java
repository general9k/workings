package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Specialty;
import ru.ksanxxx.abitur.repository.SpecialtyRepository;
import ru.ksanxxx.abitur.service.SpecialtyService;
import ru.ksanxxx.abitur.util.exception.ServerLogicException;
import ru.ksanxxx.abitur.util.exception.ServerLogicExceptionType;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class SpecialtyServiceImpl implements SpecialtyService {

    private SpecialtyRepository specialtyRepository;

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getById(Integer id) {
        return specialtyRepository.findById(id)
                .orElseThrow(() -> new ServerLogicException("Специальность с данным id не найдена", ServerLogicExceptionType.NOT_FOUND));
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Integer id) {
        specialtyRepository.deleteById(id);
    }
}
