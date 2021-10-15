package com.example.spring_addressbookappworkshop.repository;

import com.example.spring_addressbookappworkshop.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
