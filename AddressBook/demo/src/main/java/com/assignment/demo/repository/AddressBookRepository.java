package com.assignment.demo.repository;

import com.assignment.demo.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
    List<AddressBook> findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    List<AddressBook> findByPhoneNumber(String phoneNumber);
    List<AddressBook> findByFirstNameAndLastName(String firstName, String lastName);

    List<AddressBook> findByFirstName(String firstName);
    List<AddressBook> findByFirstNameAndPhoneNumber(String firstName, String phoneNumber);
}
