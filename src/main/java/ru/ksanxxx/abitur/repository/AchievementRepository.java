package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Integer> {
}
