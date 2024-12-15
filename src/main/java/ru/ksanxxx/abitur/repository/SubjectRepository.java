package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
