package com.mark.urlshorten.exception;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException() {
        super("Short link not found");
    }
}
