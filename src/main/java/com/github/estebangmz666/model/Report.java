package com.github.estebangmz666.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Report {
    private UUID id;
    private String type;
    private LocalDateTime generatedAt;
    private User user;
    private String content;

    public Report(UUID id, String type, LocalDateTime generatedAt, User user, String content) {
        this.id = id;
        this.type = type;
        this.generatedAt = generatedAt;
        this.user = user;
        this.content = content;
    }

    public Report() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(id, report.id) &&
                Objects.equals(type, report.type) &&
                Objects.equals(generatedAt, report.generatedAt) &&
                Objects.equals(user, report.user) &&
                Objects.equals(content, report.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, generatedAt, user, content);
    }
}