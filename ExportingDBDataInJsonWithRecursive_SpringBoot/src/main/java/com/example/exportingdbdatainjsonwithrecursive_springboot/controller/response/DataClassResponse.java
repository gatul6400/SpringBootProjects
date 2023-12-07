package com.example.exportingdbdatainjsonwithrecursive_springboot.controller.response;

import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
public class DataClassResponse {

    String name;

    List<DataClassResponse> subClasses = new ArrayList<>();
}
