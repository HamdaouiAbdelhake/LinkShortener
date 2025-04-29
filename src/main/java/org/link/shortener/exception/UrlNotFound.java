package org.link.shortener.exception;

public class UrlNotFound extends RuntimeException {
    public UrlNotFound(String message) {
        super(message);
    }
    public UrlNotFound(){ super("Url not found");}
}
