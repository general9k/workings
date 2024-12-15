package ru.ksanxxx.abitur.service.facade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Category;
import ru.ksanxxx.abitur.service.CategoryService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryFacade {

    private CategoryService categoryService;

    public List<Category> getAll() {
        return categoryService.findAll();
    }

    public Category getById(Integer id) {
        return categoryService.findById(id);
    }
}
