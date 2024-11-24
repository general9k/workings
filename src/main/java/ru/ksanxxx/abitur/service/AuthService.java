package ru.ksanxxx.abitur.service;


import ru.ksanxxx.abitur.model.request.CreateClientRequest;

public interface AuthService {

    void save(CreateClientRequest createClientRequest);
}
