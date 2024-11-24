package ru.rodionov.abitur.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.rodionov.abitur.model.AuthUser;
import ru.rodionov.abitur.model.request.CreateClientRequest;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthUserMapper {

    AuthUser mapToAuthUser(CreateClientRequest createClientRequest);

}
