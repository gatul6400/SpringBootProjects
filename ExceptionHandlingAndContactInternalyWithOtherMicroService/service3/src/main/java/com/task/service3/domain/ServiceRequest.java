package com.task.service3.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties (ignoreUnknown = true)
public class ServiceRequest {
    private String name;

    private String surname;
}
