package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
    public List<Abiturient> getAllAbiturients() {
        return abiturientRepository.findAll();
    }

    @Override
    public Abiturient getAbiturientById(Integer id) {
        return abiturientRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Abiturient abiturient) {
        abiturientRepository.save(abiturient);
    }

    @Override
    public void delete(Abiturient abiturient) {
        abiturientRepository.delete(abiturient);
    }
}
