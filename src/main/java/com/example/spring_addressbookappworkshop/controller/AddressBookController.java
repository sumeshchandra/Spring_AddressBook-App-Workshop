package com.example.spring_addressbookappworkshop.controller;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import com.example.spring_addressbookappworkshop.dto.ResponseDTO;
import com.example.spring_addressbookappworkshop.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1, new AddressBookDTO("Sumesh", "Jena", "Rourkela", "Odisha", 987654321));
        ResponseDTO responseDTO = new ResponseDTO("Get Success Call", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * @return ResponseEntity for getting Id
     */
    @GetMapping("/get/{Id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("Id") int Id) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(Id, new AddressBookDTO("Sumesh", "Jena", "Rourkela", "Odisha", 987654321));
        ResponseDTO responseDTO = new ResponseDTO("Get successful for id : ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**
     * @return ResponseEntity for getting data
     */
    @PostMapping("/createPost")
    public ResponseEntity<ResponseDTO> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(3, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created new contact ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**
     * @return ResponseEntity for getting updated data
     */
    @PutMapping("/updatePut/{ID}")
    public ResponseEntity<ResponseDTO> updateData(@PathVariable(value = "ID") int ID, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(ID, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Data successful : ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    /**
     * @return ResponseEntity for deleting data
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteDataById(@PathVariable("personId") int personId) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + personId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
