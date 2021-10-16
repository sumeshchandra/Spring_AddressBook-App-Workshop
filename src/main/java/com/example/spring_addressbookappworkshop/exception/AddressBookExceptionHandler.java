package com.example.spring_addressbookappworkshop.exception;

import java.util.List;
import java.util.stream.Collectors;

import com.example.spring_addressbookappworkshop.constant.Message;
import com.example.spring_addressbookappworkshop.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class AddressBookExceptionHandler {

    public ResponseEntity<ResponseDTO> MethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMessage = errorList.stream().map(mapper -> mapper.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(Message.REQUEST_FAILED.getMessage(), errMessage);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDTO> AddressBookException(AddressBookException exception) {
        ResponseDTO responseDTO = new ResponseDTO(Message.EXCEPTION_MESSAGE_WHILE_PROCESSING.getMessage(), exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
