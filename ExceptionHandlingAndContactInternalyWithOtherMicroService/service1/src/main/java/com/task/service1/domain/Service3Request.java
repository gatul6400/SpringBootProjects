package com.task.service1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties (ignoreUnknown = true)
public class Service3Request {
    private String name;

    private String surname;
}
