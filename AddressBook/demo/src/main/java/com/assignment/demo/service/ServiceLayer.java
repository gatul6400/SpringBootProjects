package com.assignment.demo.service;

import com.assignment.demo.domain.request.CreateRequest;
import com.assignment.demo.domain.response.SearchResponse;

import java.util.List;

public interface ServiceLayer {

    void createData(final CreateRequest request);

    void createDummyData();

    List<SearchResponse> searchRecord(final String name, final String pNumber);
}
