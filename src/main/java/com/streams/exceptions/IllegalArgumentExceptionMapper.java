package com.streams.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
    @Override
    public Response toResponse(IllegalArgumentException exception) {
        ErrorMessage errorMessage = new ErrorMessage("NOT_FOUND", exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }

    public static class ErrorMessage {
        private String status;
        private String message;

        public ErrorMessage(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}