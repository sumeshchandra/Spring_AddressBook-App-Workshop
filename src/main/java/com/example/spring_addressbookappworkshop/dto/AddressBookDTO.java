package com.example.spring_addressbookappworkshop.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * AddressBook for Maintaining Objects
 * With DTO
 *
 *
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

@Data
public class AddressBookDTO {

    @Pattern(regexp = "^[1-9]$", message = " ID not Valid")
    public int id;

    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}$", message = "firstName is Invalid")
    @NotEmpty
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}$", message = "lastName is Invalid!!! ")
    @NotEmpty
    public String lastName;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]{4,}$", message = "Provide correct city name")
    private String city;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]{4,}$", message = "Provide correct state name")
    private String state;

    @NotEmpty
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}$", message = "Phone no should be 10 digit")
    public double phoneNumber;

    public AddressBookDTO(int id, String firstName, String lastName, String city, String state, double phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }
}
