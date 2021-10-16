package com.example.spring_addressbookappworkshop.service;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import com.example.spring_addressbookappworkshop.model.AddressBookData;

import java.util.List;

/**
 *Class for the business logic for student service
 *
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

public interface IAddressBookService {

    /**
     * Method for getting all the students from database
     *
     * @return list of {@link AddressBookData}
     */

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData createAddressBook(AddressBookDTO addressBookDTO);

    AddressBookData updateData(int personId, AddressBookDTO addressBookDTO);

    AddressBookData deleteDataById(int personId);

}
