package com.assignment.demo.controller;

import com.assignment.demo.domain.request.CreateRequest;
import com.assignment.demo.domain.response.SearchResponse;
import com.assignment.demo.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/address-book")
public class ControllerLayer {

    @Autowired
    private ServiceLayer serviceLayer;

    @PostMapping("/create")
    public void createData(@RequestBody CreateRequest request) {
        serviceLayer.createData(request);
    }

    @PostMapping("/create/dummy/data")
    public void createDummyData() {
        serviceLayer.createDummyData();
    }

    @GetMapping("/search")
    public List<SearchResponse> searchRecordsFromAddressBook(@RequestParam Map<String, String> reqParams){
        String name = reqParams.getOrDefault("name", "");
        String phoneNumber = reqParams.getOrDefault("phoneNumber", "");
        return serviceLayer.searchRecord(name, phoneNumber);
    }
}
