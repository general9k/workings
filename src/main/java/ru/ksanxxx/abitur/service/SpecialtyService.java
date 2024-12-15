package ru.ksanxxx.abitur.service;

import ru.ksanxxx.abitur.model.Specialty;

import java.util.List;

public interface SpecialtyService {

    List<Specialty> getAllSpecialties();

    Specialty getById(Integer id);
}
