package ru.turaev.storehouse.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.turaev.storehouse.exception.BaseException;
import ru.turaev.storehouse.exception.StorehouseNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionApiHandler {
    @ExceptionHandler(StorehouseNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(BaseException ex) {
        HttpStatus httpStatus = ex.getStatus();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", ex.getMessage());
        responseMap.put("exceptionTime", ex.getLocalDateTime());
        return new ResponseEntity<>(responseMap, httpStatus);
    }
}
