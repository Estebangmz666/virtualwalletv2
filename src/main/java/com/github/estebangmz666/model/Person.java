package com.github.estebangmz666.model;

import java.util.Objects;
import java.util.UUID;

public abstract class Person {
    private UUID id;
    private String email;
    private String password;
    private String fullName;
    private String direction;
    private String cellphone;

    public Person(UUID id, String email, String password, String fullName, String direction, String cellphone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.direction = direction;
        this.cellphone = cellphone;
    }

    public Person() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(email, person.email) &&
                Objects.equals(password, person.password) &&
                Objects.equals(fullName, person.fullName) &&
                Objects.equals(direction, person.direction) &&
                Objects.equals(cellphone, person.cellphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, fullName, direction, cellphone);
    }
}