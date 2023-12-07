package com.task.service1.service.http;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.task.service1.configuration.Service2Config;
import com.task.service1.utils.exception.BaseException;
import com.task.service1.utils.exception.GeneralException;
import com.task.service1.utils.http.HttpClient;

@Service
public class Service2GatewayService {

    private final HttpClient httpClient;

    private final Service2Config configuration;

    public Service2GatewayService(final HttpClient httpClient, final Service2Config configuration) {
        this.httpClient = httpClient;
        this.configuration = configuration;
    }

    public ResponseEntity<String> getServiceStatus() {
        try {
            return httpClient.getRestTemplate().exchange(configuration.getBaseUrl() + configuration.getGetServiceStatus(), HttpMethod.GET, httpClient.getEntity(), String.class);
        } catch (BaseException e) {
            throw new BaseException("Error response from service 2", HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception ex) {
            throw new GeneralException("Failed to contact service 2", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }
}
