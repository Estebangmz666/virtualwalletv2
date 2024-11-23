package com.github.estebangmz666.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class AssistantRecommendation {
    private UUID id;
    private String question;
    private String answer;
    private User user;
    private LocalDateTime generatedAt;

    public AssistantRecommendation(UUID id, String question, String answer, User user, LocalDateTime generatedAt) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.user = user;
        this.generatedAt = generatedAt;
    }

    public AssistantRecommendation() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssistantRecommendation that = (AssistantRecommendation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(question, that.question) &&
                Objects.equals(answer, that.answer) &&
                Objects.equals(user, that.user) &&
                Objects.equals(generatedAt, that.generatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, user, generatedAt);
    }
}