package ru.ksanxxx.abitur.model.request;


import lombok.Getter;
import lombok.Setter;
import ru.ksanxxx.abitur.model.Address;

import java.time.LocalDate;

@Getter
@Setter
public class CreateAbiturientRequest {

    private String lastName;

    private String firstName;

    private String patronymic;

    private LocalDate dateOfBirth;

    private Integer education;

    private LocalDate dateOfEnd;

    private Address address;

    private Integer specialty;

    private Integer achievement;

    private Integer category;

    private String phoneNumber;

}
