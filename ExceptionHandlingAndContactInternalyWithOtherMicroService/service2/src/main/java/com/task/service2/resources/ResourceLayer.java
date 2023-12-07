package com.task.service2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.task.service2.service.ServiceLayer;

@RestController
@RequestMapping("v1/microservice2")
public class ResourceLayer {

    @Autowired
    ServiceLayer service;

    @GetMapping
    public String getServiceStatus() {
        return service.validateService();
    }
}
