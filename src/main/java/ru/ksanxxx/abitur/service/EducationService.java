package ru.ksanxxx.abitur.service;

import ru.ksanxxx.abitur.model.Education;

import java.util.List;

public interface EducationService {

    List<Education> getAllEducations();

    Education getEducationById(Integer id);

    void delete(Integer id);

    void save(Education education);
}
