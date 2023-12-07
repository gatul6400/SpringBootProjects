package com.task.service1.utils.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.Getter;

@Getter
@Service
public class HttpClient {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
}
