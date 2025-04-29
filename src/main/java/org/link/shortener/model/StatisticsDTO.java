package org.link.shortener.model;

import java.time.LocalDateTime;

public class StatisticsDTO {
    private long id;
    private String url;
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long useCount;

    public StatisticsDTO(long id, String url, String code, LocalDateTime createdAt, LocalDateTime updatedAt, long useCount) {
        this.id = id;
        this.url = url;
        this.code = code;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.useCount = useCount;
    }


}
