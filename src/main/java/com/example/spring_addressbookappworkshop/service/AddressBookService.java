package com.example.spring_addressbookappworkshop.service;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import com.example.spring_addressbookappworkshop.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private List<AddressBookData> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
       return addressBookList.get(personId -1);
    }

    @Override
    public AddressBookData createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData;
        addressBookData = new AddressBookData(addressBookList.size() + 1, addressBookDTO);
        addressBookList.add(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookData.setFirstName(addressBookDTO.firstName);
        addressBookData.setFirstName(addressBookDTO.lastName);;
        addressBookList.set(personId - 1, addressBookData);
        return addressBookData;
    }

    @Override
    public void deleteDataById(int personId) {
            addressBookList.remove(personId - 1);
        }

    }