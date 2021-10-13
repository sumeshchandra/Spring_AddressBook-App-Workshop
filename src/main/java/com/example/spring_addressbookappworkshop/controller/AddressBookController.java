package com.example.spring_addressbookappworkshop.controller;

import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import com.example.spring_addressbookappworkshop.dto.ResponseDTO;
import com.example.spring_addressbookappworkshop.model.AddressBookData;
import com.example.spring_addressbookappworkshop.service.AddressBookService;
import com.example.spring_addressbookappworkshop.service.IAddressBookService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

@RestController
@RequestMapping("/addressBookService")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    /**
     * @return ResponseEntity for getting data
     */

    @RequestMapping({"/get", "/"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookData = null;
        addressBookData = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Success Call", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * @return ResponseEntity for getting Id
     */
    @GetMapping("/get/{Id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("Id") int Id) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get successful for id : ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**
     * @return ResponseEntity for getting data
     */
    @PostMapping("/createPost")
    public ResponseEntity<ResponseDTO> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.createAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created new contact ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**
     * @return ResponseEntity for getting updated data
     */
    @PutMapping("/updatePut/{ID}")
    public ResponseEntity<ResponseDTO> updateData(@PathVariable(value = "ID") int ID, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.updateData(ID,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Data successful : ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    /**
     * @return ResponseEntity for deleting data
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteDataById(@PathVariable("personId") int personId) {
        addressBookService.deleteDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + personId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
