package ru.ksanxxx.abitur.service.impl;

import org.springframework.stereotype.Component;
import ru.ksanxxx.abitur.service.FileGenerationService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvFileGenerationService<T> extends FileGenerationService<T> {

    @Override
    protected String generateContent(List<T> data) {
        return data.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
