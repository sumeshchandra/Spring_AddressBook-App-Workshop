package com.example.spring_addressbookappworkshop.dto;

import lombok.Data;

/**
 *
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 *
 */

@Data
public class AddressBookDTO {

    public String firstName;
    public String lastName;
    private String city;
    private String state;
    public double phoneNumber;

    public AddressBookDTO(String firstName, String lastName, String city, String state, double phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }
}
