package com.example.spring_addressbookappworkshop.model;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

@Data
@Getter
@Setter
public class AddressBookData {

    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private double phoneNumber;


    public AddressBookData(int id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
    }


}
