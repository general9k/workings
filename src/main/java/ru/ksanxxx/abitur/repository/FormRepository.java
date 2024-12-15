package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.Form;

public interface FormRepository extends JpaRepository<Form, Integer> {
}
