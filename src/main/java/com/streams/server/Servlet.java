package com.streams.server;

public class Servlet {

    void service(Request req, Response res) {
        if (req.httpMethod().equals("GET"))
            doGet(req, res);
        else
            res.statusCode("405 Method Not Allowed");
    }

    void doGet(Request req, Response res) {
        res.statusCode("200 OK");
        res.contentType("text/html");
        res.message("""
                <!DOCTYPE html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <title>Hello World</title>
                  </head>
                  <body>
                    Hello World
                  </body>
                </html>
                """);
    }

    void doPost(Request req, Response res) {

    }
}