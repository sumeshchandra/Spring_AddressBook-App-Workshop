package com.example.spring_addressbookappworkshop.exception;

import java.util.List;
import java.util.stream.Collectors;

import com.example.spring_addressbookappworkshop.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;


public class AddressBookExceptionHandler {

    public ResponseEntity<ResponseDTO> MethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMessage = errorList.stream().map(mapper -> mapper.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Request Failed", errMessage);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
