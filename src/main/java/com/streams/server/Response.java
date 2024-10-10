package com.streams.server;

import java.util.HashMap;

public class Response {
    private String statusCode = "405 Method not allowed";
    private String message = "";
    private String contentType = "text/html";

    public void statusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void message(String message) {
        this.message = message;
    }

    public String statusCode() {
        return statusCode;
    }

    public String message() {
        return message;
    }

    public void contentType(String contentType) {
        this.contentType = contentType;
    }

    public String contentType() {
        return this.contentType;
    }
}
