package com.example.exportingdbdatainjsonwithrecursive_springboot.service.impl;

import com.example.exportingdbdatainjsonwithrecursive_springboot.controller.response.DataClassResponse;
import com.example.exportingdbdatainjsonwithrecursive_springboot.model.Data;
import com.example.exportingdbdatainjsonwithrecursive_springboot.repository.DataRepository;
import com.example.exportingdbdatainjsonwithrecursive_springboot.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataRepository dataRepository;

    @Override
    public void saveData(Data data) {
        dataRepository.save(data);
    }

    @Override
    public List<DataClassResponse> findAllData() {
        List<Data> datas = dataRepository.findAll();
        return getDataInSubClassStructure(datas, null, true);
    }

    private List<DataClassResponse> getDataInSubClassStructure(List<Data> datas, Data subObject, boolean isChecked) {
        List<DataClassResponse> result = new ArrayList<>();
        for (Data data : datas) {
            DataClassResponse temp = new DataClassResponse();
            temp.setName(data.getName());
            if ((!Objects.isNull(subObject)) && (Objects.equals(subObject.getParentId(), data.getId())) && isChecked) {
                temp.setSubClasses(getDataInSubClassStructure(datas, data, false));
//                result.add(temp);
            } else {
                if ((!Objects.equals(data.getId(), data.getParentId())) && isChecked) {
                    temp.setSubClasses(getDataInSubClassStructure(datas, data, true));
//                    result.add(temp);
                }
                if (isChecked){
                    result.add(temp);
                }
            }
        }
        return result;
    }

}
