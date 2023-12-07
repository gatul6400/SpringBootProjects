package com.assignment.demo.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchResponse {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
}
