package ru.ksanxxx.abitur.service;

import ru.ksanxxx.abitur.model.Abiturient;

import java.util.List;

public interface AbiturientService {

    List<Abiturient> getAllAbiturients();

    Abiturient getAbiturientById(Integer id);

    Abiturient save(Abiturient abiturient);

    void delete(Abiturient id);
}
