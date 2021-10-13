package com.example.spring_addressbookappworkshop.service;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import com.example.spring_addressbookappworkshop.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(int personId);

    AddressBookData createAddressBook(AddressBookDTO addressBookDTO);

    AddressBookData updateData(int personId, AddressBookDTO addressBookDTO);

    void deleteDataById(int personId);

}
