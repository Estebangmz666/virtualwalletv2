package com.github.estebangmz666.dto;

public class UserDTO {
    private String email;
    private String password;
    private String fullName;
    private String direction;
    private String cellphone;

    public UserDTO(String email, String password, String fullName, String direction, String cellphone) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.direction = direction;
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDirection() {
        return direction;
    }

    public String getCellphone() {
        return cellphone;
    }
}