package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Subject;
import ru.ksanxxx.abitur.repository.SubjectRepository;
import ru.ksanxxx.abitur.service.SubjectService;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> findByListIndex(List<Integer> indexes) {
        return subjectRepository.findAllByIdIn(indexes);
    }
}
