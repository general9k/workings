package ru.ksanxxx.abitur.service.impl;

import org.springframework.stereotype.Component;
import ru.ksanxxx.abitur.service.FileGenerationService;

import java.util.List;

@Component
public class XmlFileGenerationService<T> extends FileGenerationService<T> {

    @Override
    protected String generateContent(List<T> data) {
        StringBuilder xml = new StringBuilder();
        xml.append("<items>\n");
        for (T item : data) {
            xml.append("  <item>").append(item.toString()).append("</item>\n");
        }
        xml.append("</items>");
        return xml.toString();
    }
}
