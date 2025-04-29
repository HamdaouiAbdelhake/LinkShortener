package org.link.shortener.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String link;

    @Column(unique = true)
    private String code;
    private long useCount;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Url(String link, String code, long useCount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.link = link;
        this.code = code;
        this.useCount = useCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getLink() {
        return link;
    }

    public String getCode() {
        return code;
    }

    public long getUseCount() {
        return useCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUseCount(long useCount) {
        this.useCount = useCount;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
