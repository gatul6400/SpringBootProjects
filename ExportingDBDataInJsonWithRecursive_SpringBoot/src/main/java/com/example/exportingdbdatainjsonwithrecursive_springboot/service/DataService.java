package com.example.exportingdbdatainjsonwithrecursive_springboot.service;

import com.example.exportingdbdatainjsonwithrecursive_springboot.controller.response.DataClassResponse;
import com.example.exportingdbdatainjsonwithrecursive_springboot.model.Data;

import java.util.List;

public interface DataService {
    void saveData(Data data);

    List<DataClassResponse> findAllData();
}
