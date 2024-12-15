package ru.ksanxxx.abitur.service.facade;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Subject;
import ru.ksanxxx.abitur.service.SubjectService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SubjectFacade {

    private final SubjectService subjectService;

    public List<Subject> getAll() {
        return subjectService.findAll();
    }

    public List<Subject> getSubjectsByListInteger(List<Integer> indexes){
        return subjectService.findByListIndex(indexes);
    }
}
