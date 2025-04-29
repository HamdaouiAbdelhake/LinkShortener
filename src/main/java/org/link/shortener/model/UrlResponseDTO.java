package org.link.shortener.model;

import java.time.LocalDateTime;

public class UrlResponseDTO {
    private long id;
    private String url;
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UrlResponseDTO(long id, String url, String code, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.url = url;
        this.code = code;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


}
