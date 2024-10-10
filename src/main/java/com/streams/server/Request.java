package com.streams.server;

import java.util.HashMap;

public class Request {
    private String httpMethod;
    private String uri;
    private HashMap<String, String> headers = new HashMap<>();

    public Request(String httpMethod, String uri) {
        this.httpMethod = httpMethod;
        this.uri = uri;
    }

    public String httpMethod() {
        return httpMethod;
    }

    public String uri() {
        return uri;
    }

    public HashMap<String, String> headers() {
        return headers;
    }

    /**
     * When running behind gateway that adds x-forwarded-for header
     * this method returns the client that connected to gateway.
     * @return empty String or ip of client.
     */
    public String forwardedFor(){
        return headers.getOrDefault("x-forwarded-for", "");
    }


}