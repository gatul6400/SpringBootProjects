package com.task.service1.configuration;

import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class
Service2Config {

    private String baseUrl = "http://localhost:9092";

    private String getServiceStatus = "/v1/microservice2";
}
