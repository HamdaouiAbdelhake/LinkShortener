package org.link.shortener.exception;

public class ErrorDetails {
    private String ErrorDetails;

    public ErrorDetails(String errorDetails) {
        ErrorDetails = errorDetails;
    }

    public String getErrorDetails() {
        return ErrorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        ErrorDetails = errorDetails;
    }
}
