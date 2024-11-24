package ru.ksanxxx.abitur.util;


import ru.ksanxxx.abitur.model.enums.RoleEnum;
import ru.ksanxxx.abitur.util.interfaceEnum.UniversalEnumConverter;

public class RoleConverter extends UniversalEnumConverter<RoleEnum> {
    public RoleConverter() {
        super(RoleEnum.class);
    }
}
