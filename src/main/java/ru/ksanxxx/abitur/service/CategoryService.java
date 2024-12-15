package ru.ksanxxx.abitur.service;

import ru.ksanxxx.abitur.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);
}
