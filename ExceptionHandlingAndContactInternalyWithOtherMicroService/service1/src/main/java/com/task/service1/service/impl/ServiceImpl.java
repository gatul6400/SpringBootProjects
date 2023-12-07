package com.task.service1.service.impl;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.task.service1.domain.Service3Request;
import com.task.service1.service.ServiceLayer;
import com.task.service1.service.http.Service2GatewayService;
import com.task.service1.service.http.Service3GatewayService;
import com.task.service1.utils.exception.BaseException;
import io.micrometer.common.util.StringUtils;

@Service
public class ServiceImpl implements ServiceLayer {

    @Autowired
    private final Service2GatewayService service2GatewayService;

    @Autowired
    private final Service3GatewayService service3GatewayService;

    public ServiceImpl(final Service2GatewayService service2GatewayService, final Service3GatewayService service3GatewayService) {
        this.service2GatewayService = service2GatewayService;
        this.service3GatewayService = service3GatewayService;
    }

    @Override
    public String checkServiceStatus() {
        ResponseEntity<?> response = service2GatewayService.getServiceStatus();
        if (Objects.isNull(response.getBody())) {
            throw new BaseException("empty response from service 2", HttpStatus.BAD_REQUEST.getReasonPhrase());
        }

        ResponseEntity<?> result = service3GatewayService.getServiceStatus();
        if (Objects.isNull(result.getBody())) {
            throw new BaseException("empty response from service 3", HttpStatus.BAD_REQUEST.getReasonPhrase());
        }

        return "Service Up - All service are running";
    }

    @Override
    public String createCombinedString(final Service3Request request) {
        if (StringUtils.isEmpty(request.getName()) || StringUtils.isEmpty(request.getSurname())){
            throw new BaseException("Error cannot process the JSON", HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        ResponseEntity<?> response = service2GatewayService.getServiceStatus();
        if (Objects.isNull(response.getBody())) {
            throw new BaseException("empty response from service 2", HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        ResponseEntity<?> result = service3GatewayService.getCombinedString(response.getBody().toString(), request);
        if (Objects.isNull(result.getBody())) {
            throw new BaseException("empty response from service 3", HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return result.getBody().toString();
    }
}
