package com.mark.urlshorten.exception;

public class LinkExpiredException extends RuntimeException {

    public LinkExpiredException() {
        super("Short link has expired");
    }
}
