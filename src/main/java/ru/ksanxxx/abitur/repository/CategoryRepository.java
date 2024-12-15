package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
