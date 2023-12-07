package com.task.service3.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.task.service3.domain.ServiceRequest;
import com.task.service3.service.ServiceLayer;
import com.task.service3.utils.exception.BaseException;
import io.micrometer.common.util.StringUtils;

@Service
public class ServiceImpl implements ServiceLayer {

    @Override
    public String serviceCheckUp() {
        return "service up";
    }

    @Override
    public String createCombinedString(final String str, final ServiceRequest request) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(request.getName()) || StringUtils.isEmpty(request.getSurname())) {
            throw new BaseException("Error cannot process the JSON - request is empty or null", new Exception(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return str + " " + request.getName() + " " + request.getSurname();
    }
}
