package com.task.service3.service;

import com.task.service3.domain.ServiceRequest;

public interface ServiceLayer {

    String serviceCheckUp();

    String createCombinedString(final String str, final ServiceRequest request);
}
