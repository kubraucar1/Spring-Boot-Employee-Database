package com.dbBites.postgresql.exceptions;


public class stringLengthTooSmallException extends RuntimeException {

    private String message;
    private int statusCode;



    public stringLengthTooSmallException(String msg,int statusCode)
    {
        super(msg);
        this.setMessage(msg);
    }
    public stringLengthTooSmallException(){

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
