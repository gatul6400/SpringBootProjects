package com.task.service2.service.impl;

import com.task.service2.service.ServiceLayer;

@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceLayer {

    @Override
    public String validateService() {
        return "Hello";
    }
}
