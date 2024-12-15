package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.repository.AbiturientRepository;
import ru.ksanxxx.abitur.service.AbiturientService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AbiturientServiceIml implements AbiturientService {

    private final AbiturientRepository abiturientRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Abiturient> getAllAbiturients() {
        return abiturientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Abiturient getAbiturientById(Integer id) {
        return abiturientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Abiturient save(Abiturient abiturient) {
        return abiturientRepository.save(abiturient);
    }

    @Override
    @Transactional
    public void delete(Abiturient abiturient) {
        abiturientRepository.delete(abiturient);
    }
}
