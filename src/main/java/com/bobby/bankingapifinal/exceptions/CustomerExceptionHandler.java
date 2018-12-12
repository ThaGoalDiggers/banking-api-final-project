package com.bobby.bankingapifinal.exceptions;


import com.bobby.bankingapifinal.dto.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomerExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe, HttpServletRequest request) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setCode(HttpStatus.NOT_FOUND.value());
        errorDetail.setMessage(rnfe.getMessage());
        return  new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleErrorException( HttpServletRequest request) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setCode(HttpStatus.NOT_FOUND.value());
        errorDetail.setMessage("Error");
        return  new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }




}
