package ru.rodionov.abitur.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Convert;
import ru.rodionov.abitur.util.RoleConverter;

@Convert(converter = RoleConverter.class)
public enum RoleEnum {
    OPERATOR("operator"), // Оператор
    ADMIN("admin"); // Администратор системы

    RoleEnum(String code) {
        this.code = code;
    }

    private final String code;

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static RoleEnum fromValue(String code) {
        for (RoleEnum roleCode : RoleEnum.values()) {
            if (roleCode.getCode().equalsIgnoreCase(code)) {
                return roleCode;
            }
        }
        throw new IllegalArgumentException("No enum constant for code: " + code);
    }
}
