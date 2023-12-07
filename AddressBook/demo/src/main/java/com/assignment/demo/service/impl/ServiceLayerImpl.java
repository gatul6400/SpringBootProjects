package com.assignment.demo.service.impl;

import com.assignment.demo.domain.response.SearchResponse;
import com.assignment.demo.model.AddressBook;
import com.assignment.demo.domain.request.CreateRequest;
import com.assignment.demo.repository.AddressBookRepository;
import com.assignment.demo.service.ServiceLayer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLayerImpl implements ServiceLayer {

    @Autowired
    private AddressBookRepository repository;

    private ObjectMapper objectMapper;
    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public void createData(CreateRequest request) {
        repository.save(getAddressBookDummy(request.getFirstName(), request.getLastName(), request.getAddress(), request.getPhoneNumber()));
    }

    @Override
    public void createDummyData() {
        for(int i = 0; i < 10; i++) {
            String str = String.valueOf(i);
            repository.save(getAddressBookDummy("dummy", str, "indore", "769768736"+str));
        }
    }

    @Override
    public List<SearchResponse> searchRecord(final String name, final String pNumber) {
        List<AddressBook> response = new ArrayList<>();
        String fName = "";
        String lName = "";
        if (Strings.isNotBlank(name)) {
            List<String> arr = List.of(name.split(" "));
            fName = arr.get(0);
            lName = arr.size() > 1 ? arr.get(1) : "";
        }

        if (Strings.isNotBlank(fName) && Strings.isNotBlank(lName) && Strings.isNotBlank(pNumber)) {
            response = repository.findByFirstNameAndLastNameAndPhoneNumber(fName, lName, pNumber);
        } else if (Strings.isNotBlank(fName) && Strings.isNotBlank(lName)) {
            response = repository.findByFirstNameAndLastName(fName, lName);
        } else if (Strings.isNotBlank(fName) && Strings.isNotBlank(pNumber)){
            response = repository.findByFirstNameAndPhoneNumber(fName, pNumber);
        } else if (Strings.isNotBlank(fName)) {
            response = repository.findByFirstName(fName);
        } else if (Strings.isNotBlank(pNumber)) {
            response = repository.findByPhoneNumber(pNumber);
        } else {
            response = repository.findAll();
        }
        return response.stream().map(res -> new SearchResponse(res.getFirstName(), res.getLastName(), res.getAddress(), res.getPhoneNumber())).collect(Collectors.toList());
    }

    @Override
    public List<SearchResponse> fetchAllRecord() {
        return null;
    }

    private AddressBook getAddressBookDummy(final String firstName, final String lastName, final String address, final String pNum) {
        final AddressBook book = new AddressBook();
        book.setFirstName(firstName);
        book.setLastName(lastName);
        book.setAddress(address);
        book.setPhoneNumber(pNum);
        return book;
    }
}
