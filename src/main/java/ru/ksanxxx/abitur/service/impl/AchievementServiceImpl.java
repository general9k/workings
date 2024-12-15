package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Achievement;
import ru.ksanxxx.abitur.repository.AchievementRepository;
import ru.ksanxxx.abitur.service.AchievementService;
import ru.ksanxxx.abitur.util.exception.ServerLogicException;
import ru.ksanxxx.abitur.util.exception.ServerLogicExceptionType;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;

    @Override
    public List<Achievement> findAll() {
        return achievementRepository.findAll();
    }

    @Override
    public Achievement findById(Integer id) {
        return achievementRepository.findById(id)
                .orElseThrow(() -> new ServerLogicException("Достижения с таким id не найдено", ServerLogicExceptionType.NOT_FOUND));
    }
}
