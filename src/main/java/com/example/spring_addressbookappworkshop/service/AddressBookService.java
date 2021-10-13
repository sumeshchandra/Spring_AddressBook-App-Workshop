package com.example.spring_addressbookappworkshop.service;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import com.example.spring_addressbookappworkshop.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressBookList = new ArrayList<AddressBookData>();
        addressBookList.add(new AddressBookData(1, new AddressBookDTO("Sumesh", "Jena", "Rourkela", "Odisha", 987654321)));
        return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        AddressBookData addressBookData = new AddressBookData(personId, new AddressBookDTO("Sumesh", "Jena", "Rourkela", "Odisha", 987654321));
        return addressBookData;
    }

    @Override
    public AddressBookData createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(3, addressBookDTO);
        return addressBookData;
    }

    @Override
    public AddressBookData updateData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(3, addressBookDTO);
        return addressBookData;
    }

    @Override
    public void deleteDataById(int personId) {

    }
}
