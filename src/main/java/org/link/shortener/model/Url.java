package org.link.shortener.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Url {

    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName = "id_sequence",
            allocationSize = 1,
            initialValue = 160
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_sequence"
    )
    private Long id;

    private String link;

    @Column(unique = true)
    private String code;
    private Long useCount;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Url(String link, String code, Long useCount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.link = link;
        this.code = code;
        this.useCount = useCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Url() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getLink() {
        return link;
    }

    public String getCode() {
        return code;
    }

    public Long getUseCount() {
        return useCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUseCount(Long useCount) {
        this.useCount = useCount;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
