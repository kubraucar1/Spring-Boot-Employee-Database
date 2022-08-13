package com.dbBites.postgresql.advice;

import com.dbBites.postgresql.Employee.Employee;
import com.dbBites.postgresql.exceptions.EmployeeAlreadyExistException;
import com.dbBites.postgresql.exceptions.ErrorResponse;
import com.dbBites.postgresql.exceptions.stringLengthTooSmallException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@org.springframework.web.bind.annotation.ControllerAdvice

public class ControllerAdvice {

/*
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException runtimeException) {
        return new ResponseEntity<String>("The Employe record is already exist in the database", HttpStatus.BAD_REQUEST);
    }

*/
    @ExceptionHandler(value = stringLengthTooSmallException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(stringLengthTooSmallException ex) {
        return new ErrorResponse("lenght of name must be greater than 2",233);
    }

    @ExceptionHandler(value = EmployeeAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleEmployeeAlreadyExistException(EmployeeAlreadyExistException ex) {
        return new ErrorResponse("The Employe record is already exist in the database ",1);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleRuntimeException(ConstraintViolationException constraintViolationException) {
        return new ResponseEntity<String>("The lenght of name and surname must be greater than 2", HttpStatus.BAD_REQUEST);
    }



}



