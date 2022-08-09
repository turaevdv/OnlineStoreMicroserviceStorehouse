package ru.turaev.storehouse.exception;

import org.springframework.http.HttpStatus;

public class AddressNotFoundException extends BaseException {
    public AddressNotFoundException() {
        this("Address not found");
    }

    public AddressNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
