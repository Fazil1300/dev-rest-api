package com.fazil.rest.api.demo.rest;

import java.util.Date;

public class StudentErrorResponse {
    private int statusCode;
    private String message;

    private Date date;

    public StudentErrorResponse() {

    }

    public StudentErrorResponse(int statusCode, String message, Date date) {
        this.statusCode = statusCode;
        this.message = message;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
