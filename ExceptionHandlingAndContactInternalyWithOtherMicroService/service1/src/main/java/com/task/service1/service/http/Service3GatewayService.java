package com.task.service1.service.http;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.task.service1.configuration.Service3Config;
import com.task.service1.domain.Service3Request;
import com.task.service1.utils.exception.BaseException;
import com.task.service1.utils.exception.GeneralException;
import com.task.service1.utils.http.HttpClient;

@Service
public class Service3GatewayService {

    private final HttpClient httpClient;

    private final Service3Config configuration;

    public Service3GatewayService(final HttpClient httpClient, final Service3Config configuration) {
        this.httpClient = httpClient;
        this.configuration = configuration;
    }

    public ResponseEntity<String> getServiceStatus() {
        try {
            return httpClient.getRestTemplate().exchange(configuration.getBaseUrl() + configuration.getGetServiceCheck(), HttpMethod.GET, httpClient.getEntity(), String.class);
        } catch (BaseException e) {
            throw new BaseException("Error response from service 3", HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception ex) {
            throw new GeneralException("Failed to contact service 3", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }

    public ResponseEntity<String> getCombinedString(final String str, final Service3Request request) {
        try {
            return httpClient.getRestTemplate().postForEntity(configuration.getBaseUrl() + configuration.getCreateCombinedString().replace("{str}", str), request, String.class);
        } catch (BaseException e) {
            throw new BaseException("Error response from service 3", HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception ex) {
            throw new GeneralException("Failed to contact service 3", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }
}
