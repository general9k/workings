package ru.ksanxxx.abitur.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateSpecialityRequest {

    private String name;

    private List<Integer> subjects;
}
