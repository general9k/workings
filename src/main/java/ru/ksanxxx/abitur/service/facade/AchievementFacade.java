package ru.ksanxxx.abitur.service.facade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Achievement;
import ru.ksanxxx.abitur.service.AchievementService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AchievementFacade {

    private final AchievementService achievementService;

    public List<Achievement> getAll() {
        return achievementService.findAll();
    }

    public Achievement getById(Integer id) {
        return achievementService.findById(id);
    }
}
