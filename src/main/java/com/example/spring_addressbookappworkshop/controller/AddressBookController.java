package com.example.spring_addressbookappworkshop.controller;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

@RestController
@RequestMapping("/addressBookService")
public class AddressBookController {


    /**
     * @return ResponseEntity for getting data
     */
    @RequestMapping({"/get", "/"})
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<>("Retrieve all dat from addressBook : ", HttpStatus.OK);
    }

    /**
     * @return ResponseEntity for getting Id
     */
    @GetMapping("/get/{Id}")
    public ResponseEntity<String> getAddressBookDataById(@PathVariable("Id") int Id) {
        return new ResponseEntity<>("Get successful for id : " + Id, HttpStatus.OK);
    }

    /**
     * @return ResponseEntity for getting data
     */
    @PostMapping("/createPost")
    public ResponseEntity<String> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>("Created new contact " + addressBookDTO, HttpStatus.OK);
    }

    /**
     * @return ResponseEntity for getting updated data
     */
    @PutMapping("/updatePut")
    public ResponseEntity<String> updateData(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>("Updated Data successful :" + addressBookDTO, HttpStatus.OK);
    }

    /**
     * @return ResponseEntity for deleting data
     */
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> deleteDataById(@PathVariable("Id") int Id) {
        return new ResponseEntity<>("deleted data for Id :" + Id, HttpStatus.OK);
    }

}
