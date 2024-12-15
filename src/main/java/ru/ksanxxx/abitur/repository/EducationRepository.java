package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {
}
