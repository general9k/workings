package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.Abiturient;

public interface AbiturientRepository extends JpaRepository<Abiturient, Integer> {
}
