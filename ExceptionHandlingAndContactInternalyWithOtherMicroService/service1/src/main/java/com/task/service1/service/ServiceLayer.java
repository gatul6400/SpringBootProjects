package com.task.service1.service;

import com.task.service1.domain.Service3Request;

public interface ServiceLayer {

    String checkServiceStatus();

    String createCombinedString(final Service3Request request);
}
