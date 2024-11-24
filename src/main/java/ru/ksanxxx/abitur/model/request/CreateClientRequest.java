package ru.ksanxxx.abitur.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientRequest {

    private String username;

    private String password;

    private String role;

    private String lastName;

    private String firstName;

    private String patronymic;

    public CreateClientRequest(String username, String password, String role, String lastName, String firstName) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
