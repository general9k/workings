package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
}
