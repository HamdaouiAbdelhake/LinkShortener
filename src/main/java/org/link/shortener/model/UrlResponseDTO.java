package org.link.shortener.model;

import java.time.LocalDateTime;

public class UrlResponseDTO {
    private Long id;
    private String url;
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UrlResponseDTO(Long id, String url, String code, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.url = url;
        this.code = code;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public String getUrl() {
        return url;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
