package com.task.service1.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.task.service1.domain.Service3Request;
import com.task.service1.service.ServiceLayer;

@RestController
@RequestMapping("v1/microservice1")
public class ResourceLayer {

    @Autowired
    ServiceLayer service;

    @GetMapping
    public String getServiceStatus() {
        return service.checkServiceStatus();
    }

    @PostMapping
    public String getServiceStatus(@RequestBody final Service3Request request) {
        return service.createCombinedString(request);
    }
}
