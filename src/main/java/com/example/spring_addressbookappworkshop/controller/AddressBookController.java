package com.example.spring_addressbookappworkshop.controller;

import com.example.spring_addressbookappworkshop.constant.Message;
import com.example.spring_addressbookappworkshop.dto.AddressBookDTO;
import com.example.spring_addressbookappworkshop.dto.ResponseDTO;
import com.example.spring_addressbookappworkshop.model.AddressBookData;
import com.example.spring_addressbookappworkshop.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * GET, PUT, POST, DELETE
 *
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

@Slf4j
@RestController
@RequestMapping("/addressBookService")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    /**
     * HTTP Get Request
     *
     * @return ResponseEntity for getting data
     */

    @RequestMapping({"/get", "/"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookData;
        addressBookData = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO(Message.SUCCESS_CALL.getMessage(), addressBookData);
        log.info(Message.ALL_CONTACT_DETAIL.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Get Prequest for ID
     *
     * @return ResponseEntity for getting Id
     */
    @GetMapping("/get/{Id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("Id") int Id) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataById(Id);
        ResponseDTO responseDTO = new ResponseDTO(Message.GET_SUCCESSFUL_ID.getMessage(), addressBookData);
        log.info(Message.ALL_CONTACT_DETAIL_BY_ID.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**
     * Http Post request for updating data
     *
     * @param addressBookDTO
     * @return Updated Addressbook responseEntity with status ok.
     */
    @PostMapping("/createPost")
    public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.createAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO(Message.CREATE_NEW_CONTACT.getMessage(), addressBookData);
        log.info(Message.CONTACT_FOR_CREATING.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**
     * Http Put request gor updating data
     *
     * @param ID
     * @param addressBookDTO
     * @return Addressbook Entity with status Ok
     */
    @PutMapping("/updatePut/{ID}")
    public ResponseEntity<ResponseDTO> updateData(@PathVariable(value = "ID") int ID, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.updateData(ID, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO(Message.UPDATE_DATA_SUCCESSFUL.getMessage(), addressBookData);
        log.info(Message.ALL_CONTACT_DETAIL_UPDATED.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    /**
     * Http Delete request
     *
     * @param personId for deleting identity
     * @return ResponseEntity with status ok.
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteDataById(@PathVariable("personId") int personId) {
        addressBookService.deleteDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO(Message.DELETE_SUCCESSFUL.getMessage(), Message.DELETE_ID.getMessage() + personId);
        log.info(Message.CONTACT_DELETED_MESSAGE.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
