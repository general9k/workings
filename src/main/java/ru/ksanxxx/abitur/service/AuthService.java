package ru.ksanxxx.abitur.service;


import ru.ksanxxx.abitur.model.AuthUser;
import ru.ksanxxx.abitur.model.request.CreateClientRequest;

import java.util.List;

public interface AuthService {

    void save(CreateClientRequest createClientRequest);

    List<AuthUser> getUsers();

    void deleteUser(Integer id);
}
