package com.dbBites.postgresql.exceptions;




public class ErrorResponse {
    
    
    private int statusCode;
    private String message;

    public ErrorResponse(String message,int statusCode)
    {
        super();
        this.setMessage(message);
        this.setStatusCode(statusCode);
    }
    public ErrorResponse(){

    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
