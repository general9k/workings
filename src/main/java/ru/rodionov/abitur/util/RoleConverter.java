package ru.rodionov.abitur.util;


import ru.rodionov.abitur.model.enums.RoleEnum;
import ru.rodionov.abitur.util.interfaceEnum.UniversalEnumConverter;

public class RoleConverter extends UniversalEnumConverter<RoleEnum> {
    public RoleConverter() {
        super(RoleEnum.class);
    }
}
