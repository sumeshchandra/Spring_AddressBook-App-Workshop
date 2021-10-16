package com.example.spring_addressbookappworkshop.constant;

public enum Message {
    NAME_NOT_PROPER("Name is not proper"),
    ID_NOT_FOUND("Id not found."),
    EXCEPTION_MESSAGE_WHILE_PROCESSING("Exception while processing rest request"),
    REQUEST_FAILED("Request Failed"),
    SUCCESS_CALL("Get Success Call"),
    ALL_CONTACT_DETAIL("All contact details"),
    ALL_CONTACT_DETAIL_BY_ID("All contact details b ID"),
    ALL_CONTACT_DETAIL_UPDATED("All contact details for updating"),
    GET_SUCCESSFUL_ID("Get successful for id : "),
    CREATE_NEW_CONTACT("Created new contact "),
    CONTACT_FOR_CREATING("All contact details for creating"),
    UPDATE_DATA_SUCCESSFUL("Updated Data successful : "),
    DELETE_SUCCESSFUL("Deleted Successfully"),
    DELETE_ID("Deleted id: "),
    CONTACT_DELETED_MESSAGE("contact deleted successfully"),


    ;

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
