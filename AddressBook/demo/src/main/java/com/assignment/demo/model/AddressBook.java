package com.assignment.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "address_book", indexes = {@Index(name = "first_name_index", columnList = "firstName, lastName"), @Index(name = "phone_number_index", columnList = "phoneNumber")})
@Embeddable
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
