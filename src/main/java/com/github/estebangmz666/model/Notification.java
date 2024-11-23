package com.github.estebangmz666.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Notification {
    private UUID id;
    private String message;
    private LocalDateTime timeStamp;
    private User referencedUser;
    private boolean read;

    public Notification(UUID id, String message, LocalDateTime timeStamp, User referencedUser, boolean read) {
        this.id = id;
        this.message = message;
        this.timeStamp = timeStamp;
        this.referencedUser = referencedUser;
        this.read = read;
    }

    public Notification() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getReferencedUser() {
        return referencedUser;
    }

    public void setReferencedUser(User referencedUser) {
        this.referencedUser = referencedUser;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return read == that.read &&
                Objects.equals(id, that.id) &&
                Objects.equals(message, that.message) &&
                Objects.equals(timeStamp, that.timeStamp) &&
                Objects.equals(referencedUser, that.referencedUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, timeStamp, referencedUser, read);
    }
}