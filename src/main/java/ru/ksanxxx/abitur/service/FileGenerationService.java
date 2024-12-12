package ru.ksanxxx.abitur.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public abstract class FileGenerationService<T> {

    // Метод-шаблон
    public File generateFile(List<T> data, String filePath) {
        validateData(data);
        String content = generateContent(data);
        return writeToFile(content, filePath);
    }

    // Валидация данных
    protected void validateData(List<T> data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data for file generation cannot be null or empty.");
        }
    }

    // Генерация контента файла (реализуется в подклассах)
    protected abstract String generateContent(List<T> data);

    // Запись данных в файл
    private File writeToFile(String content, String filePath) {
        try {
            File file = new File(filePath);
            try (var writer = new java.io.FileWriter(file)) {
                writer.write(content);
            }
            return file;
        } catch (Exception e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}

