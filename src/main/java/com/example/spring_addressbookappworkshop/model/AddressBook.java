package com.example.spring_addressbookappworkshop.model;

import lombok.Data;

/**
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

@Data
public class AddressBook {

    private String firstName;
    private String lastName;
    private double phoneNumber;

    public AddressBook(String firstName, String lastName, double phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
