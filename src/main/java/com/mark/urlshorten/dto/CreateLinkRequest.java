package com.mark.urlshorten.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateLinkRequest(
        @NotBlank
        @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
                message = "Invalid URL format")
        String originalUrl
){}
