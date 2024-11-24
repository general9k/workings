package ru.rodionov.abitur.service;


import ru.rodionov.abitur.model.request.CreateClientRequest;

public interface AuthService {

    void save(CreateClientRequest createClientRequest);
}
