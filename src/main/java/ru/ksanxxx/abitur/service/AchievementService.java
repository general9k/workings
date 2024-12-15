package ru.ksanxxx.abitur.service;

import ru.ksanxxx.abitur.model.Achievement;

import java.util.List;

public interface AchievementService {

    List<Achievement> findAll();

    Achievement findById(Integer id);
}
