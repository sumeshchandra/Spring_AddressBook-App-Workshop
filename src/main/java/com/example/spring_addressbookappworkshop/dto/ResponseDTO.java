package com.example.spring_addressbookappworkshop.dto;

import lombok.Data;


/**
 *
 *
 * @author Sumesh Jena
 * @version 0.0.1
 * @since 13-10-2021
 */

@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
