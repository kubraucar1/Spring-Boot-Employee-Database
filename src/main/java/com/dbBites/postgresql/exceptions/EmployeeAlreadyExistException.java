package com.dbBites.postgresql.exceptions;

public class EmployeeAlreadyExistException extends  RuntimeException{
    private String message;
    private int statusCode;



    public EmployeeAlreadyExistException(String msg,int statusCode)
    {
        super(msg);
        this.setMessage(msg);
    }
    public EmployeeAlreadyExistException(){

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
