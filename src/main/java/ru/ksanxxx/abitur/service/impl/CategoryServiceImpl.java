package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Category;
import ru.ksanxxx.abitur.repository.CategoryRepository;
import ru.ksanxxx.abitur.service.CategoryService;
import ru.ksanxxx.abitur.util.exception.ServerLogicException;
import ru.ksanxxx.abitur.util.exception.ServerLogicExceptionType;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ServerLogicException("Категория с данным id не найдена", ServerLogicExceptionType.NOT_FOUND));
    }
}
