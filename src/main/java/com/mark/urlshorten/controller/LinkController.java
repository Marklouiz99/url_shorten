package com.mark.urlshorten.controller;

import com.mark.urlshorten.dto.CreateLinkRequest;
import com.mark.urlshorten.dto.CreateLinkResponse;
import com.mark.urlshorten.service.LinkService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateLinkResponse createLink(@Valid @RequestBody CreateLinkRequest createLinkRequest) {
        return linkService.createLink(createLinkRequest);
    }
}
