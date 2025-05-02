package org.link.shortener.exception;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(String message) {
        super(message);
    }
    public UrlNotFoundException(){ super("Url not found");}
}
