package ru.ksanxxx.abitur.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.ksanxxx.abitur.model.AuthUser;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthUserMapper {

    AuthUser mapToAuthUser(CreateClientRequest createClientRequest);

}
