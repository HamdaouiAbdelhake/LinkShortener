package org.link.shortener.model;

import java.time.LocalDateTime;

public class StatisticsDTO {
    private Long id;
    private String url;
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long useCount;

    public StatisticsDTO(Long id, String url, String code, LocalDateTime createdAt, LocalDateTime updatedAt, Long useCount) {
        this.id = id;
        this.url = url;
        this.code = code;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.useCount = useCount;
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

    public Long getUseCount() {
        return useCount;
    }
}
