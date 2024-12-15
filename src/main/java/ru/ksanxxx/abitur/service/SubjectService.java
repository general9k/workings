package ru.ksanxxx.abitur.service;

import ru.ksanxxx.abitur.model.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> findAll();

    List<Subject> findByListIndex(List<Integer> indexes);
}
