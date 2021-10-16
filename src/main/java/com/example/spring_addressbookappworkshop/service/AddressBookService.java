package com.example.spring_addressbookappworkshop.service;

import com.example.spring_addressbookappworkshop.constant.Message;
import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import com.example.spring_addressbookappworkshop.exception.AddressBookException;
import com.example.spring_addressbookappworkshop.model.AddressBookData;
import com.example.spring_addressbookappworkshop.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private ModelMapper modelMapper;

    private List<AddressBookData> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookList.stream().filter(list -> list.getId() == personId).findFirst().orElseThrow(()
                -> new AddressBookException(Message.ID_NOT_FOUND.getMessage()));
    }

    @Override
    public AddressBookData createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData;
        addressBookData = new AddressBookData(addressBookDTO);
        addressBookList.add(addressBookData);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = getAddressBookDataById(personId);
        modelMapper.map(addressBookDTO, addressBookData);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData deleteDataById(int Id) {
        return addressBookList.stream().filter(list -> list.getId() == Id).findFirst()
                .orElseThrow(() -> new AddressBookException(Message.ID_NOT_FOUND.getMessage()));
    }

}
