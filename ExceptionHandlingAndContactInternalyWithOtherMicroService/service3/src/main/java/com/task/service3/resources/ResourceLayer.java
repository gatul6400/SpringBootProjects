package com.task.service3.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.task.service3.domain.ServiceRequest;
import com.task.service3.service.ServiceLayer;

@RestController
@RequestMapping("v1/microservice3")
public class ResourceLayer {

    @Autowired
    ServiceLayer service;

    @GetMapping
    public String getServiceStatus() {
        return service.serviceCheckUp();
    }

    @PostMapping(value = "/{str}")
    public String createCustomString(@PathVariable("str") String value, @RequestBody final ServiceRequest request) {
        return service.createCombinedString(value, request);
    }
}
