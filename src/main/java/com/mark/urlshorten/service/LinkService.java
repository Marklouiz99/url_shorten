package com.mark.urlshorten.service;

import com.mark.urlshorten.dto.CreateLinkRequest;
import com.mark.urlshorten.dto.CreateLinkResponse;
import com.mark.urlshorten.entity.Link;
import com.mark.urlshorten.exception.LinkExpiredException;
import com.mark.urlshorten.exception.LinkNotFoundException;
import com.mark.urlshorten.repository.LinkRepository;
import com.mark.urlshorten.utility.Base62Encoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Transactional
    public CreateLinkResponse createLink(CreateLinkRequest createLinkRequest) {
        long id = linkRepository.nextId();

        Link link = new Link(createLinkRequest.originalUrl(), Instant.now());
        link.setId(id);
        link.setShortCode(Base62Encoder.encode(id));

        linkRepository.save(link);

        String shortUrl = "http://localhost:8080/" + link.getShortCode();
        return new CreateLinkResponse(link.getShortCode(), shortUrl);
    }

    @Transactional(readOnly = true)
    public Link getLinkByShortCode(String shortCode) {
        Link link = linkRepository.findByShortCode(shortCode)
                .orElseThrow(LinkNotFoundException::new);
        if(link.isExpired()) {
            throw new LinkExpiredException();
        }
        return link;
    }
}
