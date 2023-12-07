package com.example.exportingdbdatainjsonwithrecursive_springboot.controller;

import com.example.exportingdbdatainjsonwithrecursive_springboot.controller.response.DataClassResponse;
import com.example.exportingdbdatainjsonwithrecursive_springboot.model.Data;
import com.example.exportingdbdatainjsonwithrecursive_springboot.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DataController {


    @Autowired
    DataService dataService;

    @PostMapping("/data")
    public ResponseEntity<String> generateData(){
        dataService.saveData(createDataObject(1L, "test1", "green"));
        dataService.saveData(createDataObject(1L, "test2", "yellow"));
        dataService.saveData(createDataObject(2L, "test3", "blue"));
        return new ResponseEntity<>("Data created in the DB", HttpStatus.CREATED);
    }

    private Data createDataObject(long parentId, String name, String color) {
        final Data data = new Data();
        data.setParentId(parentId);
        data.setName(name);
        data.setColor(color);
        return data;
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<DataClassResponse> getObjectById(@PathVariable Long id) {
//        return dataService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
        return null;
    }

    @GetMapping("/data")
    public ResponseEntity<List<DataClassResponse>> getAllObjects() {
        List<DataClassResponse> nestedData = dataService.findAllData();
        return ResponseEntity.ok(nestedData);
    }
}
