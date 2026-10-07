package com.mark.urlshorten.dto;

public record CreateLinkResponse(
        String shortCode,
        String originalUrl
) {}
