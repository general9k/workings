package ru.rodionov.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rodionov.abitur.mapper.AuthUserMapper;
import ru.rodionov.abitur.model.AuthUser;
import ru.rodionov.abitur.model.request.CreateClientRequest;
import ru.rodionov.abitur.repository.AuthUserRepository;
import ru.rodionov.abitur.service.AuthService;


@Service
@AllArgsConstructor
@Slf4j
public class AuthUserServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;

    private final AuthUserRepository authUserRepository;

    private final AuthUserMapper authUserMapper;

    @Transactional
    public void save(CreateClientRequest createClientRequest) {
        AuthUser authUser = authUserMapper.mapToAuthUser(createClientRequest);
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));

        authUserRepository.save(authUser);
    }
}
