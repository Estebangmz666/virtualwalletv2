package com.github.estebangmz666.model;

import java.util.Objects;
import java.util.UUID;

public abstract class Admin extends Person {
    private AdminRole role;

    public Admin(UUID id, String email, String password, String fullName, String direction, String cellphone, AdminRole role) {
        super(id, email, password, fullName, direction, cellphone);
        this.role = role;
    }

    public AdminRole getRole() {
        return role;
    }

    public void setRole(AdminRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return role == admin.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role);
    }
}