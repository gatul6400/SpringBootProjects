package com.assignment.demo.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRequest {
    private String firstName = "Atul";
    private String lastName = "Gupta";
    private String address = "Indore";
    private String phoneNumber = "+917697687362";
}
