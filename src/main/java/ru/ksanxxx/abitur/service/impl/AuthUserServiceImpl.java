package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ksanxxx.abitur.mapper.AuthUserMapper;
import ru.ksanxxx.abitur.model.AuthUser;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;
import ru.ksanxxx.abitur.repository.AuthUserRepository;
import ru.ksanxxx.abitur.service.AuthService;
import ru.ksanxxx.abitur.util.exception.ServerLogicException;
import ru.ksanxxx.abitur.util.exception.ServerLogicExceptionType;

import java.util.List;


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

        try {
            authUserRepository.save(authUser);
        } catch (Exception e) {
            throw new ServerLogicException("Пользователь с таким username уже есть на сайте", ServerLogicExceptionType.VALIDATION_ERROR);
        }
    }

    @Override
    public List<AuthUser> getUsers() {
        return authUserRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        authUserRepository.deleteById(id);
    }
}
