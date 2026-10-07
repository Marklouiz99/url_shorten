package com.mark.urlshorten.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
        name = "links",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_links_short_code",
                        columnNames = "short_code"
                )
        }
)
public class Link {
    @Id
    private long id;

    @Column(name = "short_code", nullable = false,unique = true,length = 32)
    private String shortCode;

    @Column(name = "original_url", nullable = false, columnDefinition = "TEXT")
    private String originalUrl;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "expires_at")
    private Instant expiresAt;

    @Column(name = "click_count", nullable = false)
    private long clickCount = 0;

    protected Link() {}

    public Link(String originalUrl, Instant createdAt) {
        this.originalUrl = originalUrl;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public long getClickCount() {
        return clickCount;
    }

    public boolean isExpired() {
        return expiresAt != null &&
                !Instant.now().isBefore(expiresAt);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }
}
