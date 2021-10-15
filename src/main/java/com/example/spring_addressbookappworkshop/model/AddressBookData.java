package com.example.spring_addressbookappworkshop.model;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "address_book")
public class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressbook_id")
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private double phoneNumber;

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.AddressBookData(addressBookDTO);
    }

    public void AddressBookData(AddressBookDTO addressBookDTO) {
        this.id = id = addressBookDTO.getId();
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
    }


}
