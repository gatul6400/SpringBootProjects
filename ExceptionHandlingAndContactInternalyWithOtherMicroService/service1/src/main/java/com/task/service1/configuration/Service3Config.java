package com.task.service1.configuration;

import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class Service3Config {

    private String baseUrl = "http://localhost:9093";

    private String getServiceCheck = "/v1/microservice3";

    private String createCombinedString = "/v1/microservice3/{str}";
}
